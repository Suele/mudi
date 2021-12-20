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

	public ProductRequestModel(String productName, String urlProduct, String urlImage, String description) {
		this.productName = productName;
		this.urlProduct = urlProduct;
		this.urlImage = urlImage;
		this.description = description;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlProduct() {
		return urlProduct;
	}

	public void setUrlProduct(String urlProduct) {
		this.urlProduct = urlProduct;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}