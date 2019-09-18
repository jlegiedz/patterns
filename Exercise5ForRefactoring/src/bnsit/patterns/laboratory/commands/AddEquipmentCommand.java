package bnsit.patterns.laboratory.commands;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import bnsit.patterns.laboratory.logic.EquipmentFactory;
import bnsit.patterns.laboratory.model.ApplicationModel;
import bnsit.patterns.laboratory.model.Equipment;

public class AddEquipmentCommand implements Command {
	
	private ApplicationModel model = null;
	
	private EquipmentFactory equipmentFactory = new EquipmentFactory();

	public AddEquipmentCommand(ApplicationModel model) {
		this.model = model;
	}
	
	@Override
	public void execute(String parameters) {
		Scanner scanner = new Scanner(System.in);
		if (parameters.equals("")) {
			System.out.println("Missing equipment type parameter.");
			return;
		}
		
		System.out.print("Signature: ");
		String signature = scanner.nextLine();
		System.out.print("Cost: ");
		int cost = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Purchase Date (YYYY-MM-DD): ");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date purchaseDate = null;
		try {
			purchaseDate = df.parse(scanner.nextLine());
		} catch (ParseException e) {
			System.out.println("Wrong date format.");
			return;
		}
		
		Equipment equipment
			= equipmentFactory.create(parameters, signature, cost, purchaseDate);
		
		System.out.println("Which building (" + getBuildingsNames() + ")?");
		String buildingName = scanner.nextLine();

		System.out.println("Which elevation (" + getElevationsNumbers(buildingName) + ")?");
		int elevationNo = scanner.nextInt();
		
		System.out.println("Which room (" + getRoomsNumbers(buildingName, elevationNo) + ")?");
		int roomNo = scanner.nextInt();
		
		model.addRoomEqipment( buildingName, elevationNo, roomNo, equipment );
			
	}

	@Override
	public String printHelp() {
		return "Add equipment (params: type={chair, table, painting, lamp, couch, plant})";
	}
	
	private List<String> getBuildingsNames() {
		return model.findBuildingsNames();
	}
	
	private List<Integer> getElevationsNumbers(String buildingName) {
		return model.findElevationsNumbers( buildingName );
	}
	
	private List<Integer> getRoomsNumbers(String buildingName, Integer elevationNo) {
		return model.findRoomsNumbers( buildingName, elevationNo );
	}

}
