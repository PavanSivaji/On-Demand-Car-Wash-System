package com.example.washerservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class WasherModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long wid;
	private String wname;
	private long wphonenumber;
	private String wemail;
	private String waddress;
	private long washerNIC;
	private int wsalary;
	private int wage;
	
	public WasherModel() {
		super();
	}

	public long getWid() {
		return wid;
	}

	public void setWid(long wid) {
		this.wid = wid;
	}

	public String getWname() {
		return wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public long getWphonenumber() {
		return wphonenumber;
	}

	public void setWphonenumber(long wphonenumber) {
		this.wphonenumber = wphonenumber;
	}

	public String getWemail() {
		return wemail;
	}

	public void setWemail(String wemail) {
		this.wemail = wemail;
	}

	public String getWaddress() {
		return waddress;
	}

	public void setWaddress(String waddress) {
		this.waddress = waddress;
	}

	public long getWasherNIC() {
		return washerNIC;
	}

	public void setWasherNIC(long washerNIC) {
		this.washerNIC = washerNIC;
	}

	public int getWsalary() {
		return wsalary;
	}

	public void setWsalary(int wsalary) {
		this.wsalary = wsalary;
	}

	public int getWage() {
		return wage;
	}

	public void setWage(int wage) {
		this.wage = wage;
	}
	
	
	
	
	
	
	

}
