package com.tcs.casestudy.services;

import java.util.List;
import java.util.Optional;

import com.tcs.casestudy.models.Stock;

public interface StockService {
	public Stock addStock(Stock stock);
	public String updateStock(long id, Stock updateStock);
	public String deleteStock(long id);
	public Optional<Stock> findById(long id);
	public Optional<List<Stock>> getStocks();
}
