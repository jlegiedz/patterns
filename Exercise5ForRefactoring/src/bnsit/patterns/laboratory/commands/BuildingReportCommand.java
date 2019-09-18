package bnsit.patterns.laboratory.commands;

import bnsit.patterns.laboratory.logic.BuildingsReportGenerator;
import bnsit.patterns.laboratory.logic.DashedBuildingsReportGenerator;
import bnsit.patterns.laboratory.logic.IndentedBuidingsReportGenerator;
import bnsit.patterns.laboratory.logic.TreeBuildingsReportGenerator;
import bnsit.patterns.laboratory.model.ApplicationModel;

public class BuildingReportCommand implements Command {
	
	private ApplicationModel model = null;
	
	public BuildingReportCommand(ApplicationModel model) {
		this.model = model;
	}

	@Override
	public void execute(String parameters) {
		String reportType = parameters;
		
		BuildingsReportGenerator reportGenerator = null;
		if (reportType.equals("indented")) {
			reportGenerator
				= new IndentedBuidingsReportGenerator(model.getBuildings());
		} else if (reportType.equals("dashed")) {
			reportGenerator
				= new DashedBuildingsReportGenerator(model.getBuildings());
		} else if (reportType.equals("tree")) {
			reportGenerator
				= new TreeBuildingsReportGenerator(model.getBuildings());
		}
		
		String report = reportGenerator.generate();
		
		System.out.println(report);	
	}

	@Override
	public String printHelp() {
		return "Prints buildings report. (params: reportType={dashed, indented, tree})";
	}

}
