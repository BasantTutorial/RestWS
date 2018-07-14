package com.hp.cch.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "txMode", "txAmount", "txLoc" })
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "status")
public class Status {

	@XmlElement(type = String.class)
	private String txMode;
	@XmlElement(type = Double.class)
	private double txAmount;
	@XmlElement(type = String.class)
	private String txLoc;

	public String getTxMode() {
		return txMode;
	}

	public void setTxMode(String txMode) {
		this.txMode = txMode;
	}

	public double getTxAmount() {
		return txAmount;
	}

	public void setTxAmount(double txAmount) {
		this.txAmount = txAmount;
	}

	public String getTxLoc() {
		return txLoc;
	}

	public void setTxLoc(String txLoc) {
		this.txLoc = txLoc;
	}

}
