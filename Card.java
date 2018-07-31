package com.pranali;

import java.io.Serializable;
import java.sql.Date;

public class Card implements Serializable{
private int id;
private Date expiry;
private int customer_id; 
private float balance;
private String credit_limit;


public Card() {
	super();
	// TODO Auto-generated constructor stub
}
public Card(int id, Date expiry, int customer_id, float balance, String credit_limit) {
	super();
	this.id = id;
	this.expiry = expiry;
	this.customer_id = customer_id;
	this.balance = balance;
	this.credit_limit = credit_limit;
}
public int getId() {
	return id;
}
public Date getExpiry() {
	return expiry;
}
public int getCustomer_id() {
	return customer_id;
}
public float getBalance() {
	return balance;
}
public String getCredit_limit() {
	return credit_limit;
}
public void setId(int id) {
	this.id = id;
}
public void setExpiry(Date expiry) {
	this.expiry = expiry;
}
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}
public void setBalance(float balance) {
	this.balance = balance;
}
public void setCredit_limit(String credit_limit) {
	this.credit_limit = credit_limit;
}
@Override
public String toString() {
	return "Card [id=" + id + ", expiry=" + expiry + ", customer_id=" + customer_id + ", balance=" + balance
			+ ", credit_limit=" + credit_limit + "]";
}




}
