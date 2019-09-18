
package bnsit.patterns.laboratory.logic;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import bnsit.patterns.laboratory.model.ApplicationModel;
import bnsit.patterns.laboratory.model.Building;
import bnsit.patterns.laboratory.model.Elevation;
import bnsit.patterns.laboratory.model.Room;

public class ReportCatalog {

	public static String dashedReport( ApplicationModel model ) {
		String report = "";

		report += dashedHeader(model.getBuildings().size());

		for ( Building building : model.getBuildings() ) {
			report += body( building.getName() + " ("
					+ building.getAddress() + ")", "--", 0 );
			for ( Elevation elevation : building.getElevations() ) {
				report += body( "Elevation " + elevation.getNumber(), "--", 1 );
				for ( Room room : elevation.getRooms() ) {
					report += body( "Room " + room.getNumber(), "--", 2 );
				}
			}
		}

		report += dashedFooter();

		return report;
	}

	private static String dashedFooter() {
	    String footer = "------------------------------------------------------\n";
	    footer       += "------------------------------------------------------\n";
		return footer;
	}

	private static String body( String entry, String separator, int indentationLevel ) {
		String indentation = "";

		for ( int i = 0; i < indentationLevel; ++i ) {
			indentation += separator;
		}

		return ( indentation + entry + "\n" );
	}

	private static String dashedHeader(int buildingsSize) {
		String header = "------------------------------------------------------\n";
		header +=       "                  Building report                     \n";
		header +=       "------------------------------------------------------\n";
		header +=       "Total buildings: " + buildingsSize + "\n";
		header +=       "------------------------------------------------------\n";
		return header;
	}

	public static String treeReport( ApplicationModel model ) {
		String report = "";

		report += treeHeader();

		for ( Building building : model.getBuildings() ) {
			report += body( building.getName() + " ("
					+ building.getAddress() + ")", "|-", 0 );
			for ( Elevation elevation : building.getElevations() ) {
				report += body( "Elevation " + elevation.getNumber(), "|-", 1 );
				for ( Room room : elevation.getRooms() ) {
					report += body( "Room " + room.getNumber(), "|-", 2 );
				}
			}
		}

		report += treeFooter();

		return report;
	}
	
	private static String treeHeader() {
		String header = "******************************************************\n";
		header       += "                   Building report                    \n";
		header       += "******************************************************\n";
		return header;
	}

	private static String treeFooter() {
		String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
	    String date = sdf.format(cal.getTime());
		
	    String footer = "****************" + date + "*******************\n";
		return footer;
	}

	public static String indentedReport( ApplicationModel model ) {
		return "I'm intended";
	}
}
