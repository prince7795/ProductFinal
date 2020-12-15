package com.tcs.casestudy.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	private String productName;
	private long category;
	private String descroption;
	private Date expiryDate;
}
