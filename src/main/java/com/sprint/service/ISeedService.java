package com.sprint.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint.entities.Seed;

/**
 * Indicates that this interface is a " ISeedService", developed for the sprint
 * project "Online Plant Nursery Application" This interface is a part of
 * service package which has some method declarations in the class such as
 * add,update,delete,view .
 * 
 * @Date 22.09.2021
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 **/

@Service
public interface ISeedService {
	Seed addSeed(Seed seed);

	Seed updateSeed(Seed seed);

	Seed deleteSeed(Seed seed);

	Seed viewSeed(int seedId);

	Seed viewSeed(String commonName);

	List<Seed> viewAllSeeds();

	List<Seed> viewAllSeeds(String typeOfSeed);
}
