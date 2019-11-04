package com.revature.watercanappstockms.validator;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.watercanappstockms.dto.OrderDTO;
import com.revature.watercanappstockms.dto.StockDTO;
import com.revature.watercanappstockms.exception.ValidatorException;

public class OrderValidation {
	
	@Autowired
	StockDTO stock;
	
	public void validateOrder(OrderDTO orderdto, int availcans) throws ValidatorException {
		
		int id=orderdto.getUserId();
		int orderid=orderdto.getId();
		int orderCans=orderdto.getOrderCans();

		
		if(id<=0 || orderid<=0 || orderCans<=0 || orderCans>availcans)
			throw new ValidatorException("Invalid Order");
	}

}
