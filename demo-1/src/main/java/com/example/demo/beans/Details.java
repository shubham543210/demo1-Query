package com.example.demo.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Details {
	
	private String name;
	@Id
	private String eid;
	private String mobileNumber;
	
	public Details()
	{
		
	}
	public Details(String name, String eid, String mobileNumber) {
		super();
		this.name = name;
		this.eid = eid;
		this.mobileNumber = mobileNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "Details [name=" + name + ", Eid=" + eid + ", mobileNumber=" + mobileNumber + "]";
	}

}
