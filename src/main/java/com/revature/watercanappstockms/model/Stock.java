package com.revature.watercanappstockms.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


	@Data
	@Entity
	@Table(name="stock_availability")
	public class Stock {
		
		@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column(name="stock_id")
	    private Integer stockId;
	 
	 @Column(name="date_time")
	 	private LocalDate dateTime=LocalDate.now();

	 @Column(name="available_cans")
	 private Integer availableCans;
		
		}



