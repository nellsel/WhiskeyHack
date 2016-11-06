package com.whiskey.rest;

public class Distillery implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int DistilleryId;
	private String DistilleryName; 
	private String ProductTye;
	private String ProductsubCategory;
	private String ScannerLocation;
	

	public String getProductTye() {
		return ProductTye;
	}

	public void setProductTye(String productTye) {
		ProductTye = productTye;
	}

	public String getProductsubCategory() {
		return ProductsubCategory;
	}

	public void setProductsubCategory(String productsubCategory) {
		ProductsubCategory = productsubCategory;
	}

	public String getScannerLocation() {
		return ScannerLocation;
	}

	public void setScannerLocation(String scannerLocation) {
		ScannerLocation = scannerLocation;
	}

	public int getDistilleryId() {
		return DistilleryId;
	}

	public void setDistilleryId(int distilleryId) {
		DistilleryId = distilleryId;
	}

	public String getDistilleryName() {
		return DistilleryName;
	}

	public void setDistilleryName(String distilleryName) {
		DistilleryName = distilleryName;
	}
}
