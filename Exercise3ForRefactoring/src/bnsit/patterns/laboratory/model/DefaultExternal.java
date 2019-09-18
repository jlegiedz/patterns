package bnsit.patterns.laboratory.model;

import bnsit.patterns.laboratory.logic.ExternalCommand;
import bnsit.patterns.laboratory.logic.ParamBean;

public class DefaultExternal implements Command {
    private ExternalCommand externalCommand;

    public DefaultExternal() {
        this.externalCommand = new ExternalCommand();
    }

    @Override
    public void execute(String param) {
        externalCommand.execute(new ParamBean(param));

    }

    @Override
    public void printHelpMessage() {
        externalCommand.getHelpMessage();
    }
}
