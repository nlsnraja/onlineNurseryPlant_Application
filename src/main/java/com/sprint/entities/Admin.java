package com.sprint.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Indicates that this class is a " Admin Entity"
 * 
 * @date 21/09/2021 This class is a part of entity package which defines the
 *       attributes of admin
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	private String adminUsername;
	private String adminPassword;
}
