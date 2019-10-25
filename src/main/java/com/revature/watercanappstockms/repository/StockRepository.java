package com.revature.watercanappstockms.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.watercanappstockms.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

	@Query("from Stock where dateTime = ?1")
	Stock findByDate(LocalDate currentDate);

}
