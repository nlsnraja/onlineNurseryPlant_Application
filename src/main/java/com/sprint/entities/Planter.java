package com.sprint.entities;

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
 * Indicates that this class is a " Planter Entity"
 * 
 * @date 21/09/2021 This class is a part of entity package which defines the
 *       attributes of planter, seed and plant entities are mapped with one to
 *       one relationship
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Planter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int planterId;

	@Min(value = 1, message = "Planter's Height can't be 0")
	private float planterHeight;

	@Min(value = 1, message = "Planter's Capacity can't be 0")
	private int planterCapacity;

	@Min(value = 1, message = "Planter's Drinage Hole can't be 0")
	private int drinageHoles;

	@NotBlank(message = "Planter's color can't be blank")
	private String planterColor;

	@NotBlank(message = "Planter's shape can't be blank")
	private String planterShape;

	@Min(value = 0, message = "Planter's stock can't be negative")
	private int planterStock;

	@Min(value = 1, message = "Planter's cost can't be 0")
	private int planterCost;

	// PLANTERS MAPPED WITH PLANTS
	@OneToOne(cascade = CascadeType.ALL)
	private @Valid Plant plants;

	// PLANTERS MAPPED WITH SEEDS
	@OneToOne(cascade = CascadeType.ALL)
	private @Valid Seed seeds;
}
