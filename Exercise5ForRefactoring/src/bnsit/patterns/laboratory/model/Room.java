package bnsit.patterns.laboratory.model;

import java.util.ArrayList;
import java.util.List;

public class Room {

	private int number;
	
	private List<Equipment> equipments = new ArrayList<Equipment>();
	
	
	public Room(int number) {
		this.number = number;
	}

	public void addEquipment(Equipment equipment) {
		if (equipments == null) {
			equipments = new ArrayList<Equipment>();
		}
		equipments.add(equipment);
	}
	
	public int getNumber() {
		return number;
	}
	
}
