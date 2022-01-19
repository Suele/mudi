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

	@Column(name = "product_name", length = 50, nullable = false)
	private String productName;

	@Column(nullable = false)
	private String description;

	@Column(name = "url_product", nullable = false)
	private String urlProduct;

	@Column(name = "url_image", nullable = false)
	private String urlImage;

	@ManyToOne
	@JoinColumn(name = "delivery_id")
	private DeliveryModel delivery;

	@Column(name = "state_delivery", nullable = false)
	@Enumerated(EnumType.STRING)
	private StateDelivery stateDelivery;

	@ManyToOne
	@JoinColumn(name = "user", nullable = false)
	private UserModel user;

	public ProductModel() {
	}

	public ProductModel(String productName, LocalDate deliveryDate,
						String description, String urlProduct, String urlImage) {
		this.productName = productName;
		this.description = description;
		this.urlProduct = urlProduct;
		this.urlImage = urlImage;
	}

	public ProductModel(String productName, String urlProduct,
						String urlImage, String description,
						StateDelivery stateDelivery, UserModel user) {
		this.productName = productName;
		this.urlProduct = urlProduct;
		this.urlImage = urlImage;
		this.delivery = delivery;
		this.description = description;
		this.stateDelivery = stateDelivery;
		this.user = user;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public DeliveryModel getDelivery() {
		return delivery;
	}

	public void setDelivery(DeliveryModel delivery) {
		this.delivery = delivery;
	}

	public StateDelivery getStateDelivery() {
		return stateDelivery;
	}

	public void setStateDelivery(StateDelivery stateDelivery) {
		this.stateDelivery = stateDelivery;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ProductModel{" +
				"productId=" + productId +
				", productName='" + productName + '\'' +
				", description='" + description + '\'' +
				", urlProduct='" + urlProduct + '\'' +
				", urlImage='" + urlImage + '\'' +
				", delivery=" + delivery +
				", stateDelivery=" + stateDelivery +
				", user=" + user +
				'}';
	}
}