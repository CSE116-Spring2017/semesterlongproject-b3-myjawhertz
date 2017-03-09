package edu.buffalo.cse116;

public interface Observable {
	
	public void notifyObservers();
	public void addObserver(Observer o);

}
