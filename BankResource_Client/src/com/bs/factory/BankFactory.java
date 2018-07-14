package com.bs.factory;

import com.bs.client.Bank;
import com.bs.invoker.BankResourceInvoker;

public class BankFactory {

	public static Bank getInstance(String invokerType) {
		if (invokerType.equalsIgnoreCase("BankResourceInvoker")) {
			return new BankResourceInvoker();
		} else {
			return null;
		}
	}

}
