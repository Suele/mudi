package com.world.mudi.dto;

import com.world.mudi.model.ProductModel;
import com.world.mudi.model.StateDelivery;
import com.world.mudi.model.UserModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterNewProductDTO {
	@Size(min = 3, max = 50)
	@NotBlank(message = "Nome do produto é obrigatório")
	private String productName;

	@Size(min = 10, max = 255)
	@NotBlank(message = "URL do produto é obrigatória.")
	private String urlProduct;

	@Size(min = 10, max = 255)
	@NotBlank(message = "URL da imagem do produto é obrigatória.")
	private String urlImage;

	@Size(min = 5, max = 255)
	@NotBlank(message = "A descrição do produto é obrigatória.")
	private String description;

	private StateDelivery stateDelivery = StateDelivery.AGUARDANDO;

	@NotNull(message = "O usuario é obrigatório")
	private UserModel user;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public StateDelivery getStateDelivery() {
		return stateDelivery;
	}

	public ProductModel toNewProduct() {
		ProductModel productRequestModel = new ProductModel(this.productName,
				this.urlProduct, this.urlImage, this.description, this.stateDelivery, this.user);
		return productRequestModel;
	}
}