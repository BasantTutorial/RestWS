package com.bs.test.caller;

import com.bs.client.Bank;
import com.bs.factory.BankFactory;

public class BankClientTest {

	public static void main(String[] args) {
		Bank bank = BankFactory.getInstance("BankResourceInvoker");
		String data = bank.getInterest("Basant1234", 1453, "Basant", 2016);
		System.out.println(data);
	}

}
