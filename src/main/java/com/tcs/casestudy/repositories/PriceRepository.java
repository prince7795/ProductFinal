package com.tcs.casestudy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.casestudy.models.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {

}
