package edu.buffalo.cse116;

import java.awt.event.ActionEvent;
import edu.buffalo.*;
import java.awt.event.ActionListener;

public class NumberButtonHandler implements ActionListener {

	/* The ButtonHandler needs to have a association relationship with the Model so that it can notify the model
	 * when the button has been pressed. */
	Model _model;
	

	
	public NumberButtonHandler(Model m) {
		_model = m;

	}
	public void JuliaChanger(ActionEvent e){
	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_model.closeProgram();
	}	
}
