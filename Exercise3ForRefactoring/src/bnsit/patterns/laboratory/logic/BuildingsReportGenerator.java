package bnsit.patterns.laboratory.logic;

import java.util.ArrayList;
import java.util.List;

import bnsit.patterns.laboratory.model.Building;
import bnsit.patterns.laboratory.model.Elevation;
import bnsit.patterns.laboratory.model.Room;

public abstract class BuildingsReportGenerator {
	
	protected List<Building> buildings = new ArrayList<Building>();

	public BuildingsReportGenerator(List<Building> buildings) {
		this.buildings = buildings;
	}

	public final String generate() {
		
		String report = "";
		
		report += formHeader();
		
		for (Building building : buildings) {
			report += formEntry(building.getName() + " (" + building.getAddress() + ")", 0);
			for (Elevation elevation : building.getElevations()) {
				report += formEntry("Elevation " + elevation.getNumber(), 1);
				for (Room room : elevation.getRooms()) {
					report += formEntry("Room " + room.getNumber(), 2);
				}
			}
		}
		
		report += formFooter();
		
		return report;
		
	}
	
	public final String formEntry(String entry, int indentationLevel) {
		String indentation = "";
		
		for (int i = 0; i < indentationLevel; ++ i) {
			indentation += getSeparator();
		}
		
		return (indentation + entry + "\n");
	}
	
	public abstract String getSeparator();
	
	public abstract String formHeader();
	
	public abstract String formFooter();
	
}
