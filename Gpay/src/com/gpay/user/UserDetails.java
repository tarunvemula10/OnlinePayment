package com.gpay.user;

public class UserDetails {
	
	public String userName;
	public long userPhone;
	private int gPin;
	private int upiPin;
	
	private static UserDetails instance = null;
	
	private UserDetails(String userName, long userPhone, int gPin, int upiPin) {
		this.userName = userName;
		this.userPhone = userPhone;
		this.gPin = gPin;
		this.upiPin = upiPin;
	}
	
	public String getUserName() {
		return userName;
	}
	public long getUserPhone() {
		return userPhone;
	}
	
	public boolean verifyUpiPin(int pin) {
		if(pin==upiPin) {
			return true;
		}
		return false;
	}
	public boolean verifyGPin(int pin) {
		if(pin==gPin) {
			return true;
		}
		return false;
	}
	
	public static UserDetails getInstance(String userName, long userPhone, int gPin, int upiPin) {
		if(instance==null) {
			instance = new UserDetails(userName, userPhone, gPin, upiPin);
		}
		return instance;
	}
}