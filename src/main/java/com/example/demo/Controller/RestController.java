package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.User;
import com.example.demo.services.UserService;

@org.springframework.web.bind.annotation.RestController
//The @RestController annotation in Spring MVC is nothing but a combination of @Controller and @ResponseBody
public class RestController {
	
	@Autowired
	private UserService UserService;
	
	
	@GetMapping("/")
	public String hello() {
		return "This is home page";
	}
	
	
	@GetMapping("/saveuser")
	public String saveUser(@RequestParam String username, @RequestParam String firstname, @RequestParam String lastname,
			@RequestParam int age, @RequestParam String password) {
		User user = new User(username, firstname, lastname, age, password);
		UserService.saveMyUser(user);
		return "User Saved";
	}

}
