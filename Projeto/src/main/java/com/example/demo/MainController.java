package com.example.demo;

import java.util.List;

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

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private WorkerRepository workerRepository;

	@Autowired
	private HistoryRepository historyRepository;

	@GetMapping(path = "/")
	public String getAllDeps(Model model) {
		model.addAttribute("ListUsers", userRepository.findAll());
		return "index";
	}

	@GetMapping("/Register")
	public String register(Model model) {
		User user = new User();
		model.addAttribute("newUser", user);
		return "register";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("newUser") User user) {
		List<User> users = userRepository.findByEmail(user.getEmail());
		if (users.size() != 0) {
			System.out.println("User ja existe");
		}
		userRepository.save(user);
		return "redirect:/";
	}

	@GetMapping("/Login")
	public String login(Model model) {
		User user = new User();
		//testee
		model.addAttribute("user", user);
		return "login";
	}

	@PostMapping("/validateUser")
	public String validateUser(@ModelAttribute("user") User user) {
		List<User> users = userRepository.findByEmail(user.getEmail());
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getPassword().equals(user.getPassword())) {
				return "redirect:/";
			}
		}
		return "login";
	}

	@GetMapping("/NewService")
	public String newService(Model model) {
		Service service = new Service();
		model.addAttribute(service);
		return "newService";
	}

}
