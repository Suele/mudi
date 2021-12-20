package com.world.mudi.dto;

import com.world.mudi.model.ProductRequestModel;

public class RegisterNewProductDTO {
	private String productName;
	private String urlProduct;
	private String urlImage;
	private String description;

	public ProductRequestModel toNewProduct() {
		ProductRequestModel productRequestModel = new ProductRequestModel(this.productName,
				this.urlProduct, this.urlImage, this.description);
		return productRequestModel;
	}
}