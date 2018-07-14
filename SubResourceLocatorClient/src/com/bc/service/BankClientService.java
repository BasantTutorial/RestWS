package com.bc.service;

import com.bc.invoker.BankClient;

public class BankClientService {
	public static void main(String[] args) {
		BankClient client = new BankClient();
		System.out.println(client.findInterest("sbi", "StudyLoan"));
	}
}
