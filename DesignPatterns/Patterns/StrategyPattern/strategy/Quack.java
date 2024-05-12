package DesignPatterns.Patterns.StrategyPattern.strategy;

public class Quack implements QuackBehavior {
	public void quack() {
		System.out.println("Quack");
	}
}
