package com.revature.watercanappstockms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.watercanappstockms.dto.ReserveDTO;
import com.revature.watercanappstockms.model.Stock;
import com.revature.watercanappstockms.repository.StockRepository;

@Service
public class ModifyService {

	@Autowired
	StockRepository stockrepository;

	/*
	 * @Autowired private RestTemplate restTemplate;
	 * 
	 * String apiUrl = "https://watercanapp-reserve-ms.herokuapp.com/";
	 */

	public Stock modifyReserve(ReserveDTO reserveDTO2) {
		/*
		 * ResponseEntity<ReserveDTO> getForEntity = restTemplate.getForEntity(apiUrl +
		 * "/modifiedReservedCan", ReserveDTO.class); System.out.println(getForEntity);
		 * ReserveDTO reservedto = getForEntity.getBody();
		 */
		int ordercans = reserveDTO2.getReservedOrderCans();
		int reservecans = reserveDTO2.getReservedCans();

		System.out.println("ordercans: "+ordercans);
		System.out.println("reservecans: "+reservecans);
		
		List<Stock> list = stockrepository.findAll();

		int availcans = 0;
		int newcans = 0;

		Stock stock = list.get(0);
		availcans = stock.getAvailableCans();
		
		System.out.println("availcans: "+availcans);

		if (ordercans > reservecans) {

			newcans = ordercans - reservecans;
			availcans -= newcans;
		} else {

			newcans = reservecans - ordercans;
			availcans += newcans;

		}

		System.out.println("availcans: "+availcans);
		stock.setAvailableCans(availcans);

		stockrepository.save(stock);

		return stock;
	}

}
