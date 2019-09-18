package bnsit.patterns.laboratory;

import java.io.IOException;
import java.util.*;

import bnsit.patterns.laboratory.logic.*;
import bnsit.patterns.laboratory.logic.SaveCommand;
import bnsit.patterns.laboratory.model.ApplicationModel;
import bnsit.patterns.laboratory.model.Building;
import bnsit.patterns.laboratory.model.Command;
import bnsit.patterns.laboratory.model.DefaultExternal;

public class Application implements Exitable {

	private static final String HELLO_MESSAGE = "Welcome to Equipment Evidence System.";


	Map<String, Command> commands= new HashMap<String, Command>();

	public Application() {
		commands.put("save", new SaveCommand(model));
		commands.put("exit",new ExitCommand(this));
		commands.put("help",new HelpCommand());
		commands.put("external", new DefaultExternal());		//adapter
	}

	private boolean running = false;

	private ApplicationModel model = new ApplicationModel();

	private HelpSystemManager helpSystemManager = new HelpSystemManager();

	public void run() {
		running = true;

		Scanner scanner = new Scanner( System.in );

		System.out.println( HELLO_MESSAGE );

		while ( running ) {
			System.out.print( "ees> " );
			String userInput = scanner.nextLine();
			String [] commandAndParam=userInput.split(" ");
			String commandName = userInput.split( " " )[0];
			String param="";
			if(commandAndParam.length>1) {
				param = userInput.split(" ")[1];
				commands.get(param).printHelpMessage();

			}
			commands.get(commandName).execute(param);

		}
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

	private void printReport( String reportType ) {
		BuildingsReportGenerator reportGenerator = null;
		if ( reportType.equals( "indented" ) ) {
			reportGenerator = new IndentedBuidingsReportGenerator( model
					.getBuildings() );
		} else if ( reportType.equals( "dashed" ) ) {
			reportGenerator = new DashedBuildingsReportGenerator( model
					.getBuildings() );
		} else if ( reportType.equals( "tree" ) ) {
			reportGenerator = new TreeBuildingsReportGenerator( model
					.getBuildings() );
		}

		String report = reportGenerator.generate();

		System.out.println( report );
	}

	@Override
	public void stop() {
		running = false;
	}

	public static void main( String[] args ) {
		Application app = new Application();
		app.run();
	}
}