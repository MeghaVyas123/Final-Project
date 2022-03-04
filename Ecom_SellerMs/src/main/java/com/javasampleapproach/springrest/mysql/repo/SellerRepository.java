package com.javasampleapproach.springrest.mysql.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javasampleapproach.springrest.mysql.model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer>{
    Seller findBysUserName(String sUserName);
   
	
}
