package com.achc.test;

import com.achc.invoker.OrderResourceInvoker;

public class PredefinedContentHandlerTestClient {
	public static void main(String[] args) {
		OrderResourceInvoker invoker = new OrderResourceInvoker();
		System.out
				.println(invoker.newOrder("Product:--Apple    Price:--50000"));
	}
}
