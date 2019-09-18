package bnsit.patterns.laboratory.commands;

import java.util.HashMap;
import java.util.Map;

public class HelpCommand implements Command {

	private Map<String, Command> commands = new HashMap<String, Command>();
	
	public HelpCommand(Map<String, Command> commands) {
		this.commands = commands;
	}

	@Override
	public void execute(String parameters) {
		if (parameters.equals("")) {
			for (String commandName : commands.keySet()) {
				Command command = commands.get(commandName);
				System.out.println(commandName + ": " + command.printHelp());
			}
		} else {
			String commandName = parameters;
			Command command = commands.get(commandName);
			if (command != null) {
				System.out.println(command.printHelp());
			} else {
				System.out.println("Command does not exist.");
			}
		}
	}

	@Override
	public String printHelp() {
		return "Show commands help (params: [commandName])";
	}
	
}
