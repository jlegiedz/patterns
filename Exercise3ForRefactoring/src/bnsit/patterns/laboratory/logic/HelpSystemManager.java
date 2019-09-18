package bnsit.patterns.laboratory.logic;


public class HelpSystemManager {

	public void printHelp(String command) {
		if (command.equals("hello")) {
			printHelloHelp();
		} else if (command.equals("add_building")) {
			printAddBuildingHelp();
		} else if (command.equals("save")) {
			printSaveHelp();
		} else if (command.equals("load")) {
			printLoadHelp();
		} else if (command.equals("building_report")) {
			printBuildingReportHelp();
		} else if (command.equals("exit")) {
			printExitHelp();
		} else if (command.equals( "help" )) {
			printHelpHelp();
		}
	}

	public void printAllHelp() {
		printHelpHelp();
		printHelloHelp();
		printAddBuildingHelp();
		printSaveHelp();
		printLoadHelp();
		printBuildingReportHelp();
		printExitHelp();
	}
	
	private void printHelpHelp() {
		System.out.println( "Show commands help (params: [commandName])" );
	}

	private void printExitHelp() {
		System.out.println("Exits application");
	}

	private void printBuildingReportHelp() {
		System.out.println("Prints buildings report. (params: reportType={dashed, indented, tree})");
	}

	private void printLoadHelp() {
		System.out.println("Loads data from file (params: filename)");
	}

	private void printSaveHelp() {
		System.out.println("Saves data to file (params: filename)");
	}

	private void printAddBuildingHelp() {
		System.out.println("Starts building creator");
	}

	private void printHelloHelp() {
		System.out.println("Prints hello message.");
	}
	
}
