package bnsit.patterns.laboratory.logic;

import bnsit.patterns.laboratory.model.ApplicationModel;
import bnsit.patterns.laboratory.model.Command;

import java.io.IOException;

public class SaveCommand implements Command {

    private ApplicationModel model;

    public SaveCommand(ApplicationModel model) {
        this.model = model;
    }


    @Override
    public void execute(String param) {
        try {
            model.save(param);
        } catch (IOException e) {
            throw new IllegalArgumentException("Problem when trying to save",e);
        }
    }

    @Override
    public void printHelpMessage() {
        System.out.println("Saves data to file (params: filename)");
    }
}