package DesignPatterns.Patterns.DecoratorPattern.decorator.pizza;

public class ThickcrustPizza extends Pizza {
  
	public ThickcrustPizza() {
		description = "Thick crust pizza, with tomato sauce";
	}
  
	public double cost() {
		return 7.99;
	}
}

