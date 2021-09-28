package com.sprint.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sprint.entities.Orders;
import com.sprint.service.IOrderService;

/**
 * Indicates that this class is a " IOrderController", developed for the sprint
 * project "Online Plant Nursery Application" This class is a part of controller
 * package that has post, put, get mapping and autowired with the respective
 * interface for accessing the method in the class(ServiceImpl) PostController
 * is for adding, PutController is for updating, DeleteContoller for deleting,
 * GetController is for Viewing
 * 
 * @Date 23.09.2021
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 **/

//TO INTEGRATE WITH REACT JS
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/order")
public class IOrderController {
	@Autowired
	private IOrderService orderService;

	// ADD ORDER
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Orders> addOrder(@Valid @RequestBody Orders order) {
		Orders ord = orderService.addOrder(order);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(ord.getBookingOrderid()).toUri();
		return ResponseEntity.created(location).body(ord);
	}

	// UPDATE ORDER
	@PutMapping("/update/{id}")
	public ResponseEntity<Orders> updateOrder(@RequestBody Orders order) {
		Orders ord = orderService.updateOrder(order);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(ord.getBookingOrderid()).toUri();
		return ResponseEntity.created(location).body(ord);
	}

	// DELETE ORDER
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteOrder(@RequestBody Orders order) {
		Orders ord = orderService.deleteOrder(order.getBookingOrderid());
		if (ord == null) {
			return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Problem in deleting", HttpStatus.BAD_REQUEST);
		}
	}

	// VIEW ALL ORDERS
	@GetMapping("/orders")
	public List<Orders> viewAllOrders() {
		return orderService.viewAllOrders();
	}

	// VIEW ORDER BY ID
	@GetMapping("/find/{orderid}")
	public ResponseEntity<Orders> viewOrder(@PathVariable("orderid") int orderId) {
		Orders ord = orderService.viewOrder(orderId);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(ord.getBookingOrderid()).toUri();
		return ResponseEntity.created(location).body(ord);
	}
}
