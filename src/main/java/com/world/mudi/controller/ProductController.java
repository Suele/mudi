package com.world.mudi.controller;

import com.world.mudi.dto.RegisterNewProductDTO;
import com.world.mudi.service.ProductRequestService;
import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping("/new-product")
	public String newProduct(RegisterNewProductDTO registerNewProductDTO) {
		return "newProduct";
	}

	@PostMapping("/new-product-register")
	public String registerNewProduct(@Valid RegisterNewProductDTO registerNewProductDTO, BindingResult result) {
		if (result.hasErrors()) {
			return "newProduct";
		}
		productRequestService.registerProduct(registerNewProductDTO.toNewProduct());
		return "newProduct";
	}
}