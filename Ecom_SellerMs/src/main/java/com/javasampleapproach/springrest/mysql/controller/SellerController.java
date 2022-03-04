package com.javasampleapproach.springrest.mysql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.springrest.mysql.model.Seller;
import com.javasampleapproach.springrest.mysql.repo.SellerRepository;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/seller")
public class SellerController {

	@Autowired
	SellerRepository sellerRepo;

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello Hello";
	}
	@GetMapping("/get")
	public List<Seller> getAllSellers() {
		System.out.println("Get all Sellers...");

		List<Seller> sellers = new ArrayList<>();
		sellerRepo.findAll().forEach(sellers::add);

		return sellers;
	}

	@PostMapping(value = "/create")
	public Seller postSeller(@RequestBody Seller seller) {

		Seller _seller = sellerRepo.save(seller);//new Customer(customer.getName(), customer.getAge()));
		return _seller;
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteSeller(@RequestParam int id) {
		System.out.println("Delete Seller with ID = " + id + "...");

		sellerRepo.deleteById(id);

		return new ResponseEntity<>("Seller has been deleted!", HttpStatus.OK);
	}


	@PutMapping("/update/{id}")
	public ResponseEntity<Seller> updateSeller(@PathVariable("id") int id, @RequestBody Seller seller) {
		System.out.println("Update Seller with ID = " + id + "...");

		Optional<Seller> sellerData = sellerRepo.findById(id);

		if (sellerData.isPresent()) {
			Seller _seller = sellerData.get();
			_seller.setsCompanyName(seller.getsCompanyName());
			_seller.setsCompanyDescription(seller.getsCompanyDescription());
			_seller.setsUserName(seller.getsUserName());
			return new ResponseEntity<>(sellerRepo.save(_seller), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
//	@PostMapping("/postLoginSeller")
//	public List<Seller> getSeller(@RequestBody Seller seller) {
//		System.out.println("Seller is present in DB");
//
//		List<Seller> sellers = new ArrayList<>();
//		sellerRepo.findAll().forEach(sellers::add);
//		sellerRepo.findBysEmailIdAndsPassword(seller.getsEmailId(), seller.getsPassword());
//		
//		return sellers;
//	}
	
//	@GetMapping("/getLoginSeller")
//	public List<Seller> getSeller(@RequestBody Seller seller) {
//		System.out.println("Seller is present in DB");
//
//		List<Seller> sellers = new ArrayList<>();
//		//sellerRepo.findAll().forEach(sellers::add);
//		sellerRepo.findBysEmailIdAndsPassword(seller.getsEmailId(), seller.getsPassword()).forEach(sellers::add);
//		
//		return sellers;
//	}
}
