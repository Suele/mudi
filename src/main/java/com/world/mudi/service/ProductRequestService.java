package com.world.mudi.service;

import com.world.mudi.model.ProductRequestModel;
import com.world.mudi.repository.ProductRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRequestService {
	@Autowired
	private ProductRequestRepository productRequestRepository;

	public List<ProductRequestModel> listProducts() {
		if (productRequestRepository.findAll().size() == 0) {
			throw new RuntimeException("Nenhum produto foi encontrado.");
		}
		return productRequestRepository.findAll();
	}

	public ProductRequestModel registerProduct(ProductRequestModel newProduct) {
		if (newProduct.getProductName().isBlank() ||
				newProduct.getUrlProduct().isBlank() ||
				newProduct.getUrlImage().isBlank() || newProduct.getDescription().isBlank()) {
			throw new NullPointerException("Verifique se todos os campos do formulario foram preenchidos.");
		}
		return productRequestRepository.save(newProduct);
	}
}