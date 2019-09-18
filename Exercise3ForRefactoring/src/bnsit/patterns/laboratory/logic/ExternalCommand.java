
package bnsit.patterns.laboratory.logic;

public class ExternalCommand {

    public void execute(ParamBean param) {
        System.out.println("FooBar");
    }

    public String getHelpMessage() {
        return("External command");
    }
}