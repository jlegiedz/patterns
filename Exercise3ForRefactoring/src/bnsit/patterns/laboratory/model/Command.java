package bnsit.patterns.laboratory.model;

public interface Command {
    void execute(String param);
    void printHelpMessage();
}
