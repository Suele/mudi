package com.world.mudi.controller;

import com.world.mudi.model.ProductRequestModel;
import com.world.mudi.service.ProductRequestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
		ProductRequestModel productRequest1 = new ProductRequestModel("nomeDoProduto", LocalDate.now(),
				670.0, "description", "urlProduct", "urlImage");

		ProductRequestModel productRequest2 = new ProductRequestModel("nomeDoProduto", LocalDate.now(),
				700.0, "description", "urlProduct", "urlImage");

		List<ProductRequestModel> listProduct = Arrays.asList(productRequest1, productRequest2);

		when(this.productRequestService.listProducts()).thenReturn(listProduct).getMock();
		this.mockMvc.perform(MockMvcRequestBuilders.get("/home"))
				.andExpect(MockMvcResultMatchers.view().name("home")).andReturn().getResponse();
	}
}