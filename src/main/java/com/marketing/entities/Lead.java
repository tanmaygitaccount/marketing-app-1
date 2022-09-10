package com.marketing.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//using java code we creating table in database

@Entity
@Table(name="leads")
public class Lead {
	
     @Id                                                    //for unique id
     @GeneratedValue(strategy = GenerationType.IDENTITY)    //for Auto increment id
	 private long id;
     
     @Column(name="first_name", nullable = false)  // nullable means it can't be null value,it should have some data
	 private String firstName;
	 
     @Column(name="last_name", nullable = false)  
	 private String lastName;
     
     @Column(name= "email" , nullable = false , unique = true)  //unique means email id have to unique its avoid duplicate data stored 
     private String email;
     
     @Column(name= "mobile" , nullable = false , unique = true) 
     private long mobile;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
     
}
