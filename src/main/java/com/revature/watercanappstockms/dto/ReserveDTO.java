package com.revature.watercanappstockms.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReserveDTO {
	
	private int reservedCans;
	
	private int reserveId;
    private int userId;
    private String userName;
    private int reservedOrderCans;
    private String status;
    private LocalDateTime date;

}
