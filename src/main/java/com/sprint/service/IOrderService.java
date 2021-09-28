package com.sprint.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint.entities.Orders;

/**
 * Indicates that this interface is a " IOrderService", developed for the sprint
 * project "Online Plant Nursery Application" This interface is a part of
 * service package which has some method declarations in the class such as
 * add,update,delete,view .
 * 
 * @Date 22.09.2021
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 **/

@Service
public interface IOrderService {
	Orders addOrder(Orders order);

	Orders updateOrder(Orders order);

	Orders deleteOrder(int orderId);

	Orders viewOrder(int orderId);

	List<Orders> viewAllOrders();
}
