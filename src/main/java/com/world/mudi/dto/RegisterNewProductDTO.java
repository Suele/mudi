package com.world.mudi.dto;

import com.world.mudi.model.ProductRequestModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegisterNewProductDTO {
	@Size(min = 3, max = 50)
	@NotBlank(message = "Nome do produto é obrigatório")
	private String productName;

	@Size(max = 200)
	@NotBlank(message = "URL do produto é obrigatória.")
	private String urlProduct;

	@Size(max = 200)
	@NotBlank(message = "URL da imagem do produto é obrigatória.")
	private String urlImage;

	@Size(max = 150)
	@NotBlank(message = "A descrição do produto é obrigatório.")
	private String description;

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

	public ProductRequestModel toNewProduct() {
		ProductRequestModel productRequestModel = new ProductRequestModel(this.productName,
				this.urlProduct, this.urlImage, this.description);
		return productRequestModel;
	}
}