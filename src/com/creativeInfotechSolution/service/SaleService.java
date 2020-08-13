package com.creativeInfotechSolution.service;



import java.util.List;

import com.creativeInfotechSolution.model.Sale;

public interface SaleService {

	boolean addSale(Sale sale);
	
	List<Sale> getAllSale();
	
	List<Sale> searchSale(String input);
	
}
