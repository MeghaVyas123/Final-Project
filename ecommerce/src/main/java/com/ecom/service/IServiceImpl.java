package com.ecom.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.entity.Buyer;
import com.ecom.entity.Product;
import com.ecom.entity.PurchaseHistory;
import com.ecom.entity.ShoppingCart;
import com.ecom.exception.RecordNotFoundException;
import com.ecom.repository.ProductRepo;
import com.ecom.repository.PurchaseHistoryRepo;
import com.ecom.repository.ShoppingCartRepo;

@Service
public class IServiceImpl implements IService {
	
	@Autowired
	ProductRepo repo;
	
	@Autowired
	ShoppingCartRepo crepo;
	
	@Autowired
	PurchaseHistoryRepo prepo;
	
	@Autowired
	Buyer buyer;
	
	Date date;
	
	
		//save the recort
	@Override
	public Product postProduc(Product product) {
		Product save = repo.save(product);
		return save;
	}

	//find All the Record
	@Override
	public List<Product> findAll() {
		
		List<Product> findAll = repo.findAll();
		return findAll;
	}
	
	// Find By Product Id
	@Override
	public Product find(int id) {
		
		Optional<Product> byId = repo.findById(id);
			
				if(byId.isPresent()) {
					Product product = byId.get();
					return product;
				}
	
				else throw  new RecordNotFoundException("Product id '" + id + "' does no exist");
	}
	
	// Serch By Name
	@Override
	public List<Product> serch(String product1) {
		
		
		System.out.println("IServiceImpl.serch()");
		
		List<Product> al=repo.findBypName(product1.toUpperCase());

		if(al.isEmpty()) return al; 
		else throw  new RecordNotFoundException(" Product Product Not Found :"+product1);
	}

	@Override
	public String addShoppinrgCart(int id ,int quntity) {
	
		Optional<Product> product1 = repo.findById(id);	
		if(product1.isPresent()) {
			Product product = product1.get();
			if(quntity>=product.getpQuantity())
				throw  new RecordNotFoundException("that much quantity of Product is not available");
			ShoppingCart cart=new ShoppingCart();
			cart.setBuyerid(buyer.getId());
			cart.setProductid(product.getpId());
			cart.setPurchasequantity(quntity);
			crepo.save(cart);		
		}
		else throw  new RecordNotFoundException("Product id '" + id + "' does no exist");
		 
		return "product Added to cart";	
	}


	@Override
	public List<Product> shoppinrgCart() {
		System.out.println("IServiceImpl.shoppinrgCart()");
		
		List<ShoppingCart> all = crepo.findAll();
		
		ArrayList<Product> al=new ArrayList<>();
		
		for(ShoppingCart cart :all) {
			Optional<Product> findById = repo.findById(cart.getProductid());
			Product product=findById.get();
			al.add(product);
		}
		
		return al;
	}


	@Override
	public String removeShoppinrgCart(int id) {
		// TODO Auto-generated method stu
		System.out.println("IServiceImpl.removeShoppinrgCart()");
		
			crepo.deleteById(id);
			
		return "Item Remove Sucessfully";
	}

	
	// Find Product By Seller Id
	@Override
	public Product FindProduct(int id) {
		Product product = repo.findBypSellerId(id);
		if(product!=null)
		return product;
		else throw new RuntimeException("No record found for given Seller id: "+id);
	}
	
	// Delete Product By Id
	@Override
	public String deleteById(int id) {
		
		Optional<Product> byId = repo.findById(id);
		
		if(byId.isPresent()) {
			repo.deleteById(id);
			return "Product has been deleted!";
		}
		else throw new RuntimeException("No record found for given id: "+id);
		
	}
	
	// Product Histpry
	@Override
	public List<PurchaseHistory> history() {
		 List<PurchaseHistory> history = prepo.findAll();
		return history;
	}
	
	
	@Override
	public String purchaseProduct(int id, int quntity) {

		Optional<Product> product1 = repo.findById(id);
		if(product1.isPresent()) {
		
			Product product = product1.get();	
			if(quntity>product.getpQuantity())
				throw  new RecordNotFoundException("that much product not avalable");	
			
			product.setpQuantity(product.getpQuantity()-quntity);
			repo.save(product);
			PurchaseHistory cart=new PurchaseHistory();			
			cart.setProductId(product.getpId());
			cart.setPrchasequantity(quntity);
			cart.setBuyerid(buyer.getId());
			cart.setPurchasedate(date=java.util.Calendar.getInstance().getTime());
			prepo.save(cart);
			
		}
		 else throw  new RecordNotFoundException("Product id '" + id + "' does no exist");
		 
		return " Product Purchase Successfully";	
	}

	@Override
	public List<Product> serchProductByCatagory(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
