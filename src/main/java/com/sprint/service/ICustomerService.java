package com.sprint.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint.entities.Customer;

/**
 * Indicates that this interface is a " ICustomerService", developed for the
 * sprint project "Online Plant Nursery Application" This interface is a part of
 * service package which has some method declarations in the class such as
 * add,update,delete,view .
 * 
 * @Date 22.09.2021
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 **/

@Service
public interface ICustomerService {
	Customer addCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	Customer deleteCustomer(Customer customer);

	Customer viewCustomer(int customerId);

	List<Customer> viewAllCustomers();

	boolean validateCustomer(String userName, String password);
}
