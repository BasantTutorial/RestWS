package com.ahc.test;

import java.util.UUID;

import com.ahc.invoker.UniqueIdGeneratorResourceInvoker;

public class HeaderClientTest {
	public static void main(String[] args) {
		UniqueIdGeneratorResourceInvoker invoker = new UniqueIdGeneratorResourceInvoker();
		String id = UUID.randomUUID().toString();
		String generatedId = id.substring(0, 12);
		System.out.println(invoker.getUniqueId(generatedId, "Basanta"));
	}
}
