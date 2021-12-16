package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import repository.ProductRepository;
import service.ProductService;

@Controller
public class ProductController {
	
	private ProductRepository pr;

	@Autowired
	private ProductService productService;
	
	@GetMapping("/Products")
	public String ViewHomePage(Model model) {
		
		model.addAttribute("listProducts", pr.findAll() );
		return "Products";
	}
}
