package com.world.mudi.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "UserEntity")
@Table(name = "users")
public class UserModel {
	@Id
	@Column(length = 90, unique = true, nullable = false)
	private String username;

	@Column(length = 100, unique = true, nullable = false)
	private String password;

	@Column(nullable = false)
	private Boolean enabled;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<ProductModel> products;

	public UserModel() {
	}

	public UserModel(String username, String password, Boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<ProductModel> getProducts() {
		return products;
	}

	public void setProducts(List<ProductModel> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "User{" +
				"username:'" + username + '\'' +
				", password:'" + password + '\'' +
				", enabled:" + enabled +
				", products:" + products +
				'}';
	}
}