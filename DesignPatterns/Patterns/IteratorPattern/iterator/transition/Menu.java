package DesignPatterns.Patterns.IteratorPattern.iterator.transition;

import java.util.Iterator;

public interface Menu {
	public Iterator<?> createIterator();
}
