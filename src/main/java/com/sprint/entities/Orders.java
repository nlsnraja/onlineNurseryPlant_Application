package com.sprint.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Indicates that this class is a " Orders Entity"
 * 
 * @date 21/09/2021 This class is a part of entity package which defines the
 *       attributes of orders and planters are mapped with one to one
 *       relationship
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingOrderid;

//	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate orderDate;

	@NotBlank(message = "Transaction Mode Can't be null")
	private String transactionMode;

	@Min(value = 1, message = "Quantity can't be 0")
	private int quantity;

	@Min(value = 1, message = "Cost can't be 0")
	private double totalCost;

	// ORDERS MAPPED WITH PLANTERS
	@OneToOne(cascade = CascadeType.ALL)
	private @Valid Planter planters;
}
