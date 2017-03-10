package edu.buffalo.cse116;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


import edu.buffalo.*;
import edu.buffalo.fractal.FractalPanel;


public class UI implements Observer {
	
	Model _model;
	
	// UI elements
	JFrame _window;
	JPanel _mainPanel;
	JPanel _2ndRowPanel;
	JPanel _3rdRowPanel;
	JPanel _4thRowPanel;
	
	
	
	JPanel _buttonGrid;
	private int[][] temp;
	private JButton changeToMandelbrot;
	private JButton changeToJulia;
	private JButton changeToBurningShip;
	private JButton changetoMultibrot;
	private JButton close;
	private JButton _colorOne = new JButton("color 1");
	private JButton _colorTwo = new JButton("color 2");
	private JButton _colorThree = new JButton("color 3");
	private JButton _colorFour = new JButton("color 4");
	
	
	public UI(Model m) {
		
		// Keep a permanent reference to the Model in order to notify it of user input
		_model = m;
		
		/* The UI is taking care of itself here - it's making sure the model
		 * will know to call it when it's time for visual updates. */
		_model.addObserver(this);
		
		// Perform some setup tasks that only need to be done once.
		initialize();
		
		// Bring the UI to a ready state.
		update();
	}
	
	public void initialize() {
		
		_window = new JFrame();
		
		// Give the main panel two sections (two rows, one column)
		_mainPanel = new JPanel();
		_mainPanel.setLayout(new GridLayout(1, 3));
		_2ndRowPanel = new JPanel();
		_2ndRowPanel.setLayout(new GridLayout(4,1));
		_3rdRowPanel = new JPanel();
		_3rdRowPanel.setLayout(new GridLayout(1,7));
		_4thRowPanel = new JPanel();
		_4thRowPanel.setLayout(new GridLayout(4,1));
		
		
		
		// Set up the JPanel and GridLayout where the grid of buttons will go
		_buttonGrid = new JPanel();
		
		
		MandelbrotSet mandelbrot = new MandelbrotSet();
		JuliaSet juliaSet = new JuliaSet();
		burningshipset burningShip = new burningshipset();
		multibrotSet multibrotSet = new multibrotSet();
		ColorModel cm = new ColorModel();
		FractalPanel fp = new FractalPanel();
		
		
		_mainPanel.add(_buttonGrid);
		_mainPanel.add(_2ndRowPanel);
		
		_mainPanel.add(_4thRowPanel);
		_mainPanel.add(_3rdRowPanel);
		
		_4thRowPanel.add(_colorOne);
		_4thRowPanel.add(_colorTwo);
		_4thRowPanel.add(_colorThree);
		_4thRowPanel.add(_colorFour);
		
		close = new JButton("File - Close program");
//		close.addActionListener(new NumberButtonHandler(_model));
		
		_3rdRowPanel.add(close);
		
		
		changeToMandelbrot = new JButton("Change to Mandelbrot Set");
//		changetoMultibrot.addActionListener(new NumberButtonHandler(_model));
		_2ndRowPanel.add(changeToMandelbrot);
		
//		JButton changeToJulia = new JButton("Change to Jula Set");
//		changeToJulia.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e){
//				fp.updateImage(juliaSet.returnArrayWithPasses());
//				JOptionPane.getRootFrame();
//			}
//		});
		
		// jtext with scanner
		//changeToJulia.addActionListener(new NumberButtonHandler(_model));
		changeToJulia = new JButton("Change to Jula Set");
		_2ndRowPanel.add(changeToJulia);
				
		changeToBurningShip = new JButton("Change to Burningship Set");
//		changeToBurningShip.addActionListener(new NumberButtonHandler(_model));
		_2ndRowPanel.add(changeToBurningShip);
		
		 changetoMultibrot = new JButton("Change to Multibrot Set");
//		changetoMultibrot.addActionListener(new NumberButtonHandler(_model));
		_2ndRowPanel.add(changetoMultibrot);
		
		/* Here I'm using an anonymous inner class. Notice that I still have access to UI's instance variables. 
		 * Doing this is much more convenient than creating a whole separate class and setting up an association 
		 * relationship with UI. */
//		thickness.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				_model.increaseBorderThickness();
//			}
//		});
//		_mainPanel.add(thickness);
		
		// Final steps to display the window
		_window.setContentPane(_mainPanel);
		_window.setVisible(true);
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
	}

	
	/** Change information displayed on the UI based on what has changed in the Model.*/
	@Override
	public void update() {
		
//		// Update the button grid
//		_buttonGrid.removeAll();
//		
//		int num = _model.getNumber();
//		for (int i = 0; i < ROWS * COLUMNS; i++) {
//			JButton b = new JButton();
//			b.setText("" + num);
//			int t = _model.getBorderThickness();
//			b.setBorder(BorderFactory.createMatteBorder(t, t, t, t, Color.BLUE));
//			b.setPreferredSize(new Dimension((int) (BUTTON_SIZE * 1.6), BUTTON_SIZE));
//			
//			_buttonGrid.add(b);
//			
//			b.setOpaque(true);	// this is necessary to back the background color visible
//			if (num % 3 == 0) { // if the button's number is divisible by three, make it red
//				b.setBackground(Color.RED);
//			} else {
//				b.setBackground(Color.GREEN);
//			}
//			
//			num++;
//		}
		
		
		MandelbrotSet mandelbrot = new MandelbrotSet();
		JuliaSet juliaSet = new JuliaSet();
		burningshipset burningShip = new burningshipset();
		multibrotSet multibrotSet = new multibrotSet();
		ColorModel cm = new ColorModel();
		FractalPanel fp = new FractalPanel();
		_buttonGrid.add(fp);
		fp.setOpaque(true);
		fp.setSize(512,512);
//		fp.setIndexColorModel(cm.createBluesColorModel(8));
//		fp.updateImage(mandelbrot.returnArrayWithPasses());
//		fp.updateImage(juliaSet.returnArrayWithPasses());
//		fp.updateImage(burningShip.returnArrayWithPasses());
//		fp.updateImage(multibrotSet.return2DArray());
		
		
	
		changeToMandelbrot.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fp.updateImage(mandelbrot.returnArrayWithPasses());
				temp = mandelbrot.returnArrayWithPasses();
				JOptionPane.getRootFrame();
			}
		});
		changeToJulia.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fp.updateImage(juliaSet.returnArrayWithPasses());
				temp = juliaSet.returnArrayWithPasses();
				JOptionPane.getRootFrame();
			}
		});
		changeToBurningShip.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fp.updateImage(burningShip.returnArrayWithPasses());
				temp = burningShip.returnArrayWithPasses();
				JOptionPane.getRootFrame();
			}
		});
		changetoMultibrot.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fp.updateImage(multibrotSet.return2DArray());
				temp = multibrotSet.return2DArray();
				JOptionPane.getRootFrame();
			}
		});
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		_colorOne.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fp.setIndexColorModel(cm.createBluesColorModel(8));
				fp.updateImage(temp);
				JOptionPane.getRootFrame();
			}
		});
		_colorTwo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fp.setIndexColorModel(cm.createGrayColorModel(8));
				fp.updateImage(temp);
				JOptionPane.getRootFrame();
			}
		});
		_colorThree.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fp.setIndexColorModel(cm.createRainbowColorModel(8));
				fp.updateImage(temp);
				JOptionPane.getRootFrame();
			}
		});
		_colorFour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fp.setIndexColorModel(cm.createBluesColorModel(8));
				fp.updateImage(temp);
				JOptionPane.getRootFrame();
			}
		});
		

		
		// This is necessary to actually see the changes that have been made
		_window.pack();
	}
}
