package com.revature.watercanappstockms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.watercanappstockms.dto.Message;
import com.revature.watercanappstockms.dto.ModifyReserveDTO;
import com.revature.watercanappstockms.dto.OrderDTO;
import com.revature.watercanappstockms.dto.ReserveDTO;
import com.revature.watercanappstockms.dto.StockDTO;
import com.revature.watercanappstockms.exception.ServiceException;
import com.revature.watercanappstockms.exception.ValidatorException;
import com.revature.watercanappstockms.model.Stock;
import com.revature.watercanappstockms.service.ModifyService;
import com.revature.watercanappstockms.service.StockService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class StockController {

	@Autowired
	StockService stockService;

	@Autowired
	ModifyService modifyservice;

	@GetMapping("viewStock")
	@ApiOperation("viewStock")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Viewed Successfully", response = Stock.class),
			@ApiResponse(code = 400, message = "View failed") })
	public ResponseEntity<?> viewStock() {

		List<Stock> list = null;
		String errorMessage = null;
		try {
			list = stockService.viewStock();
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		}
		if (list != null)
			return new ResponseEntity<>(list, HttpStatus.OK);
		else
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/update")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Updated Successfully", response = Message.class),
			@ApiResponse(code = 400, message = "Update failed") })
	public ResponseEntity<?> update(@RequestBody StockDTO stockinfo) {

		String errorMessage = null;
		Stock result = null;

		try {
			result = stockService.updateCans(stockinfo);
		} catch (ServiceException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		}

		if (result != null)
			return new ResponseEntity<>(result, HttpStatus.OK);
		else {
			Message message = new Message(errorMessage);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/updateOrderedCans")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ordered Successfully", response = Message.class),
			@ApiResponse(code = 400, message = "Order failed") })
	public ResponseEntity<?> orderCans(@RequestBody OrderDTO orderDTO) {

		String errorMessage = null;
		String Message = null;

		try {

			stockService.orderCans(orderDTO);

			Message = "Ordered Success";
		} catch (ValidatorException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		}

		if (Message != null)
			return new ResponseEntity<>(Message, HttpStatus.OK);
		else
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/updateReservedCans")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Reserved Successfully", response = Message.class),
			@ApiResponse(code = 400, message = "Reserve failed") })
	public ResponseEntity<?> reserveCans(@RequestBody ReserveDTO reserveDTO) {

		String errorMessage = null;
		String Message = null;

		try {

			stockService.reserveCans(reserveDTO);

			Message = "Reserved Success";
		} catch (ValidatorException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		}

		if (Message != null)
			return new ResponseEntity<>(Message, HttpStatus.OK);
		else
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);

	}
	
	@PostMapping("/modifiedReservedCan")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Reserve Modified Successfully", response = Message.class),
			@ApiResponse(code = 400, message = "Reserve Modify failed") })
	public ResponseEntity<?> modifyReserve(@RequestBody ModifyReserveDTO reserveDTO) {

		String errorMessage = null;
		String Message = null;

		try {

			modifyservice.modifyReserve(reserveDTO);

			Message = "Reserve Modified Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage = "Reserve Modify failed";
		}

		if (Message != null)
			return new ResponseEntity<>(Message, HttpStatus.OK);
		else
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);

	}
	@PostMapping("/cancelReserve")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Reserve Cancelled Successfully", response = Message.class),
			@ApiResponse(code = 400, message = "Reserve Cancel failed") })
	public ResponseEntity<?> cancelReserve(@RequestBody ReserveDTO reserveDTO) {

		String errorMessage = null;
		String Message = null;

		try {

			stockService.cancelReserve(reserveDTO);

			Message = "Reserve Cancelled Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage = "Reserve Cancel failed";
		}

		if (Message != null)
			return new ResponseEntity<>(Message, HttpStatus.OK);
		else
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);

	}
	
	@PostMapping("/cancelOrder")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Order Cancelled Successfully", response = Message.class),
			@ApiResponse(code = 400, message = "Order Cancel failed") })
	public ResponseEntity<?> cancelOrder(@RequestBody OrderDTO orderDTO) {

		String errorMessage = null;
		String Message = null;

		try {

			stockService.cancelOrder(orderDTO);

			Message = "Order Cancelled Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage = "Order Cancel failed";
		}

		if (Message != null)
			return new ResponseEntity<>(Message, HttpStatus.OK);
		else
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);

	}

}
