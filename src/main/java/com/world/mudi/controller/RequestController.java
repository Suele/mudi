package com.world.mudi.controller;

import com.world.mudi.model.ProductModel;
import com.world.mudi.model.StateDelivery;
import com.world.mudi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/request")
public class RequestController {
	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public String newRequest(Model model, Principal principal) {
		List<ProductModel> listProducts = productRepository.findAllByUser(principal.getName());
		model.addAttribute("listProducts", listProducts);
		return "/request";
	}

	@GetMapping("/{statusRequest}")
	public String searchByStatus(@PathVariable("statusRequest") String statusRequest,
								 Model model, Principal principal) {

		List<ProductModel> listProducts = productRepository.
				findAllStatusRequestAndUser(StateDelivery.valueOf(statusRequest.toUpperCase()),
						principal.getName());

		model.addAttribute("listProducts", listProducts);
		model.addAttribute("statusRequest", statusRequest);
		return "/request";
	}
}