package bnsit.patterns.laboratory.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bnsit.patterns.laboratory.logic.BuildingBuilder;
import bnsit.patterns.laboratory.model.ApplicationModel;
import bnsit.patterns.laboratory.model.Building;

public class AddBuildingCommand implements Command {

	private ApplicationModel model = null;
	
	public AddBuildingCommand(ApplicationModel model) {
		this.model = model;
	}
	
	@Override
	public void execute(String parameters) {
		Scanner scanner = new Scanner(System.in);
		BuildingBuilder buildingBuilder = new BuildingBuilder();
		
		System.out.print("Name: ");
		String name = scanner.nextLine();
		
		System.out.print("Address: ");
		String address = scanner.nextLine();
		
		buildingBuilder.buildBuilding(name, address);
		
		
		System.out.print("Elevations range: ");
		int firstElevation = scanner.nextInt();
		int lastElevation = scanner.nextInt();
		scanner.nextLine();
		
		buildingBuilder.addElevations(firstElevation, lastElevation);
		
		
		for (int i = firstElevation; i <= lastElevation; ++i) {
			System.out.print("Enter number of rooms for elevation " + i + ": ");
			int numberOfRooms = scanner.nextInt();
			scanner.nextLine();
			
			List<Integer> roomNumbers = new ArrayList<Integer>();
			System.out.println("Enter room numbers for elevation " + i + ": ");
			for (int j = 0; j < numberOfRooms; ++j) {
				roomNumbers.add(scanner.nextInt());
			}
			scanner.nextLine();
			
			buildingBuilder.addRooms(i, roomNumbers);
		}
		
		
		Building building = buildingBuilder.getBuilding();
		model.addBuilding(building);		
	}

	@Override
	public String printHelp() {
		return "Starts building creator";
	}

}
