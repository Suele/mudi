package com.world.mudi.controller;

import com.world.mudi.dto.RegisterNewProductDTO;
import com.world.mudi.model.UserModel;
import com.world.mudi.repository.UserRepository;
import com.world.mudi.service.ProductRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	private ProductRequestService productRequestService;
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/new-product")
	public String newProduct(RegisterNewProductDTO registerNewProductDTO) {
		return "newProduct";
	}

	@PostMapping("/new-product-register")
	public String registerNewProduct(@Valid RegisterNewProductDTO registerNewProductDTO, BindingResult result) {
		System.out.println("registerNewProductDTO: " + registerNewProductDTO.getStateDelivery());
//		if (result.hasErrors()) {
//			return "newProduct";
//		}
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		UserModel user = userRepository.findByUsername(username);

		registerNewProductDTO.setUser(user);
		productRequestService.registerProduct(registerNewProductDTO.toNewProduct());
		return "home";
	}
}