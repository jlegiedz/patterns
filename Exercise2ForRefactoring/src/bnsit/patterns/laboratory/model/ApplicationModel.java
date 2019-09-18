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
	
	public List<Building> getBuildings() {
		return buildings;
	}
}
