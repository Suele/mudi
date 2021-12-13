package com.world.mudi.controller;

import com.world.mudi.model.ProductRequestModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Model model) {
		ProductRequestModel productRequest = new ProductRequestModel("Retro Pulse Vitrola Perkins",
				LocalDate.of(2021, 11, 21),
				500.00,
				"Visual retrô, a vitrola PERKINS te faz reviver os bons e velhos tempos sem deixar a modernidade de lado. Ouça sua playlist favorita com máxima qualidade de som.",
				" https://www.amazon.com.br/Retro-Pulse-Vitrola-Perkins-SP365/dp/B08D7XK9J4/ref=sr_1_9?__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&keywords=vinil&qid=1639415265&sr=8-9&ufe=app_do%3Aamzn1.fos.25548f35-0de7-44b3-b28e-0f56f3f96147 ",
				" https://m.media-amazon.com/images/I/51dZ173LoIL._AC_SL1000_.jpg ");

		List<ProductRequestModel> listProductRequest = Arrays.asList(productRequest);
		model.addAttribute("listProductRequest", listProductRequest);
		return "home";
	}
}
