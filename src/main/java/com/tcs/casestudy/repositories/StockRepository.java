package com.tcs.casestudy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.casestudy.models.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
