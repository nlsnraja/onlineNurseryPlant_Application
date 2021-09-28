package com.sprint.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint.entities.Planter;

/**
 * Indicates that this interface is a " IPlanterService", developed for the
 * sprint project "Online Plant Nursery Application" This interface is a part of
 * service package which has some method declarations in the class such as
 * add,update,delete,view .
 * 
 * @Date 22.09.2021
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 **/

@Service
public interface IPlanterService {
	Planter addPlanter(Planter planter);

	Planter updatePlanter(Planter planter);

	Planter deletePlanter(Planter planter);

	Planter viewPlanter(int planterId);

	Planter viewPlanter(String planterShape);

	List<Planter> viewAllPlanters();

	List<Planter> viewAllPlanters(int minCost, int maxCost);
}
