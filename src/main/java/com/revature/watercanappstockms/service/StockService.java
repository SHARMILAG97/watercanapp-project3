package com.revature.watercanappstockms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.watercanappstockms.Message.MessageConstant;
import com.revature.watercanappstockms.dto.OrderDTO;
import com.revature.watercanappstockms.dto.ReserveDTO;
import com.revature.watercanappstockms.dto.StockDTO;
import com.revature.watercanappstockms.exception.ServiceException;
import com.revature.watercanappstockms.model.Stock;
import com.revature.watercanappstockms.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	StockRepository stockrepository;

	@Autowired
	OrderService orderservice;

	public List<Stock> viewStock() {

		List<Stock> list = null;
		list = stockrepository.findAll();
		return list;
	}

	public Stock updateCans(StockDTO stockinfo) throws ServiceException {

		int updatecans = stockinfo.getUpdatecans();

		if (updatecans <= 0)
			throw new ServiceException(MessageConstant.UNABLE_TO_UPDATE);

		List<Stock> list = stockrepository.findAll();

		int availcans = 0;

		Stock stock = list.get(0);
		availcans = stock.getAvailableCans();

		int newcans = availcans + updatecans;

		stock.setAvailableCans(newcans);

		stockrepository.save(stock);

		return stock;

	}

	public Stock orderCans(OrderDTO orderDTO) {

		List<Stock> list = stockrepository.findAll();

		int availcans = 0;

		Stock stock = list.get(0);
		availcans = stock.getAvailableCans();

		//int orderedcans = orderDTO.getOrdercans();
		int orderedcans = orderservice.orderStock();
		System.out.println("orderedcans: "+orderedcans);
		int newcans = availcans - orderedcans;

		stock.setAvailableCans(newcans);

		stockrepository.save(stock);

		return stock;

	}

	public void reserveCans(ReserveDTO reserveDTO) {

		List<Stock> list = stockrepository.findAll();

		int availcans = 0;

		Stock stock = list.get(0);
		availcans = stock.getAvailableCans();

		int reservedcans = reserveDTO.getReservedcans();
		System.out.println("reservedcans: "+reservedcans);
		
		int newcans = availcans - reservedcans;
		System.out.println("newcans: "+newcans);
		
		stock.setAvailableCans(newcans);

		stockrepository.save(stock);

	}

}
