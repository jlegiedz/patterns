package bnsit.patterns.laboratory.commands;

public class HelloCommand implements Command {

	private static final String HELLO_MESSAGE = "Welcome to Equipment Evidence System.";

	@Override
	public void execute(String parameters) {
		System.out.println(HELLO_MESSAGE);
	}

	@Override
	public String printHelp() {
		return "Prints hello message.";
	}

}
