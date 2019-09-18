package bnsit.patterns.laboratory.commands;


public interface Command {

	public void execute(String parameters);
	
	public String printHelp();
	
}
