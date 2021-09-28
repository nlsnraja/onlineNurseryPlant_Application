package com.sprint.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Indicates that this class is a " Users Entity"
 * 
 * @date 21/09/2021 This class is a part of entity package which defines the
 *       attributes of Users, Role entity is mapped by one to many relationship
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 */

@Entity(name = "onlineuser")
@Table(name = "onlineuser")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int userId;
	@Column(name = "name")
	private String userName;

	// USERS MAPPED WITH CUSTOMER
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customerId;
	private String password;

	// USERS MAPPED WITH ROLES
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public Users(int i, String string) {
		// TODO Auto-generated constructor stub
	}
}
