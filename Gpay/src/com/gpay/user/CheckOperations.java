package com.gpay.user;

public class CheckOperations {
	
	public static boolean checkPhoneDigits(long phoneNo) {	
		if((Long.toString(phoneNo).length())==10) {
			return true;
		}
		return false;
	}
	
	public static boolean confirmPin(int firstPin, int confPin) {
		
		if(confPin == firstPin) {
			return true;
		}
		
		return false;
	}
}