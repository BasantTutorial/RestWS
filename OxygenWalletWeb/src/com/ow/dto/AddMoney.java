package com.ow.dto;

public class AddMoney {
private int walletId;
private String userName;
private String fromAccount;
private double amount;

public int getWalletId() {
	return walletId;
}
public void setWalletId(int walletId) {
	this.walletId = walletId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getFromAccount() {
	return fromAccount;
}
public void setFromAccount(String fromAccount) {
	this.fromAccount = fromAccount;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}

}
