package com.sprint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.dao.IUserRepository;
import com.sprint.entities.Users;

/**
 * Indicates that this class is a " IUserServiceImpl", developed for the sprint
 * project "Online Plant Nursery Application. This class takes the object of the
 * repository by autowiring
 * 
 * @Date 22.09.2021
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 **/

@Service(value = "IUserService")
public class IUserServiceImpl implements IUserService {
	@Autowired
	IUserRepository repository;

	// ADD NEW USER
	@Override
	public Users addNewUser(Users user) {
		return repository.save(user);
	}

	// USER SIGN IN
	@Override
	public Users signIn(Users user) {
		return null;
	}

	// USER SIGN OUT
	@Override
	public Users signOut(Users user) {
		return null;
	}

}