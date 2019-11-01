package com.revature.watercanappstockms.validator;

import com.revature.watercanappstockms.exception.ValidatorException;

public class LoginValidation {

	public  boolean validateMobileNo(Long mno) throws ValidatorException {

		String num = String.valueOf(mno);
		int count = num.length();

		boolean msg ;
		if (count != 10)

			 msg = false;
			//throw new ValidatorException("Invalid Mobile Number");

		else
			msg =true;
			//throw new ValidatorException("Valid Mobile Number");
	
		return msg;
	}
	
}
