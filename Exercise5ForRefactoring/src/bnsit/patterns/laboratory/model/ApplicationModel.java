package bnsit.patterns.laboratory.model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class ApplicationModel {

	private List<Building> buildings = new ArrayList<Building>();
	
	public void addBuilding(Building building) {
		buildings.add(building);
	}
	
	public void save(String filename) throws IOException {
		File file = new File(filename);
		new XStream().toXML(this, new FileWriter(file));
	}
	
	public void load(String filename) throws IOException {
		File file = new File(filename);
		
		ApplicationModel model = (ApplicationModel)
			new XStream().fromXML(new FileReader(file));
		
		buildings = model.buildings;
	}
	
	public void addRoomEqipment(String buildingName, Integer elevationNo, Integer roomNo, Equipment equipment) {
		Room room = findRoom( buildingName, elevationNo, roomNo );
		
		room.addEquipment( equipment );
	}
	
	public List<String> findBuildingsNames() {
		List<String> names = new ArrayList<String>();
		for (Building building : buildings) {
			names.add(building.getName());
		}
		return names;
	}
	
	public List<Integer> findElevationsNumbers(String buildingName) {
		List<Integer> elevationsNumbers = new ArrayList<Integer>();
		
		Building building = findBuilding( buildingName );
		
		if (building != null) {
			for (Elevation elevation : building.getElevations()) {
				elevationsNumbers.add(elevation.getNumber());
			}
		}
		
		return elevationsNumbers;
	}

	public List<Integer> findRoomsNumbers(String buildingName, Integer elevationNo) {
		List<Integer> roomsNumbers = new ArrayList<Integer>(); 
		
		Elevation elevation = findElevation( buildingName, elevationNo );
		if (elevation != null) {
			for(Room room : elevation.getRooms()) {
				roomsNumbers.add( room.getNumber() );
			}
		}
		
		return roomsNumbers;
	}
	
	public Room findRoom(String buildingName, Integer elevationNo, Integer roomNo) {
		Elevation elevation = findElevation( buildingName, elevationNo );
		
		if (elevation == null) {
			return null;
		}
		
		return elevation.getRoom( roomNo );
	}
	
	public Elevation findElevation(String buildingName, Integer elevationNo) {
		Building building = findBuilding( buildingName );
		
		if (building == null) {
			return null;			
		}
		
		return building.getElevation( elevationNo );
	}
	
	public Building findBuilding(String name) {
		Building result = null;
		for (Building building : buildings) {
			if (building.getName().equals(name)) {
				result = building;
				break;
			}
		}
		return result;
	}
	
	public List<Building> getBuildings() {
		return buildings;
	}
}