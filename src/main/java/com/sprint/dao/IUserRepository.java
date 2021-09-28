package com.sprint.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.entities.Users;

/**
 * Indicates that this interface is a " IUserRepository", developed for the
 * sprint project "Online Plant Nursery Application" This interface is a part of
 * dao package which has some pre-defined methods in the class such as
 * findAll,findById,save...etc . We can create a custom methods by using
 * "findBy" keyword followed by variable name
 * 
 * @Date 24.09.2021
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 **/

@Repository(value = "IUserRepository")
public interface IUserRepository extends JpaRepository<Users, Integer> {
	public Users findByUserName(String userName);

	public boolean existsByUserName(String userName);
}