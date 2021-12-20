package com.world.mudi.controller;

import com.world.mudi.dto.RegisterNewProductDTO;
import com.world.mudi.service.ProductRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	private ProductRequestService productRequestService;

	@GetMapping("/new-product")
	public String newProduct() {
		return "newProduct";
	}

	@PostMapping("/new-product-register")
	public String registerNewProduct(RegisterNewProductDTO registerNewProductDTO) {
		productRequestService.registerProduct(registerNewProductDTO.toNewProduct());
		return "newProduct";
	}
}