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
		return productRequestRepository.findAll();
	}
}