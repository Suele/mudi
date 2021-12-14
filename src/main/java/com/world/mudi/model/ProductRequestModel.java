package com.world.mudi.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "ProductRequestEntity")
@Table(name = "product_request")
public class ProductRequestModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "product_name")
	private String productName;

	private Double price;

	@Column(name = "delivery_date")
	private LocalDate deliveryDate;

	private String description;

	@Column(name = "url_product")
	private String urlProduct;

	@Column(name = "url_image")
	private String urlImage;

	public ProductRequestModel() {
	}

	public ProductRequestModel(String productName, LocalDate deliveryDate,
							   Double price, String description, String urlProduct, String urlImage) {
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