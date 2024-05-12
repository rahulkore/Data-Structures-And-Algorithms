package DesignPatterns.Patterns.IteratorPattern.iterator.implicit;

import java.util.Iterator;

public interface Menu {
	public Iterator<MenuItem> createIterator();
}
