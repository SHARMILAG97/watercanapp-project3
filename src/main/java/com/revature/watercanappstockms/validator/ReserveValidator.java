package com.revature.watercanappstockms.validator;

import com.revature.watercanappstockms.dto.ReserveDTO;
import com.revature.watercanappstockms.exception.ValidatorException;

public class ReserveValidator {

	public void validateReserve(ReserveDTO reservedto, int availcans) throws ValidatorException {
		
		int id=reservedto.getUserId();
		int reserveid=reservedto.getReserveId();
		int reserveCans=reservedto.getReservedCans();

		
		if(id<=0 || reserveid<=0 || reserveCans<=0 || reserveCans>availcans)
			throw new ValidatorException("Invalid Reserve");
	}

}
