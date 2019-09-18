package bnsit.patterns.laboratory.logic;

import bnsit.patterns.laboratory.model.Command;

public class HelpCommand implements Command {



    @Override
    public void execute(String param) {

    }

    @Override
    public void printHelpMessage() {
        System.out.println( "Show commands help (params: [commandName])" );

    }
}