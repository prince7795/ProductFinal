package com.tcs.casestudy.services;

import java.util.Optional;

import com.tcs.casestudy.models.Price;

public interface PriceService {
	public Price addPrice(Price price);
	public String updatePrice(long id, Price updatePrice);
	public String deletePrice(long id);
	public Optional<Price> findByProductId(long productId);
}
