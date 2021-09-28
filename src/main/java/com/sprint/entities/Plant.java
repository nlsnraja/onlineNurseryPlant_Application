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
 * Indicates that this class is a " plant Entity"
 * 
 * @date 21/09/2021 This class is a part of entity package which defines the
 *       attributes of plants
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int plantId;

	@Min(value = 1, message = "Plant's Height can't be 0")
	private int plantHeight;

	@NotBlank(message = "Plant Spread can't be blank")
	private String plantSpread;

	@NotBlank(message = "Plant Name can't be blank")
	private String commonName;

	@NotBlank(message = "Plant's Bloom time can't be blank")
	private String bloomTime;

	@NotBlank(message = "Plant's Medicinal Use can't be blank")
	private String medicinalOrCulinaryUse;

	@NotBlank(message = "Plant's Difficulty Level  can't be blank")
	private String difficultyLevel;

	@NotBlank(message = "Plant's Temperature can't be blank")
	private String temperature;

	@NotBlank(message = "Type of plant can't be blank")
	private String typeOfPlant;

	@NotBlank(message = "Plant Description can't be blank")
	private String plantDescription;

	@Min(value = 0, message = "Plant's stock can't be negative")
	private int plantsStock;

	@Min(value = 1, message = "Plant's cost can't be 0")
	private double plantCost;
}
