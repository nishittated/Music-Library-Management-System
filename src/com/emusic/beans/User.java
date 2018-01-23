/* Copyright (c) Nishit Tated. All Rights Reserved.
   Project name: Online Election Voting System
 * This project is licensed under the MIT License, see LICENSE.
 */
package com.emusic.beans;

public class User {
	private int id;
	private String name, pwd, email, address, phoneNo, userType;
	public User(){}
	public User(int id, String name, String pwd, String email, String address,
			String phoneNo, String userType) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.address = address;
		this.phoneNo = phoneNo;
		this.userType = userType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}
