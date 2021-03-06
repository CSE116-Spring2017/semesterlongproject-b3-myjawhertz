package edu.buffalo.cse116;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

import edu.buffalo.fractal.ComputePool;
import edu.buffalo.fractal.FractalPanel;
import edu.buffalo.fractal.WorkerResult;

/**
 *  This is the main class for the GUI for the fractal program. It implements
 * the  Observer class and holds the calls to add the fractal display, menu
 * bar  items, and the button & text box needed to change the distance used
 * for  Escape-Time calculations.  @author Alec Otminski  @author
 * Stephen Fung @author Ayesha Ismail  @author Junhong Jeong
 */
public class UI implements Observer {

	Model _model;

	// numbers for graphic
	int currentX, currentY, startX, startY, endX, endY = 0;
	boolean drag = false;

	// UI elements
	JFrame _window;
	JPanel _mainPanel;
	JPanel _2ndRowPanel;
	JPanel _3rdRowPanel;
	JPanel _4thRowPanel;
	JPanel _5thRowPanel;
	JPanel _spacer;
	JPanel _spacer2;
	JPanel _spacer3;
	Graphics gr;

	JTextField jt = new JTextField(30);
	JTextField et = new JTextField(30);
	JTextField textfieldforThread = new JTextField(30);
	double width1 = 2048;
	double height1 = 2048;
	double i = 0;
	int z = 0;
	int k = 0;
	int f = 0;
	int wo = -1;
	double widthHolder = 0;
	double width2 = 2048;
	double height2 = 2048;
	double newW = 0, newH = 0;
	double rectW = 2048;
	double rectH = 2048;
	private double newX, newY = 0;
	int beginX, beginY, width, height;
	
	JPanel _buttonGrid;
	private int[][] temp;
	private JButton enter = new JButton("Recaculate fractal with given escape distance");
	private JButton enterForTime = new JButton("Recaculate fractal with given escape time");
	private String textFromBox = "2";
	private String textFromBox2 = "255";
	private String textFromBox3 = "4";
	private int setTemp;

	private int count;

	// Class Object
	private FractalPanel fp;
	ComputePool cp;
	MandelbrotSet m;
	JuliaSet j;
	burningshipset b;
	multibrotSet multi;
	
	int workerNumber;

	// Menu Items
	private JMenuBar mb;
	private JMenu file;
	private JMenuItem ext;
	private JMenu color;
	private JMenuItem color1;
	private JMenuItem color2;
	private JMenuItem color3;
	private JMenuItem color4;
	private static JMenu fractal;
	private JMenuItem julia;
	private JMenuItem multibrot;
	private JMenuItem burningship;
	private JMenuItem madelbrot;
	private JButton reset;
	private JButton userInputForThreads;
	private JMenu Threads;
	private JMenuItem CalculatesThreads;
	private int thread2 = 4;
	private int tempCount = 1;
	
	/**
	 * Calls the methods to generate a new UI for the program when booting up
	 * 
	 * @param m
	 *            The model used for the UI that contains observers
	 *            for the button and menu bar items
	 */
	public UI(Model m) {

		/** Keep a permanent reference to the Model in order to notify it of user
		 input
		 */
		_model = m;

		/**
		 * The UI is taking care of itself here - it's making sure the model
		 * will know to call it when it's time for visual updates.
		 */
		_model.addObserver(this);

		// Perform some setup tasks that only need to be done once.
		initialize();

		// Bring the UI to a ready state.
		update();
	}

	/**
	 * Creates the JPanels, buttons, Menu Items, links to Fractal Sets, and
	 * JFrame needed for the program. This method is only to be called once
	 * during the start of the program.
	 */
	public void initialize() {

		_window = new JFrame("Super awesome project");

		// The main panel
		_mainPanel = new JPanel();

		/** The panel that contains the function to re-calculate the
		 fractal(Button) and input box */
		_5thRowPanel = new JPanel();

		_spacer = new JPanel();
		_spacer2 = new JPanel();
		_spacer3 = new JPanel();
		_5thRowPanel.setLayout(new GridLayout(10, 1));
		reset = new JButton("Recalculate and redisplay the fractal using the default coordinate range");
		userInputForThreads = new JButton("Number of threads");
		
		mb = new JMenuBar();
		_window.setJMenuBar(mb);

		file = new JMenu("File");
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
		
//		Threads = new JMenu("Threads");
//		mb.add(Threads);
		
//		CalculatesThreads = new JMenuItem("Calculates the number of Threads used");
//		Threads.add(CalculatesThreads);
		
		// The Panel that holds the image
		_buttonGrid = new JPanel();

		m = new MandelbrotSet();
		j = new JuliaSet();
		b = new burningshipset();
		multi = new multibrotSet();
		fp = new FractalPanel();
		

		HandlerClass handler = new HandlerClass();
		_buttonGrid.addMouseListener(handler);
		_buttonGrid.addMouseMotionListener(handler);

		_mainPanel.add(_buttonGrid);
		_mainPanel.add(_5thRowPanel);

		jt.setPreferredSize(new Dimension(1, 1));
		_5thRowPanel.add(jt);
		_5thRowPanel.add(enter);
		_5thRowPanel.add(_spacer);
		_5thRowPanel.add(et);
		_5thRowPanel.add(enterForTime);
		_5thRowPanel.add(_spacer2);
		_5thRowPanel.add(reset);
		_5thRowPanel.add(_spacer3);
		_5thRowPanel.add(textfieldforThread);
		_5thRowPanel.add(userInputForThreads);
		
		/*
		 * Here I'm using an anonymous inner class. Notice that I still have
		 * access to UI's instance variables. Doing this is much more convenient
		 * than creating a whole separate class and setting up an association
		 * relationship with UI.
		 */

		// Final steps to display the window
		_window.setContentPane(_mainPanel);
		_window.setVisible(true);
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cp = new ComputePool();
		cp.changePanel(fp);
		

	}

	/**
	 * Change information displayed on the UI based on what has changed in the
	 * Model.
	 */
	@Override
	public void update() {

		final MandelbrotSet mandelbrot = new MandelbrotSet();
		final JuliaSet juliaSet = new JuliaSet();
		final burningshipset burningShip = new burningshipset();
		final multibrotSet multibrotSet = new multibrotSet();
		fp.setPreferredSize(new Dimension(2048, 2048));
		fp.setSize(2048, 2048);
		fp.setMinimumSize(new Dimension(2048, 2048));
		fp.setMaximumSize(new Dimension(2048, 2048));
		System.out.println(fp.getSize());
		_buttonGrid.add(fp);
		
		

		madelbrot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				setTemp = 1;
//				tempCount = thread2;
				SwingWorker<WorkerResult, Void> workers[] = new createWorkers[thread2];
				for (workerNumber = 0; workerNumber < thread2; workerNumber++) {
					workers[workerNumber] =  new createWorkers(workerNumber);
					
				}
				cp.clearPool();
				cp.generateFractal(2048, workers);	
				
//				cp.clearPool();
			}
			
		});

		julia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				wo = -1;
				
				setTemp = 2;
//				tempCount = thread2;
				SwingWorker<WorkerResult, Void> workers[] = new createWorkers[thread2];
				for (workerNumber = 0; workerNumber < thread2; workerNumber++) {
					workers[workerNumber] =  new createWorkers(workerNumber);
				}
				cp.clearPool();

				cp.generateFractal(2048, workers);
				
			}
		});
		burningship.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				wo= -1;
				setTemp = 3;
//				tempCount = thread2;
				SwingWorker<WorkerResult, Void> workers[] = new createWorkers[thread2];
				for (workerNumber = 0; workerNumber < thread2; workerNumber++) {
					workers[workerNumber] =  new createWorkers(workerNumber);
				}
				cp.clearPool();
				cp.generateFractal(2048, workers);
				
			}
		});
		multibrot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				wo = -1;
				setTemp = 4;
//				tempCount = thread2;
				SwingWorker<WorkerResult, Void> workers[] = new createWorkers[thread2];
				for (workerNumber = 0; workerNumber < thread2; workerNumber++) {
					workers[workerNumber] =  new createWorkers(workerNumber);
				}
				cp.clearPool();
				cp.generateFractal(2048, workers);
			
			}
		});
		ext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		color1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fp.setIndexColorModel(ColorModel.createBluesColorModel(8));
				JOptionPane.getRootFrame();
				SwingWorker<WorkerResult, Void> workers[] = new createWorkers[thread2];
				for (workerNumber = 0; workerNumber < thread2; workerNumber++) {
					workers[workerNumber] =  new createWorkers(workerNumber);
					
				}
				cp.clearPool();
				cp.generateFractal(2048, workers);	
			}
		});
		color2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fp.setIndexColorModel(ColorModel.createGrayColorModel(8));
				JOptionPane.getRootFrame();
				SwingWorker<WorkerResult, Void> workers[] = new createWorkers[thread2];
				for (workerNumber = 0; workerNumber < thread2; workerNumber++) {
					workers[workerNumber] =  new createWorkers(workerNumber);
					
				}
				cp.clearPool();
				cp.generateFractal(2048, workers);	
			}
		});
		color3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fp.setIndexColorModel(ColorModel.createRainbowColorModel(8));
				JOptionPane.getRootFrame();
				SwingWorker<WorkerResult, Void> workers[] = new createWorkers[thread2];
				for (workerNumber = 0; workerNumber < thread2; workerNumber++) {
					workers[workerNumber] =  new createWorkers(workerNumber);
					
				}
				cp.clearPool();
				cp.generateFractal(2048, workers);	
			}
		});
		color4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fp.setIndexColorModel(ColorModel.createCrazyGoodColor(8));
				JOptionPane.getRootFrame();
				SwingWorker<WorkerResult, Void> workers[] = new createWorkers[thread2];
				for (workerNumber = 0; workerNumber < thread2; workerNumber++) {
					workers[workerNumber] =  new createWorkers(workerNumber);
					
				}
				cp.clearPool();
				cp.generateFractal(2048, workers);	
			}
		});
		
		
		
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFromBox = jt.getText();
				jt.setText("");

				if (ErrorBoxNotNumber(textFromBox) == true) {
					ErrorBox("Please insert numbers only!", "ErrorBox");

				} else {
					int a = Integer.parseInt(textFromBox);

					if ((isNumber(textFromBox) == true) && (a > 0)) { 
						
						if(setTemp == 1 || setTemp ==2 || setTemp == 3 || setTemp ==4){
							SwingWorker<WorkerResult, Void> workers[] = new createWorkers[thread2];
							for (workerNumber = 0; workerNumber < thread2; workerNumber++) {
								workers[workerNumber] =  new createWorkers(workerNumber);
							}
							cp.clearPool();
							cp.generateFractal(2048, workers);	
						}
						} else if ((isNumber(textFromBox) == false) || a < 0) {
							ErrorBox("Please enter positive number", "ErrorBox");
						

					}
				}
			}
		});

		enterForTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFromBox2 = et.getText();
				et.setText("");

				if (ErrorBoxNotNumber(textFromBox2) == true) {
					ErrorBox("Please insert numbers only!", "ErrorBox");

				} else {
					int a = Integer.parseInt(textFromBox2);

					if ((isNumber(textFromBox2) == true) && a >= 2 && a <= 255) {
						// if text in box is a valid number between 2 and 255
						
						if(setTemp == 1 || setTemp ==2 || setTemp == 3 || setTemp==4){
						SwingWorker<WorkerResult, Void> workers[] = new createWorkers[thread2];
						for (workerNumber = 0; workerNumber < thread2; workerNumber++) {
							workers[workerNumber] =  new createWorkers(workerNumber);
						}
						cp.clearPool();
						cp.generateFractal(2048, workers);	
						}
						
					} else if ((isNumber(textFromBox2) == false) || a < 2 || a > 255) {
						ErrorBox("Please enter numbers between 2 and 255", "ErrorBox");
					}
				}

			}
		});

		/**
		 * Adds function to reset to default fractal
		 */
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				i = 0;
				z = 0;
				k = 0;
				f = 0;
				width2 = 2048;
				height2 = 2048;
				newW = 0;
				newH = 0;
				newX = 0;
				
				newY = 0;

				rectW = 2048;
				rectH = 2048;
				
				
				SwingWorker<WorkerResult, Void> workers[] = new createWorkers[thread2];
				for (workerNumber = 0; workerNumber < thread2; workerNumber++) {
					workers[workerNumber] =  new createWorkers(workerNumber);
					
				}
				cp.clearPool();
				cp.generateFractal(2048, workers);	
			}
		});
		/**
		 * Gets the user input from text box
		 */
		userInputForThreads.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				textFromBox3 = textfieldforThread.getText();
				textfieldforThread.setText("");
				
				if (ErrorBoxNotNumber(textFromBox3) == true) {
					ErrorBox("Please insert numbers only!", "ErrorBox");

				} else {
					int numFromBox = Integer.parseInt(textFromBox3);	

					if ((isNumber(textFromBox3) == true) && numFromBox >= 1 && numFromBox <= 128) {
						// use #userInput of swingworker to do the background work
						
						thread2 = numFromBox;
					} else if ((isNumber(textFromBox3) == false) || numFromBox < 1 || numFromBox > 128) {
						ErrorBox("Please enter numbers between 1 and 128", "ErrorBox");
					}
				}
			}
			
		});
		// This is necessary to actually see the changes that have been made
		_window.pack();
	}
	
	
	/**
	 * Divides the work amongst workerResult 
	 * @return worker number it is on
	 */
//	public int workNum(){
//		wo+=1;
//		return wo;
//	}

	public void changed() {
	}

	/**
	 * checks if inputed input is a number
	 */

	public static boolean isNumber(final String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * error box if its the input is not a number
	 * 
	 * @param infoMessage
	 *            - message in error box
	 * @param titleBar
	 *            - title of error
	 */

	public static void ErrorBox(String infoMessage, String titleBar) {
		JOptionPane jop = new JOptionPane();
		fractal.add(jop);
		JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 *
	 * @param str-
	 *            user input string
	 * @return boolean value
	 */
	public boolean ErrorBoxNotNumber(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * handles rectangle drag / redrawing of the zoomed in area
	 */

	private class HandlerClass implements MouseListener, MouseMotionListener {

		public void paint(Graphics g) {

			gr = fp.getGraphics();
			Color myColor = new Color(55, 122, 125, 225);
			gr.setColor(myColor);
			_buttonGrid.paintComponents(_buttonGrid.getGraphics());
			if (drag == true) {
				beginX = Math.min(startX, currentX);
				beginY = Math.min(startY, currentY);
				width = Math.abs(currentX - startX);
				height = Math.abs(currentY - startY);
				gr.drawRect(beginX, beginY, width, height);
			}

		}

		@Override
		public void mouseDragged(MouseEvent e) {
			if (drag == true) {
				currentX = e.getX();
				currentY = e.getY();
				paint(fp.getGraphics());
				fp.invalidate();
				fp.validate();

			}

		}

		@Override
		public void mouseMoved(MouseEvent e) {
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			drag = true;
			startX = e.getX();
			startY = e.getY();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			endX = e.getX();
			endY = e.getY();
			widthHolder = width2;
			// starting x and y in rectangle
			if (i != 0) {
				newW = newW + (Math.min(startX, endX) * rectW / 2048);
				newH = newH + (Math.min(startY, endY) * rectH / 2048);
			}

			if (i == 0) {
				newW = Math.min(startX, endX);
				newH = Math.min(startY, endY);
				i++;
			}

			if (k != 0) {
				width2 = width2 - (width2 - width1);
				height2 = height2 - (height2 - height1);
			}

			if (k == 0) {
				width2 = 2048;
				height2 = 2048;
				k++;
			}

			if (f != 0) {
				width1 = (width2 * Math.abs(startX - endX) / 2048);
				height1 = (height2 * Math.abs(startY - endY) / 2048);
			}

			if (f == 0) {
				width1 = Math.abs(startX - endX);
				height1 = Math.abs(startY - endY);
				f++;
			}
			rectW = width1;
			rectH = height1;
			
			
			SwingWorker<WorkerResult, Void> workers[] = new createWorkers[thread2];
			for (workerNumber = 0; workerNumber < thread2; workerNumber++) {
				workers[workerNumber] =  new createWorkers(workerNumber);
			}
			cp.clearPool();
			cp.generateFractal(2048, workers);

		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
		
	}
	
	public class createWorkers extends SwingWorker<WorkerResult, Void> {
		int a ;
		
		public createWorkers(int workerNumber) {
			a = workerNumber;
		}

		@Override
		protected WorkerResult doInBackground() throws Exception {
//				int a = workNum();
				int start = (a* 2048) / thread2;
				System.out.println("start: " + start + "");
				int end = (((a  +1) * 2048 / thread2)) -1;
				System.out.println("end: " + end + "");
				WorkerResult wr = null;
				
				
				
				if (setTemp == 1) {
//					wr = new WorkerResult(start , m.returnArrayWithPasses(start ,end));
					wr = new WorkerResult(start, m.rectangle(textFromBox2, textFromBox, newW, newH, rectW, rectH, start, end));
//					System.out.println(newW);
//					System.out.println(newH);
//					System.out.println(rectW);
//					System.out.println(rectH);
				}
				if (setTemp == 2) {
					wr = new WorkerResult(start , j.rectangle(textFromBox2, textFromBox, newW, newH, rectW, rectH, start, end));
				}
				if (setTemp == 3) {
					wr = new WorkerResult(start , b.rectangle(textFromBox2, textFromBox, newW, newH, rectW, rectH, start, end));
				}
				if (setTemp == 4) {
					wr = new WorkerResult(start , multi.rectangle(textFromBox2, textFromBox, newW, newH, rectW, rectH, start, end));
				}			
//			System.err.println(start + " " + wr.getFractalStartRow() + " " + wr.getNumberRows());
			return wr;
		}
	}
}