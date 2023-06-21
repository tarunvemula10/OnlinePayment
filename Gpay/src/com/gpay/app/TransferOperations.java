package com.gpay.app;

import java.util.Scanner;
import com.gpay.bank.*;
import com.gpay.user.*;

public class TransferOperations {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void trAndChk(BankOperations bankOperations) {
		System.out.println("1 for checking balance"
					+ "\n2 for Sending Amount"
					+ "\n0 to go back");
		switch(sc.nextInt()) {
		case 1:
			System.out.print("Enter the upi pin : ");
			int pin = sc.nextInt();
			
			if(UserDetails.verifyUpiPin(pin)) {
				bankOperations.balanceAmount();
			} else {
				System.err.println("Invalid Pin!, Try again");
				trAndChk(bankOperations);
			}
			break;
		case 2:
			System.out.print("Enter the Number to send : ");
			long phNo = sc.nextLong();
			while(!(CheckOperations.checkPhoneDigits(phNo))) {
				System.err.println("Not Valid");
				System.out.print("Enter the number again : ");
				phNo = sc.nextLong();
			}
			System.out.print("Enter the Amount : ");
			int amount = sc.nextInt();
			
			System.out.println("Enter the upi pin : ");
			int upi = sc.nextInt();
			if(UserDetails.verifyUpiPin(upi)) {
				bankOperations.transferAmount(amount, phNo);
			} else {
				System.err.println("Invalid Pin!, Try again");
				trAndChk(bankOperations);
			}
			break;
		case 0:
			break;
		default:
			System.err.println("Error!, Enter the Valid choice");
			trAndChk(bankOperations);
			break;
		}
	}
	
	public static void transferAndCheck() {
		int bank = 1;
		while(bank>=1 && bank<=3) {
			 
			 System.out.print("1 for Union Bank"
						+ "\n2 for Indian Bank"
						+ "\n3 for Andhra Bank"
						+ "\n0 key for exit");
			 System.out.print("\nEnter the Bank : ");
			 bank = sc.nextInt();
			 
			 if(bank==0) {
				 System.out.println("Application Closed!");
				 break;
			 }
			 else {
				 switch(bank) {
				 case 1:
					 trAndChk(new UnionBank());
					 break;
				 case 2:
					 trAndChk(new IndianBank());
					 break;
				 case 3:
					 trAndChk(new AndhraBank());
					 break;
				 default:
					 System.err.println("Invalid Choice");
					 break;
				 } 
			 }
		 }
	}
	
	public static boolean createAccountAndLogin() {
		
		Authentication.createAccount();
		System.out.println("Account Creation Successful");
		
		boolean login = Authentication.loginAccount();
		while(!login) {
			System.err.println("Invalid Pin!, Please enter pin again");
			login = Authentication.loginAccount();
		}
		return true;
	}
}
