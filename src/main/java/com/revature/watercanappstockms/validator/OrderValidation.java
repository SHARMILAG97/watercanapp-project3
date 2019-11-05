package com.revature.watercanappstockms.validator;

import com.revature.watercanappstockms.dto.OrderDTO;
import com.revature.watercanappstockms.exception.ValidatorException;

public class OrderValidation {
	
	public void validateOrder(OrderDTO orderdto, int availcans) throws ValidatorException {
		
		int id=orderdto.getUserId();
		int orderCans=orderdto.getOrderCans();

		
		if(id<=0|| orderCans<=0 || orderCans>availcans)
			throw new ValidatorException("Invalid Order");
	}

}
