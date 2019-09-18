package bnsit.patterns.laboratory.model;

import java.util.Date;

public abstract class Equipment {

	protected String signature;
	protected int cost;
	protected Date purchaseDate;
	
	public Equipment(String signature, int cost, Date purchaseDate) {
		this.signature = signature;
		this.cost = cost;
		this.purchaseDate = purchaseDate;
	}
	
}
