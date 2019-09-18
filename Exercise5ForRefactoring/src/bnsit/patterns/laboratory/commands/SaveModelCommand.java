package bnsit.patterns.laboratory.commands;

import java.io.IOException;

import bnsit.patterns.laboratory.model.ApplicationModel;

public class SaveModelCommand implements Command {
	
	private ApplicationModel model = null;
	
	public SaveModelCommand(ApplicationModel model) {
		this.model = model;
	}

	@Override
	public void execute(String parameters) {
		String filename = parameters;
		try {
			model.save(filename);
		} catch (IOException e) {
			System.out.println("Model saving failure.");
		}
	}

	@Override
	public String printHelp() {
		return "Saves data to file (params: filename)";
	}
	
}
