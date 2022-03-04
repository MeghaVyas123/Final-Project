package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.ecom.entity.Product;
import com.ecom.entity.PurchaseHistory;
import com.ecom.service.IServiceImpl;

@RestController
public class BuyerController {
	@Autowired
	IServiceImpl service;
	
	
//	Can search for Products
	@GetMapping("/serchProductByName/{product}")
	public List<Product> serchProduct(@PathVariable("product") String product) {
		
		List<Product> serch = service.serch(product);
		return serch;
		
	}
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello Hello";
	}
//	Can search for Products
	@GetMapping("/serchProductByCatagory/{id}")
	public List<Product> serchProductByCatagory(@PathVariable("product") int id) {
		List<Product> serch = service.serchProductByCatagory(id);
		return serch;
		
	}

	// PurchaseProduct
		@GetMapping("/purchaseproduct/{id}/quentity/{quentity}")
		public String purchaseProduct(@PathVariable("id")int id,@PathVariable("quentity")int quentity) {
			String string = service.purchaseProduct(id,quentity);
			return string;
		}
	
	// purches History
		@GetMapping("/gethistory")
		public List<PurchaseHistory> getPHistory() {
			List<PurchaseHistory> serch = service.history();
			return serch;
			
		}

}
