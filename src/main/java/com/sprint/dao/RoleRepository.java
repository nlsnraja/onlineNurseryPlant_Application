package com.sprint.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.entities.Role;
import com.sprint.entities.Roles;

/**
 * Indicates that this interface is a " RoleRepository", developed for the
 * sprint project "Online Plant Nursery Application" This interface is a part of
 * dao package which has some pre-defined methods in the class such as
 * findAll,findById,save...etc . We can create a custom methods by using
 * "findBy" keyword followed by variable name
 * 
 * @Date 24.09.2021
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 **/

@Repository(value = "RoleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByRoleName(Roles role);
}