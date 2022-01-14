package com.world.mudi.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "DeliveryEntity")
@Table(name = "delivery")
public class DeliveryModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "delivery_id", nullable = false)
	private Long deliveryId;

	@Column(nullable = false)
	private LocalDate deliveryDate;

	@Column(name = "state_delivery", nullable = false)
	@Enumerated(EnumType.STRING)
	private StateDelivery stateDelivery;

	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			mappedBy = "delivery")
	private List<ProductModel> products;

	public DeliveryModel() {
	}

	public DeliveryModel(Long deliveryId, LocalDate deliveryDate,
						 StateDelivery stateDelivery, List<ProductModel> products) {
		this.deliveryId = deliveryId;
		this.deliveryDate = deliveryDate;
		this.stateDelivery = stateDelivery;
		this.products = products;
	}

	public Long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public StateDelivery getStateDelivery() {
		return stateDelivery;
	}

	public void setStateDelivery(StateDelivery stateDelivery) {
		this.stateDelivery = stateDelivery;
	}

	public List<ProductModel> getProducts() {
		return products;
	}

	public void setProducts(List<ProductModel> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Delivery{" +
				"deliveryId:" + deliveryId +
				", deliveryDate:" + deliveryDate +
				", stateDelivery:" + stateDelivery +
				", products:" + products +
				'}';
	}
}
