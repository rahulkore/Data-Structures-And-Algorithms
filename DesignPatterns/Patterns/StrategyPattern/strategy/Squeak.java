package DesignPatterns.Patterns.StrategyPattern.strategy;

public class Squeak implements QuackBehavior {
	public void quack() {
		System.out.println("Squeak");
	}
}
