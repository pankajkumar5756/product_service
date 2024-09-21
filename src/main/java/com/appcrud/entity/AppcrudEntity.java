package com.appcrud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "product_details")
public class AppcrudEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private int id;
	
	@Column(name = "productName")
	private String productName;
	
	@Column(name = "productPrice")
	private String productPrice;
	
	@Column(name = "manufAddress")
	private String manufAddress;
	
	@Column(name = "storeAddress")
	private String storeAddress;
}
