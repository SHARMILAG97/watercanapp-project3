package com.revature.watercanappstockms.dto;

import lombok.Data;

@Data
public class ModifyReserveDTO {
	
	  private int reserveId;
	    private int userId;
	    private String userName;
	    private int reservedCans;
	    private int reservedOrderCans;
}
