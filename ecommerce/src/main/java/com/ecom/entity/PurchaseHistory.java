package com.ecom.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PurchaseHistory {
	
	@Id
	int id ;
	private int productId;
	private int prchasequantity;
	private int buyerid;
	private Date purchasedate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getPrchasequantity() {
		return prchasequantity;
	}
	public void setPrchasequantity(int prchasequantity) {
		this.prchasequantity = prchasequantity;
	}
	public int getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(int buyerid) {
		this.buyerid = buyerid;
	}
	public Date getPurchasedate() {
		return purchasedate;
	}
	public void setPurchasedate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}
	


}
