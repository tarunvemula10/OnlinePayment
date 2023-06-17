package com.gpay.bank;

public class AndhraBank implements BankOperations {

	private static int walletAmount = 6000;
	
	@Override
	public void transferAmount(int amount, long toPhone) {
		if(walletAmount>0 && amount<walletAmount) {
			System.out.println("Rs."+amount+" sent to "+toPhone);
			walletAmount -= amount;
		} else {
			System.err.println("Error!, Insufficient Money");
		}
	}

	@Override
	public void balanceAmount() {
		System.out.println("The Balance Amount in Andhra Bank is "+walletAmount);
	}
	
}
