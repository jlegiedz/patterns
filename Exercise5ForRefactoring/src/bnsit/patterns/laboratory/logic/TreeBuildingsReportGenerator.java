package bnsit.patterns.laboratory.logic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import bnsit.patterns.laboratory.model.Building;

public class TreeBuildingsReportGenerator extends BuildingsReportGenerator {

	public TreeBuildingsReportGenerator(List<Building> buildings) {
		super(buildings);
	}

	@Override
	public String formHeader() {
		String header = "******************************************************\n";
		header       += "                   Building report                    \n";
		header       += "******************************************************\n";
		return header;
	}
	
	@Override
	public String getSeparator() {
		return "|-";
	}

	@Override
	public String formFooter() {
		String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
	    String date = sdf.format(cal.getTime());
		
	    String footer = "****************" + date + "*******************\n";
		return footer;
	}

}
