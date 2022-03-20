package com.madhur.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.madhur.product.entity.Product;
import com.madhur.product.service.IProductService;

@RestController
@RequestMapping("/Product")
class ProductController {

	@Autowired
	IProductService serviceObj;

	@PostMapping("/add")
	public ResponseEntity<String> registerStudent(@RequestBody Product product) {
		return new ResponseEntity<String>(serviceObj.addProduct(product), HttpStatus.ACCEPTED);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Product>> allStudent() {

		return new ResponseEntity<List<Product>>(serviceObj.getAllPrioducts(), HttpStatus.ACCEPTED);

	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Product> proById(@PathVariable("id") int id) {

		return new ResponseEntity<Product>(serviceObj.getById(id), HttpStatus.OK);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateQuantity(@PathVariable("id") int id, @RequestParam int quantity) {
		return new ResponseEntity<>(serviceObj.updateProducts(id,quantity), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
		return new ResponseEntity<String>(serviceObj.deletProduct(id), HttpStatus.ACCEPTED);

	}

}
