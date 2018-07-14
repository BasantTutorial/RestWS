package com.afc.test;

import com.afc.invoker.OlaCabManagementInvoker;

public class FormClientTest {
	public static void main(String[] args) {
		OlaCabManagementInvoker invoker = new OlaCabManagementInvoker();
		String msg = invoker.bookCab("Hydrabad", "Banglore", "Mini");
		System.out.println(msg);
	}
}
