package com.ecom.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.entity.Product;
import com.ecom.service.IServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	IServiceImpl service;
	
	// list Of Product
	//http://localhost:9596/product/getproduct
	@GetMapping("/getproduct")
	public List<Product> index() {	
		
		ArrayList <Product> al=new ArrayList();		
		List<Product> findAll = service.findAll();
		
		 return findAll;
	}
	
	//http:localhost:9596/product/create	
	// save Product
	@PostMapping(value = "/create")
	public Product postProduc(@RequestBody Product product) {

		Product product1 = service.postProduc(product);
		return product1;
	}
	
	//get Product By Seller ID
	//http://localhost:9596/product/fitchProduct/101
	@GetMapping("/fitchProduct/{productid}")
	public Product getProduct(@PathVariable("productid") int id) {
		Product serch = service.FindProduct(id);
		return serch;
		
	}
	
	//delete product by product id 
	// http://localhost:9596/product/delete/101
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
		System.out.println("Delete Product with ID = " + id + "...");

		String s=service.deleteById(id);

		return new ResponseEntity<>(s, HttpStatus.OK);
	}
	
	// http://localhost:9596/product/update
	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<Product> update(@PathVariable("id") int id, @RequestBody Product product) {
		System.out.println("Update Product with ID = " + id + "...");

		Product resp=service.find(id);
			
		if(resp!=null) {
			
			BeanUtils.copyProperties(product, resp);
			return new ResponseEntity<>(service.postProduc(resp), HttpStatus.OK);
		}
		
	   else 
		  return new ResponseEntity<>(HttpStatus.NOT_FOUND);

   }
	
	//http://localhost:9596/product/serchProductByCatagory/111
	@GetMapping("/serchProductByCatagory/{id}")
	public List<Product> serchProductByCatagory(@PathVariable("id") int id) {
	 
				List<Product> byCatagory = service.serchProductByCatagory(id);
				
				return byCatagory;
 }
	
}