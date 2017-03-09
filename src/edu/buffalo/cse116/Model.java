// I will make a change here.
// I will make another change.

package edu.buffalo.cse116;

import java.util.ArrayList;
import edu.buffalo.*;

public class Model implements Observable {
	
	private ArrayList<Observer> _observers;
	
	private int _buttonNumber;
	private int _borderThickness;
	
	public Model() {
		
		_observers = new ArrayList<Observer>();
		
		_buttonNumber = 0;
		_borderThickness = 2;
	
		
	}
	
	/* Notice that I didn't call this method "increaseButtonPressed()" or the like. The model should only be as concerned
	 * about the specific implementation of the UI as it has to be. */
	public void closeProgram() {
		System.exit(0);
		notifyObservers();
	}

	public void changeToJulia() {
		
		notifyObservers();
	}
	
	public int getNumber() {
		return _buttonNumber;
	}
	
	public int getBorderThickness() {
		return _borderThickness;
	}
	
	@Override
	public void notifyObservers() {
		for (Observer o : _observers) {
			o.update();
		}
	}

	@Override
	public void addObserver(Observer o) {
		_observers.add(o);
	}
}
