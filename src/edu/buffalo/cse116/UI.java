package edu.buffalo.cse116;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.*;


import edu.buffalo.*;
import edu.buffalo.fractal.FractalPanel;

/**This is the main class for the GUI for the fractal program.
 * It implements the Observer class and holds the calls to add the fractal display, menu bar items, and the button &
 * text box needed to change the distance used for Escape-Time calculations.
 * 
 * @author Alec Otminski
 *
 */
public class UI implements Observer {
	
	Model _model;
	
	// UI elements
	JFrame _window;
	JPanel _mainPanel;
	JPanel _2ndRowPanel;
	JPanel _3rdRowPanel;
	JPanel _4thRowPanel;
	JPanel _5thRowPanel;
	JPanel _5thPart;
	
	JTextField jt = new JTextField(30);
	JTextField et = new JTextField(30);
	
	
	JPanel _buttonGrid;
	private int[][] temp;
	private JButton enter = new JButton("Recaculate fractal with given escape distance");
	private JButton enterForTime = new JButton("Recaculate fractal with given escape time");
	private String textFromBox = "2";
	private String textFromBox2 = "255";
	private int setTemp;
	
	// Class Object
	 FractalPanel fp;
	 MandelbrotSet m;
	 JuliaSet j;
	 burningshipset b;
	 multibrotSet multi;
	
	//Menu Items
	private JMenuBar mb;
	private JMenu file;
	private JMenuItem ext;
	private JMenu color;
	private JMenuItem  color1;
	private JMenuItem  color2;
	private JMenuItem  color3;
	private JMenuItem  color4;
	private JMenu fractal;
	private JMenuItem julia;
	private JMenuItem multibrot;
	private JMenuItem burningship;
	private JMenuItem madelbrot;
	
	
	/**
	 * Calls the methods to generate a new UI for the program when booting up.
	 * @param m The model used for the UI that contains observers for the button and menu bar items
	 */
	public UI(Model m) {
		
		// Keep a permanent reference to the Model in order to notify it of user input
		_model = m;
		
		/** The UI is taking care of itself here - it's making sure the model
		 * will know to call it when it's time for visual updates.
		 */
		_model.addObserver(this);
		
		// Perform some setup tasks that only need to be done once.
		initialize();
		
		// Bring the UI to a ready state.
		update();
	}
	/**
	 * Creates the JPanels, buttons, Menu Items, links to Fractal Sets, and JFrame needed for the program.
	 * This method is only to be called once during the start of the program.
	 */
	public void initialize() {
		 
		_window = new JFrame();
		
		// The main panel
		_mainPanel = new JPanel();
		_mainPanel.setLayout(new GridBagLayout());
 
		_3rdRowPanel = new JPanel();
		_3rdRowPanel.setLayout(new GridLayout(1,7));

		
		//The panel that contains the function to re-calculate the fractal(Button) and input box
		_5thRowPanel = new JPanel();
		_5thRowPanel.setLayout(new GridLayout(2,1));
		
		_5thPart = new JPanel();
		_5thRowPanel.setLayout(new GridLayout(7,1));
		_5thRowPanel.add(_5thPart);
		_5thRowPanel.add(et);
		_5thRowPanel.add(enterForTime);
		
		
		 mb = new JMenuBar();
		_window.setJMenuBar(mb);
		
		 file= new JMenu("File");
		 mb.add(file);
		 
		 ext = new JMenuItem("Exit");
		 file.add(ext);
		
		 fractal = new JMenu("Fractal");
		 mb.add(fractal);
		
	    
		color = new JMenu("Change color");
		mb.add(color);
		color1 = new JMenuItem("Blue");
		color.add(color1);
		color2 = new JMenuItem("Gray");
		color.add(color2);
		color3 = new JMenuItem("Rainbow");
		color.add(color3);
		color4 = new JMenuItem("Crazy good color");
		color.add(color4);
		
		 
		 madelbrot = new JMenuItem("Mandelbrot");
		 fractal.add(madelbrot);
		 
		 julia = new JMenuItem("Julia");
		 fractal.add(julia);
		 
		 burningship = new JMenuItem("Burningship");
		 fractal.add(burningship);
		 
		 multibrot = new JMenuItem("Multibrot");
		 fractal.add(multibrot);
		 
		 // The Panel that holds the image
		_buttonGrid = new JPanel();
		
		m = new MandelbrotSet();
		j = new JuliaSet();
		b = new burningshipset();
		multi = new multibrotSet();
		ColorModel cm = new ColorModel();
		 fp = new FractalPanel();
		
		int Mandel = 1;
		int Jul = 2;
		int Burn = 3;
		int Multi = 4;
		
		_mainPanel.add(_buttonGrid);
		_mainPanel.add(_5thRowPanel);

		jt.setPreferredSize(new Dimension(1,1));
		_5thRowPanel.add(jt);
		_5thRowPanel.add(enter);
		
		/* Here I'm using an anonymous inner class. Notice that I still have access to UI's instance variables. 
		 * Doing this is much more convenient than creating a whole separate class and setting up an association 
		 * relationship with UI. */
		
		// Final steps to display the window
		_window.setContentPane(_mainPanel);
		_window.setVisible(true);
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	
	/** 
	 * Change information displayed on the UI based on what has changed in the Model.
	 */
	@Override
	public void update() {
		
		final MandelbrotSet mandelbrot = new MandelbrotSet();
		final JuliaSet juliaSet = new JuliaSet();
		final burningshipset burningShip = new burningshipset();
		final multibrotSet multibrotSet = new multibrotSet();
		final ColorModel cm = new ColorModel();
		final FractalPanel fp = new FractalPanel();
		_buttonGrid.add(fp);
		fp.setOpaque(true);
		fp.setSize(512,512);
		
		madelbrot.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fp.updateImage(mandelbrot.returnArrayWithPasses());
				temp = mandelbrot.returnArrayWithPasses();
				JOptionPane.getRootFrame();
				fp.updateImage(m.userInputEscape(textFromBox));
				setTemp = 1;
				
			}
		});

		julia.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fp.updateImage(juliaSet.returnArrayWithPasses());
				temp = juliaSet.returnArrayWithPasses();
				JOptionPane.getRootFrame();
				fp.updateImage(j.userInputEscape(textFromBox));
				setTemp = 2;
			}
		});
		burningship.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fp.updateImage(burningShip.returnArrayWithPasses());
				temp = burningShip.returnArrayWithPasses();
				fp.updateImage(b.userInputEscape(textFromBox));
				JOptionPane.getRootFrame();
				setTemp = 3;
			}
		});
		multibrot.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fp.updateImage(multibrotSet.return2DArray());
				temp = multibrotSet.return2DArray();
				fp.updateImage(multi.userInputEscape(textFromBox));
				JOptionPane.getRootFrame();
				setTemp = 4;
			}
		});
		ext.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		color1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fp.setIndexColorModel(cm.createBluesColorModel(8));
				fp.updateImage(temp);
				JOptionPane.getRootFrame();
				if(setTemp == 1){
					fp.updateImage(m.userInputEscape(textFromBox));
				}
				if(setTemp == 2){
					fp.updateImage(j.userInputEscape(textFromBox));
				}
				if(setTemp == 3){
				fp.updateImage(b.userInputEscape(textFromBox));
				}
				if(setTemp == 4){
				fp.updateImage(multi.userInputEscape(textFromBox));
				}
			}
		});
		color2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fp.setIndexColorModel(cm.createGrayColorModel(8));
				fp.updateImage(temp);
				JOptionPane.getRootFrame();
				if(setTemp == 1){
					fp.updateImage(m.userInputEscape(textFromBox));
				}
				if(setTemp == 2){
					fp.updateImage(j.userInputEscape(textFromBox));
				}
				if(setTemp == 3){
				fp.updateImage(b.userInputEscape(textFromBox));
				}
				if(setTemp == 4){
				fp.updateImage(multi.userInputEscape(textFromBox));
				}
			}
		});
		color3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fp.setIndexColorModel(cm.createRainbowColorModel(8));
				fp.updateImage(temp);
				JOptionPane.getRootFrame();
				if(setTemp == 1){
					fp.updateImage(m.userInputEscape(textFromBox));
				}
				if(setTemp == 2){
					fp.updateImage(j.userInputEscape(textFromBox));
				}
				if(setTemp == 3){
				fp.updateImage(b.userInputEscape(textFromBox));
				}
				if(setTemp == 4){
				fp.updateImage(multi.userInputEscape(textFromBox));
				}
			}
		});
		color4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fp.setIndexColorModel(cm.createCrazyGoodColor(8));
				fp.updateImage(temp);
				JOptionPane.getRootFrame();
				if(setTemp == 1){
					fp.updateImage(m.userInputEscape(textFromBox));
				}
				if(setTemp == 2){
					fp.updateImage(j.userInputEscape(textFromBox));
				}
				if(setTemp == 3){
				fp.updateImage(b.userInputEscape(textFromBox));
				}
				if(setTemp == 4){
				fp.updateImage(multi.userInputEscape(textFromBox));
				}
			}
		});
		
		enter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				textFromBox = jt.getText();
				jt.setText("");
				int a = Integer.parseInt(textFromBox);
				if(a <= 0){
					System.err.println("Illegal entry");
				}

				if(a > 0){
				if(setTemp == 1){
					fp.updateImage(m.userInputEscape(textFromBox)); 
				}
				if(setTemp == 2){
					fp.updateImage(j.userInputEscape(textFromBox));
				}
				if(setTemp == 3){
				fp.updateImage(b.userInputEscape(textFromBox));
				}
				if(setTemp == 4){
				fp.updateImage(multi.userInputEscape(textFromBox));
				}
				}
			}
		}); 
		
		enterForTime.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				textFromBox = et.getText();
				et.setText("");
				int a = Integer.parseInt(textFromBox2);
				if(a <= 1){
					System.err.println("Illegal entry");
				}

				if(a > 1){
				if(setTemp == 1){
					fp.updateImage(m.userInputEscapeTime(textFromBox2));
				}
				if(setTemp == 2){
					fp.updateImage(j.userInputEscape(textFromBox2));
				}
				if(setTemp == 3){
				fp.updateImage(b.userInputEscape(textFromBox2));
				}
				if(setTemp == 4){
				fp.updateImage(multi.userInputEscape(textFromBox2));
				}
				}
			}
		}); 
		
		// This is necessary to actually see the changes that have been made
		_window.pack();
	}
}
