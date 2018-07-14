package com.ap.test;

import java.util.concurrent.ExecutionException;

import javax.ws.rs.WebApplicationException;

import com.ap.invoker.StockResourceInvoker;

public class AsyncClientTest {
	public static void main(String[] args) {
		StockResourceInvoker invoker = new StockResourceInvoker();
		try {
			invoker.getPrice("cipla");
		} catch (InterruptedException | ExecutionException e) {
			throw new WebApplicationException(e);
		}
	}
}
