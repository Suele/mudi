package com.world.mudi.dto;

import com.world.mudi.model.UserModel;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class RegisterUserDTO {

	@NotBlank(message = "O nome é obrigatório.")
	private String firstName;

	@NotBlank(message = "O sobrenome é obrigatório.")
	private String lastName;

	@NotBlank(message = "O nome do usuário é obrigatório.")
	private String username;

	@Email(message = "O email é obrigatório.")
	private String email;

	@NotBlank(message = "A senha é obrigatória")
	private String password;

	public RegisterUserDTO() {
	}

	public RegisterUserDTO(String firstName, String lastName, String username,
						   String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserModel toNewUser() {
		UserModel user = new UserModel(this.firstName, this.lastName,
				this.username, this.email, this.password);
		return user;
	}
}