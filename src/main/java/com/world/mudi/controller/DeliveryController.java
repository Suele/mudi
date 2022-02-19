package com.world.mudi.controller;

import com.world.mudi.dto.DeliveryDTO;
import com.world.mudi.service.ProductRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {
	@Autowired
	private ProductRequestService productRequestService;

	@GetMapping("/{productId}")
	public String formDelivery(@PathVariable("productId") Long productId, Model model) {
		model.addAttribute("product", productRequestService.findByIdProduct(productId).get());
		return "delivery";
	}

	@PostMapping
	public String newDelivery(@Valid DeliveryDTO deliveryDTO) {
		return "redirect:/home";
	}
}