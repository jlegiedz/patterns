package bnsit.patterns.laboratory.model;

import java.util.ArrayList;
import java.util.List;

public class Building {
	private String name;
	private String address;
	private List<Elevation> elevations = new ArrayList<Elevation>();
	
	public Building(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public void addElevation(Elevation elevation) {
		elevations.add(elevation);
	}
	
	public Elevation getElevation(int number) {
		Elevation result = null;
		for (Elevation elevation : elevations) {
			if (elevation.getNumber() == number) {
				result = elevation;
				break;
			}
		}
		return result;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Elevation> getElevations() {
		return elevations;
	}
	public void setElevations(List<Elevation> elevations) {
		this.elevations = elevations;
	}
	
}
