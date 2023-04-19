package com.webtoeic.controller;

import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	// duoc su dung de dang nhap bang cho cac nha cung cap dich vu bang OAuth2 nhu facebook, google
	private final InMemoryClientRegistrationRepository clientRegistrationRepository;

	public LoginController(InMemoryClientRegistrationRepository clientRegistrationRepository) {
		this.clientRegistrationRepository = clientRegistrationRepository;
	}

	@GetMapping("/signin")
	public String loginPage(Model model) {
		return "login";
	}
	
	@GetMapping("/login")
	public String loginPageForward(Model model) {
		return "redirect:/signin?accessDenied";
	}

}
