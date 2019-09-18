package bnsit.patterns.laboratory.commands;

import bnsit.patterns.laboratory.Application;

public class ExitCommand implements Command {

	private Application application = null;
	
	public ExitCommand(Application application) {
		this.application = application;
	}
	
	@Override
	public void execute(String parameters) {
		application.stop();
	}

	@Override
	public String printHelp() {
		return "Exits application";
	}

}
