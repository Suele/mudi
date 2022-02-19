package com.world.mudi.dto;

import com.world.mudi.model.DeliveryModel;
import com.world.mudi.model.ProductModel;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class DeliveryDTO {

	@NotNull(message = "A data de envio é obrigatória")
	private LocalDate deliveryDate;

	@NotNull(message = "O preço do produto é obrigatório.")
	private BigDecimal priceConcerted;

	private List<ProductModel> products;

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public BigDecimal getPriceConcerted() {
		return priceConcerted;
	}

	public void setPriceConcerted(BigDecimal priceConcerted) {
		this.priceConcerted = priceConcerted;
	}

	public List<ProductModel> getProducts() {
		return products;
	}

	public void setProducts(List<ProductModel> products) {
		this.products = products;
	}

	public DeliveryModel toNewDelivery() {
		DeliveryModel deliveryModel = new DeliveryModel(this.deliveryDate, this.priceConcerted, this.products);
		return deliveryModel;
	}
}