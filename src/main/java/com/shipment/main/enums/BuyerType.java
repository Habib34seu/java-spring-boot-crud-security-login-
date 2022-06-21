package com.shipment.main.enums;

public enum BuyerType {

	L ("Local"),
	F ("Forign");
	
	private final String name;
	BuyerType(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
}
