package com.sprint.service;

import com.sprint.entities.Users;

/**
 * Indicates that this interface is a " IUserService", developed for the sprint
 * project "Online Plant Nursery Application". This deals with signin and
 * signout operations
 * 
 * @Date 22.09.2021
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 **/

public interface IUserService {
	public abstract Users addNewUser(Users user);

	public abstract Users signIn(Users user);

	public abstract Users signOut(Users user);

}