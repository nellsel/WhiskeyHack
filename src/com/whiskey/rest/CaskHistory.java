package com.whiskey.rest;

import java.sql.Date;

public class CaskHistory implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int CaskHistoryId;
	
	private int CaskId ;
	private int DistilleryId;
	private String CaskHistoryDate;
	private String AlcoholType; 
	
	public int getCaskId() {
		return CaskId;
	}
	public void setCaskId(int caskId) {
		CaskId = caskId;
	}
	public int getDistilleryId() {
		return DistilleryId;
	}
	public void setDistilleryId(int distilleryId) {
		DistilleryId = distilleryId;
	}
	public String getCaskHistoryDate() {
		return CaskHistoryDate;
	}
	public void setCaskHistoryDate(String caskHistoryDate) {
		CaskHistoryDate = caskHistoryDate;
	}
	public String getAlcoholType() {
		return AlcoholType;
	}
	public void setAlcoholType(String alcoholType) {
		AlcoholType = alcoholType;
	}
	public int getCaskHistoryId() {
		return CaskHistoryId;
	}
	public void setCaskHistoryId(int caskHistoryId) {
		CaskHistoryId = caskHistoryId;
	}
	
}
