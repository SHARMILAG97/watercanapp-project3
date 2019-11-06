package com.revature.watercanappstockms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.watercanappstockms.Message.MessageConstant;
import com.revature.watercanappstockms.dto.OrderDTO;
import com.revature.watercanappstockms.dto.ReserveDTO;
import com.revature.watercanappstockms.dto.StockDTO;
import com.revature.watercanappstockms.exception.ServiceException;
import com.revature.watercanappstockms.exception.ValidatorException;
import com.revature.watercanappstockms.model.Stock;
import com.revature.watercanappstockms.repository.StockRepository;
import com.revature.watercanappstockms.validator.OrderValidation;
import com.revature.watercanappstockms.validator.ReserveValidator;

@Service
public class StockService {

	@Autowired
	StockRepository stockrepository;

	public List<Stock> viewStock() {

		List<Stock> list = null;
		list = stockrepository.findAll();
		return list;
	}

	public Stock updateCans(StockDTO stockinfo) throws ServiceException {

		int updatecans = stockinfo.getUpdatecans();
		
		Stock stock = null;

		if (updatecans <= 0) {
			
			throw new ServiceException(MessageConstant.UNABLE_TO_UPDATE);
			
		}
		List<Stock> list = stockrepository.findAll();

		int availcans = 0;

	    stock = list.get(0);
		availcans = stock.getAvailableCans();

		int newcans = availcans + updatecans;

		stock.setAvailableCans(newcans);

		stockrepository.save(stock);

		return stock;
	}

	public Stock orderCans(OrderDTO orderDTO) throws ValidatorException, ServiceException {
		
		int ordercans =orderDTO.getOrderCans() ;
		int userid = orderDTO.getUserId();
		
		if (ordercans <= 0 || userid<=0) 
			throw new ServiceException(MessageConstant.UNABLE_TO_ORDER);
			

		List<Stock> list = stockrepository.findAll();

		int availcans = 0;

		Stock stock = list.get(0);
		availcans = stock.getAvailableCans();

		OrderValidation validate = new OrderValidation();
		validate.validateOrder(orderDTO, availcans);

		int orderedcans = orderDTO.getOrderCans();
		System.out.println("orderedcans: " + orderedcans);
		int newcans = availcans - orderedcans;

		stock.setAvailableCans(newcans);

		stockrepository.save(stock);

		return stock;

	}

	public void reserveCans(ReserveDTO reserveDTO) throws ValidatorException, ServiceException {

		
		int ordercans =reserveDTO.getReservedCans();
		int userid = reserveDTO.getUserId();
		
		if (ordercans <= 0 || userid<=0) 
			throw new ServiceException(MessageConstant.UNABLE_TO_RESERVE);
		
		List<Stock> list = stockrepository.findAll();

		int availcans = 0;

		Stock stock = list.get(0);
		availcans = stock.getAvailableCans();

		ReserveValidator validate = new ReserveValidator();
		validate.validateReserve(reserveDTO, availcans);

		int reservedcans = reserveDTO.getReservedCans();
		System.out.println("reservedcans: " + reservedcans);

		int newcans = availcans - reservedcans;
		System.out.println("newcans: " + newcans);

		stock.setAvailableCans(newcans);

		stockrepository.save(stock);

	}

	public void cancelReserve(ReserveDTO reserveDTO) {

		List<Stock> list = stockrepository.findAll();

		int availcans = 0;

		Stock stock = list.get(0);
		availcans = stock.getAvailableCans();

		int reservedcans = reserveDTO.getReservedCans();
		System.out.println("reservedcans: " + reservedcans);

		int newcans = availcans + reservedcans;
		System.out.println("newcans: " + newcans);

		stock.setAvailableCans(newcans);

		stockrepository.save(stock);

	}

	public void cancelOrder(OrderDTO orderDTO) {

		List<Stock> list = stockrepository.findAll();

		int availcans = 0;

		Stock stock = list.get(0);
		availcans = stock.getAvailableCans();

		int orderedcans = orderDTO.getOrderCans();
		System.out.println("reservedcans: " + orderedcans);

		int newcans = availcans + orderedcans;
		System.out.println("newcans: " + newcans);

		stock.setAvailableCans(newcans);

		stockrepository.save(stock);
	}

}
