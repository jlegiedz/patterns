package bnsit.patterns.laboratory.commands;

import java.io.IOException;

import bnsit.patterns.laboratory.model.ApplicationModel;

public class LoadModelCommand implements Command {
	
	private ApplicationModel model = null;
	
	public LoadModelCommand(ApplicationModel model) {
		this.model = model;
	}

	@Override
	public void execute(String parameters) {
		String filename = parameters;
		try {
			model.load(filename);
		} catch (IOException e) {
			System.out.println("Model saving failure.");
		}
	}

	@Override
	public String printHelp() {
		return "Loads data from file (params: filename)";
	}

}
