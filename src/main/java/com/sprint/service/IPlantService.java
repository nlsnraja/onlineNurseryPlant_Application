package com.sprint.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint.entities.Plant;

/**
 * Indicates that this interface is a " IPlantService", developed for the sprint
 * project "Online Plant Nursery Application" This interface is a part of
 * service package which has some method declarations in the class such as
 * add,update,delete,view .
 * 
 * @Date 22.09.2021
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 **/

@Service
public interface IPlantService {
	Plant addPlant(Plant plant);

	Plant updatePlant(Plant plant);

	Plant deletePlant(Plant plant);

	Plant viewPlant(int plantId);

	Plant viewPlant(String commonName);

	List<Plant> viewAllPlants();

	List<Plant> viewAllPlants(String typeOfPlant);
}
