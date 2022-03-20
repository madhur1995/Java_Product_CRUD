package com.madhur.product.service;

import java.util.List;

import com.madhur.product.entity.Product;

public interface IProductService {

	String addProduct(Product product);

	List<Product> getAllPrioducts();

	Product getById(int id);

	Object updateProducts(int id, int quantity);

	String deletProduct(int id);

}
