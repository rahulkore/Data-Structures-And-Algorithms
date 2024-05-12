package DesignPatterns.Patterns.ObserverPattern.observer.simple

import java.util.Observable;

public class SimpleSubject extends Observable {
	private int value = 0;
	
	public SimpleSubject() { }
	
	public void setValue(int value) {
		this.value = value;
		setChanged();
		notifyObservers(value);
	}
	
	public int getValue() {
		return this.value;
	}
}