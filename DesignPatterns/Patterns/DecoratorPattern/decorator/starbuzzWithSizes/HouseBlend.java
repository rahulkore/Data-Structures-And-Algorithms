package DesignPatterns.Patterns.DecoratorPattern.decorator.starbuzzWithSizes;

public class HouseBlend extends Beverage {
	public HouseBlend() {
		description = "House Blend Coffee";
	}
 
	public double cost() {
		return .89;
	}
}

