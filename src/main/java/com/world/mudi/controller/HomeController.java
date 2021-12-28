package com.world.mudi.controller;

import com.world.mudi.model.ProductRequestModel;
import com.world.mudi.service.ProductRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
	@Autowired
	private ProductRequestService productRequestService;

	@GetMapping("/home")
	public String home(Model model) {
		List<ProductRequestModel> listProductRequest = productRequestService.listProducts();
		model.addAttribute("listProductRequest", listProductRequest);
		return "home";
	}
}