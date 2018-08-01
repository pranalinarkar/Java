package com.pranali;

import java.io.Serializable;

public class Customer implements Serializable{
	private int customer_id;
private String firstName;
private String lastName;
private String email;


public Customer() {
	super();
	// TODO Auto-generated constructor stub
}

public Customer(int id, String firstName, String lastName, String email) {
	super();
	this.customer_id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
}

public int getId() {
	return customer_id;
}

public String getFirstName() {
	return firstName;
}

public String getLastName() {
	return lastName;
}

public String getEmail() {
	return email;
}

public void setId(int id) {
	this.customer_id = id;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public void setEmail(String email) {
	this.email = email;
}

@Override
public String toString() {
	return "Customer [id=" + customer_id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
}



}
