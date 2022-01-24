package com.world.mudi.controller;

import com.world.mudi.dto.RegisterUserDTO;
import com.world.mudi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping
	public String formRegisterUser(RegisterUserDTO registerUserDTO) {
		return "register";
	}

	@PostMapping
	public String registerUser(@Valid RegisterUserDTO registerUserDTO, BindingResult result) {
		System.out.println("");
		System.out.println(">>>>>>> result: " + result);
		System.out.println("");
		if (result.hasErrors()) {
			return "register";
		}
		userService.registerUser(registerUserDTO.toNewUser());
		return "redirect:/home";
	}
}