package bnsit.patterns.laboratory.logic;

import bnsit.patterns.laboratory.model.Command;

public class ExitCommand implements Command {

    private Exitable application;

    public ExitCommand(Exitable application) {
        this.application = application;
    }

    @Override
    public void execute(String param) {
        System.out.println("Exiting app");
        application.stop();
    }

    @Override
    public void printHelpMessage() {
        System.out.println("Exits application");
    }
}
