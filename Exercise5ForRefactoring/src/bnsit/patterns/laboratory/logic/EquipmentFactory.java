package bnsit.patterns.laboratory.logic;

import java.util.Date;

import bnsit.patterns.laboratory.model.Chair;
import bnsit.patterns.laboratory.model.Couch;
import bnsit.patterns.laboratory.model.Equipment;
import bnsit.patterns.laboratory.model.Lamp;
import bnsit.patterns.laboratory.model.Painting;
import bnsit.patterns.laboratory.model.Plant;
import bnsit.patterns.laboratory.model.Table;

public class EquipmentFactory {

	public Equipment create(String equipmentType, String signagure,
			int cost, Date purchaseDate) {
		Equipment result = null;
		
		if (equipmentType.equals("chair")) {
			result = new Chair(signagure, cost, purchaseDate);
		} else if (equipmentType.equals("table")) {
			result = new Table(signagure, cost, purchaseDate);
		} else if (equipmentType.equals("painting")) {
			result = new Painting(signagure, cost, purchaseDate);
		} else if (equipmentType.equals("lamp")) {
			result = new Lamp(signagure, cost, purchaseDate);
		} else if (equipmentType.equals("couch")) {
			result = new Couch(signagure, cost, purchaseDate);
		} else if (equipmentType.equals("plant")) {
			result = new Plant(signagure, cost, purchaseDate);
		} 
		
		return result;
	}
	
}
