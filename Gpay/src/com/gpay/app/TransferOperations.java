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
			bankOperations.balanceAmount();
			break;
		case 2:
			System.out.print("Enter the Number to send : ");
			long phNo = sc.nextLong();
			
			while(!CheckOperations.checkPhoneDigits(phNo)) {
				System.err.println("Please Enter valid number");
				phNo = sc.nextLong();
			}
			System.out.print("Enter the Amount : ");
			int amount = sc.nextInt();
			bankOperations.transferAmount(amount, phNo);
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
		 
		 System.out.print("1 for Union Bank"
					+ "\n2 for Indian Bank"
					+ "\n3 for Andhra Bank"
					+ "\nAny key for exit");
		 System.out.print("\nEnter the Bank : ");
		 int bank = sc.nextInt();

		 while(bank>=1 && bank<=3) {
			 switch(bank) {
			 case 1:
				 trAndChk(new UnionBank());
				 transferAndCheck();
				 break;
			 case 2:
				 trAndChk(new IndianBank());
				 transferAndCheck();
				 break;
			 case 3:
				 trAndChk(new AndhraBank());
				 transferAndCheck();
				 break;
			 default:
				 System.out.println("Application Closed");
				 break;
			 }
			 System.out.print("1 for Union Bank"
						+ "\n2 for Indian Bank"
						+ "\n3 for Andhra Bank"
						+ "\nAny key for exit");
			 System.out.print("\nEnter the Bank : ");
			 bank = sc.nextInt();
		 }
	}
	
	public static boolean createAccountAndLogin() {
		Authentication.createAccount();
		System.out.println("Account Creation Successful");
		
		while(!Authentication.loginAccount()) {
			Authentication.loginAccount();
		}
		return true;
	}
}
