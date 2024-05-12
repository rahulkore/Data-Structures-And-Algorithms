package DesignPatterns.Patterns.CommandPattern.command.undo;

public interface Command {
	public void execute();
	public void undo();
}
