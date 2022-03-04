package com.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

	List<Product> findBypName(String product1);
	
	public Product findBypSellerId(int id);
	
	//public List<Product> findByCategoryid(int id);

}
