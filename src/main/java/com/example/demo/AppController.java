package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import model.Product;
 
@Controller
public class AppController {
	@Autowired
    private UserRepository userRepo;
	private ProductRepository pr;
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
         
        return "signup_form";
    }
    
    @PostMapping("/process_register")
    
    public String processRegister(User user) {
         BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
         String encoderPassword = encoder.encode(user.getPassword());
         user.setPassword(encoderPassword);
        userRepo.save(user);
         
        return "register_success";
    }
    
    @GetMapping("/Products")
    public String viewProductPage(Model model) {
    //	 List<Products> product = this.pr.findAll();
    	// model.addAttribute("listProducts", product);
        return "Products";
        }
}