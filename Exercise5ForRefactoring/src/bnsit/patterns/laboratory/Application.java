package bnsit.patterns.laboratory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import bnsit.patterns.laboratory.commands.AddBuildingCommand;
import bnsit.patterns.laboratory.commands.AddEquipmentCommand;
import bnsit.patterns.laboratory.commands.BuildingReportCommand;
import bnsit.patterns.laboratory.commands.Command;
import bnsit.patterns.laboratory.commands.ExitCommand;
import bnsit.patterns.laboratory.commands.HelloCommand;
import bnsit.patterns.laboratory.commands.HelpCommand;
import bnsit.patterns.laboratory.commands.LoadModelCommand;
import bnsit.patterns.laboratory.commands.SaveModelCommand;
import bnsit.patterns.laboratory.model.ApplicationModel;


public class Application {

	private boolean running = false;
	private Map<String,Command> commands = new HashMap<String,Command>();
	private ApplicationModel model = new ApplicationModel();
	
	private boolean logInvocation = true;

	private boolean logFished = true;

	private boolean logExecutionTime = true;

	private boolean logException = true;

	
	public void initialize() {
		commands.put("hello", new HelloCommand());
		commands.put("help", new HelpCommand(commands));
		commands.put("exit", new ExitCommand(this));
		commands.put("save", new SaveModelCommand(model));
		commands.put("load", new LoadModelCommand(model));
		commands.put("building_report", new BuildingReportCommand(model));
		commands.put("add_building", new AddBuildingCommand(model));
		commands.put("add_equipment", new AddEquipmentCommand(model));
	}
	
	public void run() {
		running = true;
		
		Scanner scanner = new Scanner(System.in);
		
		executeCommand( "hello", "" );
		
		while (running) {
			System.out.print("ees> ");
			String line = scanner.nextLine();
			
			String[] splittedLine = line.split(" ", 2);
			String commandName = splittedLine[0];
			String parameters = "";
			if (splittedLine.length == 2) parameters = splittedLine[1];
			
			executeCommand( commandName, parameters );
		}
	}

	public void stop() {
		running = false;
	}	
	
	public void executeCommand( String commandName, String parameters ) {

		Command command = commands.get( commandName );

		final boolean commandFound = ( command != null );
		if ( commandFound ) {
			if ( logInvocation ) {
				System.out.print( "Wykonanie komendy " + commandName );
			}

			final long timeBegin = System.currentTimeMillis();

			try {
				command.execute( parameters );
			} catch ( Throwable t ) {
				if ( logException ) {
					System.out.print( "Komenda " + commandName + " rzuciła wyjątek "
							+ t.getClass().getName() );
				}
				
				throw new RuntimeException( "Komenda " + commandName + " rzuciła wyjątek", t );
			}

			final long timeEnd = System.currentTimeMillis();

			if ( logFished ) {
				System.out.print( "Zakończenie komendy: " + commandName );
			}

			if ( logExecutionTime ) {
				System.out.print( "Czas wykonania komendy " + commandName + " = "
						+ ( timeEnd - timeBegin ) );
			}

		} else {
			throw new IllegalArgumentException( "Command '" + commandName
					+ "'does not exits." );
		}
	}
	
	public static void main(String[] args) {
		Application app = new Application();
		app.initialize();
		app.run();
	}
}
