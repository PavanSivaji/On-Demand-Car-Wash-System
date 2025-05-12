package com.example.user.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class UserModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long uid;
	private String uname;
	private long UserPhoneNumber;
	private String uemail;
	private String uaddress;
	private long userNIC;
	private int u_age;
	public UserModel() {
		super();
	}
	public UserModel(long uid, String uame, long userPhoneNumber, String uemail, String uaddress, long userNIC,
			int u_age) {
		super();
		this.uid = uid;
		this.uname = uname;
		UserPhoneNumber = userPhoneNumber;
		this.uemail = uemail;
		this.uaddress = uaddress;
		this.userNIC = userNIC;
		this.u_age = u_age;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public long getUserPhoneNumber() {
		return UserPhoneNumber;
	}
	public void setUserPhoneNumber(long userPhoneNumber) {
		UserPhoneNumber = userPhoneNumber;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public long getUserNIC() {
		return userNIC;
	}
	public void setUserNIC(long userNIC) {
		this.userNIC = userNIC;
	}
	public int getU_age() {
		return u_age;
	}
	public void setU_age(int u_age) {
		this.u_age = u_age;
	}
	
   
    
    
    
	

}








	

	
	
	
	
	