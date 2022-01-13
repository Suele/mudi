package com.world.mudi.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "ProductEntity")
@Table(name = "product")
public class ProductModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", nullable = false)
	private Long productId;

	@Column(name = "product_name", nullable = false)
	private String productName;

	@Column(nullable = false)
	private Double price;

	@Column(nullable = false)
	private String description;

	@Column(name = "url_product", nullable = false)
	private String urlProduct;

	@Column(name = "url_image", nullable = false)
	private String urlImage;

	@ManyToOne
	@JoinColumn(name = "delivery_id", nullable = false)
	private DeliveryModel delivery;

	public ProductModel() {
	}

	public ProductModel(String productName, LocalDate deliveryDate,
						Double price, String description, String urlProduct, String urlImage) {
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.urlProduct = urlProduct;
		this.urlImage = urlImage;
	}

	public ProductModel(String productName, String urlProduct,
						String urlImage, String description) {
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

	@Override
	public String toString() {
		return "Product{" +
				"productId:" + productId +
				", productName:'" + productName + '\'' +
				", price:" + price +
				", description:'" + description + '\'' +
				", urlProduct:'" + urlProduct + '\'' +
				", urlImage:" + urlImage + '\'' +
				'}';
	}
}