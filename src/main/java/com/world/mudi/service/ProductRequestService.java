package com.world.mudi.service;

import com.world.mudi.model.ProductModel;
import com.world.mudi.repository.ProductRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRequestService {
	@Autowired
	private ProductRequestRepository productRequestRepository;

	public List<ProductModel> listProducts() {
		return productRequestRepository.findAll();
	}

	public ProductModel registerProduct(ProductModel newProduct) {
		return productRequestRepository.save(newProduct);
	}
}