package com.gpay.app;
import java.util.Scanner;
import com.gpay.user.CheckOperations;
import com.gpay.user.UserDetails;

public class Authentication {
	
	static Scanner sc = new Scanner(System.in);
	
	static private String userName;
	static private long phNo;
	static private int googlePin;
	static private int UPI_Pin;
	
	public static void createAccount() {
		
		System.out.print("Enter the Name : ");
		String name = sc.next();
		
		System.out.print("Enter the Phone Number : ");
		long pNo = sc.nextLong();
		
		System.out.print("Enter the G-pin : ");
		int gPin = sc.nextInt();
		
		System.out.println("Confirm G-pin : ");
		int cGpin = sc.nextInt();
		
		System.out.print("Enter the UPI pin : ");
		int upiPin = sc.nextInt();
		
		System.out.print("Confirm UPI pin : ");
		int cUpiPin = sc.nextInt();
		
		if(CheckOperations.confirmPin(gPin, cGpin) && 
				CheckOperations.confirmPin(upiPin, cUpiPin) && 
				CheckOperations.checkPhoneDigits(pNo)) {
			
			UserDetails.getInstance(name, pNo, gPin, upiPin);
			
			name = userName;
			pNo = phNo;
			googlePin = gPin;
			UPI_Pin = upiPin;
		} else {
			System.err.println("The Details are not Accurate, Please Enter again");
			createAccount();
		}
	}
	
	public static boolean loginAccount() {
		
		System.out.print("Enter the gPin : ");
		int gPin = sc.nextInt();
		
		if(UserDetails.getInstance(userName, phNo, googlePin, UPI_Pin)
				.verifyGPin(gPin)) {
			return true;
		}
		
		return false;
	}
}
