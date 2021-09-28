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
 * Indicates that this class is a " Seed Entity"
 * 
 * @date 21/09/2021 This class is a part of entity package which defines the
 *       attributes of seed
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seed {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seedId;

	@NotBlank(message = "Seed's name can't be blank")
	private String commonname;

	@NotBlank(message = "Seed's bloom time can't be blank")
	private String bloomTime;

	@NotBlank(message = "Seed's watering can't be blank")
	private String watering;

	@NotBlank(message = "Seed's difficulty level can't be blank")
	private String difficultyLevel;

	@NotBlank(message = "Seed's temperature can't be blank")
	private String temperature;

	@NotBlank(message = "Seed's type can't be blank")
	private String typeOfSeeds;

	@NotBlank(message = "Seed's description can't be blank")
	private String seedsDescription;

	@Min(value = 0, message = "Seed's stock can't be negative")
	private int seedsStock;

	@Min(value = 1, message = "Seed's cost can't be 0")
	private double seedsCost;

	@Min(value = 1, message = "Seed's per packet can't be 0")
	private int seedsPerPacket;
}
