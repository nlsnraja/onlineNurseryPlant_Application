package com.sprint.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Indicates that this class is a " Customer Entity"
 * 
 * @date 21/09/2021 This class is a part of entity package which defines the
 *       attributes of the customer table which contains details of the customer
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;

	@Size(min = 4, max = 20, message = "Name of the Customer must have 4 to 20 Characters")
	private String customerName;

	@Email(message = "Invalid Email")
	private String customerEmail;

	private String userName;
	private String password;

	// CUSTOMER MAPPED WITH ADDRESS
	@OneToOne(cascade = CascadeType.ALL)
	private @Valid Address address;
}
