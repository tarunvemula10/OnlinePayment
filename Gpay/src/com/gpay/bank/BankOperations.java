package com.gpay.bank;

public interface BankOperations {
	
	public void transferAmount(int amount, long toPhone);
	public void balanceAmount();
}
