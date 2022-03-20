package com.madhur.product.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhur.product.entity.Product;
import com.madhur.product.repository.ProductRepository;
import com.madhur.product.service.IProductService;

@Service
@Transactional
public class ProductService implements IProductService {

	@Autowired
	ProductRepository repoObj;

	@Override
	public String addProduct(Product product) {
		repoObj.save(product);

		return "Product Added";
	}

	@Override
	public List<Product> getAllPrioducts() {
		List<Product> list = repoObj.findAll();
		return list;
	}

	@Override
	public Product getById(int id) {
		return repoObj.getById(id);
	}

	@Override
	public Object updateProducts(int id,int quantity) {

		Optional<Product> p;
		p = repoObj.findById(id);
		Product p1 = new Product();
		p1.setId(p.get().getId());
		p1.setName(p.get().getName());
		p1.setQuantity(quantity);

		repoObj.save(p1);

		return "Product Quantity updated";
	}

	@Override
	public String deletProduct(int id) {
		repoObj.deleteById(id);

		return "Product Deleted Successfully";
	}

}
