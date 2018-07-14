package com.ow.dto;

public class Wallet {
	private int walletId;
	private User user;
	private double balance;
	private String status;

	public Wallet(int walletId, User user, double balance, String status) {
		this.walletId = walletId;
		this.user = user;
		this.balance = balance;
		this.status = status;
	}

	public Wallet() {
		// No-Operation
	}

	public int getWalletId() {
		return walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
