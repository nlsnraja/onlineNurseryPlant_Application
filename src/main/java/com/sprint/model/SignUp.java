package com.sprint.model;

import lombok.Data;

/**
 * Indicates that this class is a "Sign Up", developed for the sprint project
 * "Online Plant Nursery Application. This class is a part of model package
 * which defines the sign up parameters
 * 
 * @Date 21.09.2021
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 */

@Data
public class SignUp {
	private String userName;
	private String password;
	private String[] roles;
}