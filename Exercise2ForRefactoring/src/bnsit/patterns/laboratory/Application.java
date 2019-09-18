
package bnsit.patterns.laboratory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bnsit.patterns.laboratory.logic.BuildingBuilder;
import bnsit.patterns.laboratory.logic.ReportCatalog;
import bnsit.patterns.laboratory.model.ApplicationModel;
import bnsit.patterns.laboratory.model.Building;

public class Application {

	private static final String HELLO_MESSAGE = "Welcome to Equipment Evidence System.";

	private boolean running = false;

	private ApplicationModel model = new ApplicationModel();

	public void run() {
		running = true;

		Scanner scanner = new Scanner( System.in );

		System.out.println( HELLO_MESSAGE );

		while ( running ) {
			System.out.print( "ees> " );
			String command = scanner.nextLine();

			if ( command.equals( "hello" ) ) {
				System.out.println( HELLO_MESSAGE );
			} else if ( command.equals( "add_building" ) ) {
				addBuilding( scanner );
			} else if ( command.startsWith( "save" ) ) {
				String filename = command.split( " " )[1];
				try {
					model.save( filename );
				} catch ( IOException e ) {
					System.out.println( "Model saving failure." );
				}
			} else if ( command.startsWith( "load" ) ) {
				String filename = command.split( " " )[1];
				try {
					model.load( filename );
				} catch ( IOException e ) {
					System.out.println( "Model loading failure." );
				}
			} else if ( command.startsWith( "building_report" ) ) {
				String reportType = command.split( " " )[1];

				switch ( convert( reportType ) ) {
				case 1 :
					System.out.println( ReportCatalog.dashedReport( model ) );
					break;
				case 2 :
					System.out.println( ReportCatalog.indentedReport( model ) );
					break;
				case 3 :
					System.out.println( ReportCatalog.treeReport( model ) );
					break;
				case -1 : // TODO: obsluzyc blad!!!
				}

			} else if ( command.equals( "exit" ) ) {
				running = false;
			}
		}
	}

	private int convert( String str ) {
		if ( "dashed".equals( str ) )
			return 1;
		if ( "indented".equals( str ) )
			return 2;
		if ( "tree".equals( str ) )
			return 3;

		return -1;
	}

	private void addBuilding( Scanner scanner ) {
		BuildingBuilder buildingBuilder = new BuildingBuilder();

		System.out.print( "Name: " );
		String name = scanner.nextLine();

		System.out.print( "Address: " );
		String address = scanner.nextLine();

		buildingBuilder.buildBuilding( name, address );

		System.out.print( "Elevations range: " );
		int firstElevation = scanner.nextInt();
		int lastElevation = scanner.nextInt();
		scanner.nextLine();

		buildingBuilder.addElevations( firstElevation, lastElevation );

		for ( int i = firstElevation; i <= lastElevation; ++i ) {
			System.out
					.print( "Enter number of rooms for elevation " + i + ": " );
			int numberOfRooms = scanner.nextInt();
			scanner.nextLine();

			List<Integer> roomNumbers = new ArrayList<Integer>();
			System.out.println( "Enter room numbers for elevation " + i + ": " );
			for ( int j = 0; j < numberOfRooms; ++j ) {
				roomNumbers.add( scanner.nextInt() );
			}
			scanner.nextLine();

			buildingBuilder.addRooms( i, roomNumbers );
		}

		Building building = buildingBuilder.getBuilding();
		model.addBuilding( building );

	}

	public void stop() {
		running = false;
	}

	public static void main( String[] args ) {
		Application app = new Application();
		app.run();
	}
}
