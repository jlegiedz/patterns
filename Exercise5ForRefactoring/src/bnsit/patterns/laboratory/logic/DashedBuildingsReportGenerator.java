package bnsit.patterns.laboratory.logic;

import java.util.List;

import bnsit.patterns.laboratory.model.Building;

public class DashedBuildingsReportGenerator extends BuildingsReportGenerator {

	public DashedBuildingsReportGenerator(List<Building> buildings) {
		super(buildings);
	}

	@Override
	public String formHeader() {
		String header = "------------------------------------------------------\n";
		header +=       "                  Building report                     \n";
		header +=       "------------------------------------------------------\n";
		header +=       "Total buildings: " + buildings.size() + "\n";
		header +=       "------------------------------------------------------\n";
		return header;
	}
	
	@Override
	public String getSeparator() {
		return "--";
	}

	@Override
	public String formFooter() {
	    String footer = "------------------------------------------------------\n";
	    footer       += "------------------------------------------------------\n";
		return footer;
	}

}
