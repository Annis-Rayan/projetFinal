package projetFinalBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Authentification {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/home")
	public String homeGet() {
		return "home";
	}

	@GetMapping("/logoutForm")
	public String logout() {
		return "logout";
	}
}
