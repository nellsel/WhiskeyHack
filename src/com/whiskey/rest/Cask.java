package com.whiskey.rest;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Cask implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int CaskId;
	private String TimeInUse;
	private int KeepOrBuy;
	
	public String getTimeInUse() {
		return TimeInUse;
	}

	public void setTimeInUse(String timeInUse) {
		TimeInUse = timeInUse;
	}

	public int getKeepOrBuy() {
		return KeepOrBuy;
	}

	public void setKeepOrBuy(int keepOrBuy) {
		KeepOrBuy = keepOrBuy;
	}

	public int getCaskId() {
		return CaskId;
	}

	public void setCaskId(int caskId) {
		CaskId = caskId;
	}
	
}
