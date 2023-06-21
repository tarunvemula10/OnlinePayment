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
		userName = sc.next();
		
		System.out.print("Enter the Phone Number : ");
		phNo = sc.nextLong();
		
		while(!(CheckOperations.checkPhoneDigits(phNo))) {
			System.err.println("Invalid Number!");
			System.out.print("Please Enter the number again : ");
			phNo = sc.nextLong();
		}
		
		System.out.print("Enter the Google pin : ");
		googlePin = sc.nextInt();
		
		System.out.println("Confirm Google pin : ");
		int cGpin = sc.nextInt();
		
		while(!CheckOperations.confirmPin(googlePin, cGpin)) {
			System.err.println("Invalid pin!, Please Enter the pin again");
			
			System.out.print("Enter the Google pin : ");
			googlePin = sc.nextInt();
			
			System.out.println("Confirm Google pin : ");
			cGpin = sc.nextInt();
		}
		
		System.out.print("Enter the UPI pin : ");
		UPI_Pin = sc.nextInt();
		
		System.out.print("Confirm UPI pin : ");
		int cUpiPin = sc.nextInt();
		
		while(!CheckOperations.confirmPin(UPI_Pin, cUpiPin)) {
			System.err.println("Invalid pin!, Please Enter the pin again");
			
			System.out.print("Enter the UPI pin : ");
			UPI_Pin = sc.nextInt();
			
			System.out.print("Confirm UPI pin : ");
			cUpiPin = sc.nextInt();
		}
	}
	
	public static boolean loginAccount() {
		
		System.out.print("Enter the gPin : ");
		int gPin = sc.nextInt();
		
		UserDetails.getInstance(userName, phNo, googlePin, UPI_Pin);
		
		if(UserDetails.verifyGPin(gPin)) {
			return true;
		}
		
		return false;
	}
}
