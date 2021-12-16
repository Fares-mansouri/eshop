package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ProductRepositoryTests {
	
	@Autowired
	private ProductRepository repos;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test 
	public void testCreateProduct() {
		Products products = new Products();
		products.setModelName("Product5");
		products.setPrice(1000);
		products.setQte("7");
		
		Products savedProducts = repos.save(products);
		
		Products existProducts =  entityManager.find(Products.class, savedProducts.getId());
		
		assertThat(existProducts.getModelName()).isEqualTo(products.getModelName());
	}
}
