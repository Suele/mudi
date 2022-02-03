package com.world.mudi.service;

import com.world.mudi.model.ProductModel;
import com.world.mudi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRequestService {
	@Autowired
	private ProductRepository productRepository;

	public List<ProductModel> listsAllProducts() {
		return productRepository.findAllStateDelivery("AGUARDANDO");
	}

	public List<ProductModel> listAllProductsByUser(String username) {
		return productRepository.findAllByUser(username);
	}

	public ProductModel registerProduct(ProductModel newProduct) {
		return productRepository.save(newProduct);
	}
}