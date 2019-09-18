package bnsit.patterns.laboratory.logic;

import java.util.List;

import bnsit.patterns.laboratory.model.Building;
import bnsit.patterns.laboratory.model.Elevation;
import bnsit.patterns.laboratory.model.Room;

public class BuildingBuilder {

	private Building building = null;
	
	public void buildBuilding(String name, String address) {
		building = new Building(name, address);
	}
	
	public void addElevations(int first, int last) {
		for (int i = first; i <= last; ++i) {
			Elevation elevation = new Elevation(i);
			building.addElevation(elevation);
		}
	}

	public void addRooms(int elevationNumber, List<Integer> roomNumbers) {
		Elevation elevation = building.getElevation(elevationNumber);
		
		for (Integer roomNumber : roomNumbers) {
			Room room = new Room(roomNumber);
			elevation.addRoom(room);
		}
	}
	
	public Building getBuilding() {
		return building;
	}
	
}
