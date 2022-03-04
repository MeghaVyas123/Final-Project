package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.entity.ShoppingCart;

public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Integer>{

}
