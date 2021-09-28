package com.sprint.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Indicates that this class is a " Address Entity"
 * 
 * @date 21/09/2021 This class is a part of entity package which defines the
 *       attributes in the address table which contains address details of the
 *       customer
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int addressId;

	@NotBlank(message = "House Number can't be null")
	private String houseNo;

	@NotBlank(message = "Colony can't be null")
	private String colony;

	@NotBlank(message = "City can't be null")
	private String city;

	@NotBlank(message = "State can't be null")
	private String State;

	@Min(value = 1, message = "Pincode can't be zero")
	private int pincode;
}
