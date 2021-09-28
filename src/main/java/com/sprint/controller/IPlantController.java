package com.sprint.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sprint.entities.Plant;
import com.sprint.service.IPlantService;

/**
 * Indicates that this class is a " IPlantController", developed for the sprint
 * project "Online Plant Nursery Application" This class is a part of controller
 * package that has post, put, get mapping and autowired with the respective
 * interface for accessing the method in the class(ServiceImpl) PostController
 * is for adding, PutController is for updating, DeleteContoller for deleting,
 * GetController is for Viewing
 * 
 * @Date 23.09.2021
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 **/

@RestController
@RequestMapping("/plant")
public class IPlantController {
	@Autowired
	private IPlantService plantService;

	// ADD PLANT
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Plant> addPlant(@Valid @RequestBody Plant plant) {
		Plant plan = plantService.addPlant(plant);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(plan.getPlantId())
				.toUri();
		return ResponseEntity.created(location).body(plan);
	}

	// UPDATE PLANT
	@PutMapping("/update/{id}")
	public ResponseEntity<Plant> updatePlant(@RequestBody Plant plant) {
		Plant plan = plantService.updatePlant(plant);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(plan.getPlantId())
				.toUri();
		return ResponseEntity.created(location).body(plan);
	}

	// DELETE PLANT
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deletePlant(@RequestBody Plant plant) {
		Plant plan = plantService.deletePlant(plant);
		if (plan == null) {
			return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Problem in deleting", HttpStatus.BAD_REQUEST);
		}
	}

	// VIEW ALL PLANTS
	@GetMapping("/plants")
	public List<Plant> viewAllPlants() {
		return plantService.viewAllPlants();
	}

	// VIEW PLANT BY ID
	@GetMapping("/find/{plantid}")
	public ResponseEntity<Plant> viewPlant(@PathVariable("plantid") int plantId) {
		Plant plan = plantService.viewPlant(plantId);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(plan.getPlantId())
				.toUri();
		return ResponseEntity.created(location).body(plan);
	}

	// VIEW PLANT BY NAME
	@GetMapping("/find/Name/{plantName}")
	public ResponseEntity<Plant> viewPlant(@PathVariable("plantName") String commonName) {
		Plant plan = plantService.viewPlant(commonName);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(plan.getPlantId())
				.toUri();
		return ResponseEntity.created(location).body(plan);
	}

	// VIEW PLANT BY TYPE
	@GetMapping("/plant/type")
	public List<Plant> viewAllPlants(String typeOfPlant) {
		return plantService.viewAllPlants(typeOfPlant);
	}

}
