package com.revature.watercanappstockms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.watercanappstockms.dto.OrderDTO;

@Service
public class OrderService {
	
	@Autowired
	 private RestTemplate restTemplate;
	
	 String apiUrl = "https://watercanapp-ordercan.herokuapp.com/";

	 
	  public int orderStock(){        
	       ResponseEntity<OrderDTO> getForEntity = restTemplate.getForEntity(apiUrl+"/orderCan", OrderDTO.class);
	       System.out.println(getForEntity);
	       OrderDTO orderdto = getForEntity.getBody();
	       int ordercans = orderdto.getOrderCans();
	       System.out.println(ordercans);
		return ordercans;
	    }
}
