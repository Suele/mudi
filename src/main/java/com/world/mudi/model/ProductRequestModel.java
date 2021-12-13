package com.world.mudi.model;

import java.time.LocalDate;

public class ProductRequestModel {
	private Long id;
	private String productName;
	private Double price;
	private LocalDate deliveryDate;
	private String description;
	private String urlProduct;
	private String urlImage;

	public ProductRequestModel(String productName, LocalDate deliveryDate, Double price, String description,
							   String urlProduct, String urlImage) {
		this.productName = productName;
		this.price = price;
		this.deliveryDate = deliveryDate;
		this.description = description;
		this.urlProduct = urlProduct;
		this.urlImage = urlImage;
	}

	public String getProductName() {
		return productName;
	}

	public Double getPrice() {
		return price;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public String getDescription() {
		return description;
	}

	public String getUrlProduct() {
		return urlProduct;
	}

	public String getUrlImage() {
		return urlImage;
	}
}
