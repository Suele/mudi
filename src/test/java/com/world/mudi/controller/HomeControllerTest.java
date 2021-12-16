package com.world.mudi.controller;

import com.world.mudi.repository.ProductRequestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = HomeController.class)
public class HomeControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductRequestRepository productRequestRepository;

	@Test
	public void urlPageHomeExist() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/home"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("home")).andReturn().getRequest();
	}
}
