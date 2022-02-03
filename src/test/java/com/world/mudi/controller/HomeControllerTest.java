package com.world.mudi.controller;

import com.world.mudi.model.ProductModel;
import com.world.mudi.service.ProductRequestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(controllers = HomeController.class)
public class HomeControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductRequestService productRequestService;

	@Test
	public void url_home_exist() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/home"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("home")).andReturn().getResponse();
	}

	@Test
	public void list_products_registered() throws Exception {
		ProductModel productRequest1 = new ProductModel("nomeDoProduto", LocalDate.now(),
				"description", "urlProduct", "urlImage");

		ProductModel productRequest2 = new ProductModel("nomeDoProduto", LocalDate.now(),
				"description", "urlProduct", "urlImage");

		List<ProductModel> listProduct = Arrays.asList(productRequest1, productRequest2);


		Principal principal = null;
		when(this.productRequestService.listAllProductsByUser(principal.getName())).thenReturn(listProduct).getMock();
		this.mockMvc.perform(MockMvcRequestBuilders.get("/home"))
				.andExpect(MockMvcResultMatchers.view().name("home")).andReturn().getResponse();
	}
	// TODO testar pagina home não for encontrada.
	// TODO Lista de produtos estiver vazia.
}