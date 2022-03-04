package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.entity.PurchaseHistory;

public interface PurchaseHistoryRepo extends JpaRepository<PurchaseHistory, Integer> {

}
