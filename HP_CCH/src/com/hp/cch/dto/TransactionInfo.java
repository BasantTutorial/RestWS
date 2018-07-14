package com.hp.cch.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "transactionType", "amount", "txDate" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "transactionInfo")
public class TransactionInfo {
	@XmlElement(type = String.class)
	private String transactionType;
	@XmlElement(type = Double.class)
	private double amount;
	@XmlElement(type = String.class)
	private String txDate;

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTxDate() {
		return txDate;
	}

	public void setTxDate(String txDate) {
		this.txDate = txDate;
	}

}
