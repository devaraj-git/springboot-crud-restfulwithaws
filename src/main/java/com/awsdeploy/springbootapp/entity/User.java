package com.awsdeploy.springbootapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "First_Name")
	private String FirstName;
	@Column(name = "Last_Name")
	private String LastName;
	@Column(name = "Email")
	private String Emial;
	
	public User() {
		
	}
	public User(long id, String firstName, String lastName, String emial) {
		super();
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		Emial = emial;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmial() {
		return Emial;
	}
	public void setEmial(String emial) {
		Emial = emial;
	}
	

}
