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
		this.upiPin= upiPin;
	}
	
	public String getUserName() {
		return userName;
	}
	public long getUserPhone() {
		return userPhone;
	}
	
	public static boolean verifyUpiPin(int pin) {
		if(pin==instance.upiPin) {
			return true;
		}
		return false;
	}
	public static boolean verifyGPin(int pin) {
		if(pin==instance.gPin) {
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