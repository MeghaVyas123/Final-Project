package com.ecom.service;

import java.util.List;

import com.ecom.entity.Product;
import com.ecom.entity.PurchaseHistory;

public interface IService {
	
	public List<Product> findAll();
	
	public Product find(int id);
	
	public List<Product> serch(String product1) ;
	
	public String addShoppinrgCart(int id,int id1);
	
	public List<Product> shoppinrgCart();
	
	public String removeShoppinrgCart(int id);
	
	public Product postProduc(Product product);
	
	public Product FindProduct(int id);
	
	public String deleteById(int id);
	
	public List<PurchaseHistory> history();
	
	public String purchaseProduct(int id,int quentity);
	
	public List<Product> serchProductByCatagory(int id);


}
