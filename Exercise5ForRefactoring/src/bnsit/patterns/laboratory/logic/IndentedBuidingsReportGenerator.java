package bnsit.patterns.laboratory.logic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import bnsit.patterns.laboratory.model.Building;

public class IndentedBuidingsReportGenerator extends BuildingsReportGenerator {

	public IndentedBuidingsReportGenerator(List<Building> buildings) {
		super(buildings);
	}

	@Override
	public String formHeader() {
		String header = "Building report. (" + buildings.size() + " building/s)\n";
		header +=       "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
		return header;
	}
	
	@Override
	public String getSeparator() {
		return "  ";
	}

	@Override
	public String formFooter() {
		String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
	    String date = sdf.format(cal.getTime());
		
	    String footer = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
	    footer       += "Generated on: " + date + "\n";
		return footer;
	}


}
