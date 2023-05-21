package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping(path = "/")
	public String getAllDeps(Model model) {
		model.addAttribute("ListUsers", userRepository.findAll());
		return "index";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("newUser") User user) {
		userRepository.save(user);
		return "redirect:/";
	}

	@GetMapping("/register")
	public String register(Model model) {
		User user = new User();
		model.addAttribute("newUser", user);
		return "register";
	}

}
