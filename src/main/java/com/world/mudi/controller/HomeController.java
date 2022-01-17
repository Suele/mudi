package com.world.mudi.controller;

import com.world.mudi.model.ProductModel;
import com.world.mudi.service.ProductRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {
	@Autowired
	private ProductRequestService productRequestService;

	@GetMapping("/home")
	public String home(Model model, Principal principal) {
		List<ProductModel> listProductRequest = productRequestService.listProducts(principal.getName());
		model.addAttribute("listProductRequest", listProductRequest);
		return "home";
	}
}