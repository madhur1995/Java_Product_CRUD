package com.madhur.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madhur.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
