package com.gpay.app;

public class MainGpay {
	public static void main(String[] args) {
		
		boolean login = TransferOperations.createAccountAndLogin();
		if(login) {
			TransferOperations.transferAndCheck();
		}
	}
}