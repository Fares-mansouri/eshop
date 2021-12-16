package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import model.Product;
import repository.ProductRepository;

public class ProductServiceImpl  implements ProductService{
 
	@Autowired
	private ProductRepository productRepository;
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

}
