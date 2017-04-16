package edu.buffalo.cse116;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

import edu.buffalo.fractal.FractalPanel;

/**
 *  * This is the main class for the GUI for the fractal program. It implements
 * the  * Observer class and holds the calls to add the fractal display, menu
 * bar  * items, and the button & text box needed to change the distance used
 * for  * Escape-Time calculations.  *   * @author Alec Otminski  * @author
 * Stephen Fung  * @author Ayesha Ismail  * @author Junhong Jeong  *  
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
	Graphics gr;

	JTextField jt = new JTextField(30);
	JTextField et = new JTextField(30);
	double width1 = 512;
	double height1 = 512;
	double i = 0;
	int z = 0;
	int k = 0;
	int f = 0;
	double widthHolder = 0;
	double width2 = 512;
	double height2 = 512;
	double newW = 512, newH = 512;
	private double newX, newY = 0;
	int beginX, beginY, width, height;
	double rectW = 0;
	double rectH = 0;
	JPanel _buttonGrid;
	private int[][] temp;
	private JButton enter = new JButton("Recaculate fractal with given escape distance");
	private JButton enterForTime = new JButton("Recaculate fractal with given escape time");
	private String textFromBox = "2";
	private String textFromBox2 = "255";
	private int setTemp;

	private int count;

	// Class Object
	private FractalPanel fp;
	MandelbrotSet m;
	JuliaSet j;
	burningshipset b;
	multibrotSet multi;

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

	/**
	 * Calls the methods to generate a new UI for the program when booting up.  
	 * 
	 * @param m
	 *                        The model used for the UI that contains observers
	 *            for the             button and menu bar items
	 */
	public UI(Model m) {

		// Keep a permanent reference to the Model in order to notify it of user
		// input
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
		// _mainPanel.setLayout(new GridBagLayout());

		// _3rdRowPanel = new JPanel();
		// _3rdRowPanel.setLayout(new GridLayout(1, 7));

		// The panel that contains the function to re-calculate the
		// fractal(Button) and input box
		_5thRowPanel = new JPanel();
		// _5thRowPanel.setLayout(new GridLayout(2, 1));

		_spacer = new JPanel();
		_spacer2 = new JPanel();
		_5thRowPanel.setLayout(new GridLayout(7, 1));
		reset = new JButton("Recalculate and redisplay the fractal using the default coordinate range");

		mb = new JMenuBar();
		_window.setJMenuBar(mb);

		file = new JMenu("File");
		mb.add(file);

		ext = new JMenuItem("Exit");
		file.add(ext);

		fractal = new JMenu("Fractal");
		mb.add(fractal);

		// _window.getContentPane().addMouseListener(new MouseListener());

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

	}
	// public void addLayer(){
	//
	// JPanel window = new JPanel();
	// window.setOpaque(true);
	// rectangle = new JLayeredPane();
	// rectangle.add(_buttonGrid, Integer.valueOf(1));
	// rectangle.add(window, Integer.valueOf(2));
	// }

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
		_buttonGrid.add(fp);
		fp.setOpaque(true);
		fp.setSize(512, 512);

		madelbrot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fp.updateImage(mandelbrot.returnArrayWithPasses());
				temp = mandelbrot.returnArrayWithPasses();
				JOptionPane.getRootFrame();
				fp.updateImage(mandelbrot.userInputEscapeTime(textFromBox2, textFromBox));
				setTemp = 1;

			}
		});

		julia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fp.updateImage(juliaSet.returnArrayWithPasses());
				temp = juliaSet.returnArrayWithPasses();
				JOptionPane.getRootFrame();
				fp.updateImage(j.userInputEscapeTime(textFromBox2, textFromBox));
				setTemp = 2;
			}
		});
		burningship.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fp.updateImage(burningShip.returnArrayWithPasses());
				temp = burningShip.returnArrayWithPasses();
				fp.updateImage(b.userInputEscapeTime(textFromBox2, textFromBox));
				JOptionPane.getRootFrame();
				setTemp = 3;
			}
		});
		multibrot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fp.updateImage(multibrotSet.return2DArray());
				temp = multibrotSet.return2DArray();
				fp.updateImage(multi.userInputEscapeTime(textFromBox2, textFromBox));
				JOptionPane.getRootFrame();
				setTemp = 4;
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
				fp.updateImage(temp);
				JOptionPane.getRootFrame();
				if (setTemp == 1) {
					fp.updateImage(m.userInputEscapeTime(textFromBox2, textFromBox));
				}
				if (setTemp == 2) {
					fp.updateImage(j.userInputEscapeTime(textFromBox2, textFromBox));
				}
				if (setTemp == 3) {
					fp.updateImage(b.userInputEscapeTime(textFromBox2, textFromBox));
				}
				if (setTemp == 4) {
					fp.updateImage(multi.userInputEscapeTime(textFromBox2, textFromBox));
				}
			}
		});
		color2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fp.setIndexColorModel(ColorModel.createGrayColorModel(8));
				fp.updateImage(temp);
				JOptionPane.getRootFrame();
				if (setTemp == 1) {
					fp.updateImage(m.userInputEscapeTime(textFromBox2, textFromBox));
				}
				if (setTemp == 2) {
					fp.updateImage(j.userInputEscapeTime(textFromBox2, textFromBox));
				}
				if (setTemp == 3) {
					fp.updateImage(b.userInputEscapeTime(textFromBox2, textFromBox));
				}
				if (setTemp == 4) {
					fp.updateImage(multi.userInputEscapeTime(textFromBox2, textFromBox));
				}
			}
		});
		color3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fp.setIndexColorModel(ColorModel.createRainbowColorModel(8));
				fp.updateImage(temp);
				JOptionPane.getRootFrame();
				if (setTemp == 1) {
					fp.updateImage(m.userInputEscapeTime(textFromBox2, textFromBox));
				}
				if (setTemp == 2) {
					fp.updateImage(j.userInputEscapeTime(textFromBox2, textFromBox));
				}
				if (setTemp == 3) {
					fp.updateImage(b.userInputEscapeTime(textFromBox2, textFromBox));
				}
				if (setTemp == 4) {
					fp.updateImage(multi.userInputEscapeTime(textFromBox2, textFromBox));
				}
			}
		});
		color4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fp.setIndexColorModel(ColorModel.createCrazyGoodColor(8));
				fp.updateImage(temp);
				JOptionPane.getRootFrame();
				if (setTemp == 1) {
					fp.updateImage(m.userInputEscapeTime(textFromBox2, textFromBox));
				}
				if (setTemp == 2) {
					fp.updateImage(j.userInputEscapeTime(textFromBox2, textFromBox));
				}
				if (setTemp == 3) {
					fp.updateImage(b.userInputEscapeTime(textFromBox2, textFromBox));
				}
				if (setTemp == 4) {
					fp.updateImage(multi.userInputEscapeTime(textFromBox2, textFromBox));
				}
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

					if ((isNumber(textFromBox) == true) && (a > 0)) { // if text
																		// in
																		// box
																		// is a
																		// valid
																		// positive
																		// number
						if (setTemp == 1) {
							fp.updateImage(m.userInputEscapeTime(textFromBox2, textFromBox));
						}
						if (setTemp == 2) {
							fp.updateImage(j.userInputEscapeTime(textFromBox2, textFromBox));
						}
						if (setTemp == 3) {
							fp.updateImage(b.userInputEscapeTime(textFromBox2, textFromBox));
						}
						if (setTemp == 4) {
							fp.updateImage(multi.userInputEscapeTime(textFromBox2, textFromBox));
						} else if ((isNumber(textFromBox) == false) || a < 0) {
							ErrorBox("Please enter positive number", "ErrorBox");
						}

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
						if (setTemp == 1) {
							fp.updateImage(m.userInputEscapeTime(textFromBox2, textFromBox));
						}
						if (setTemp == 2) {
							fp.updateImage(j.userInputEscapeTime(textFromBox2, textFromBox));
						}
						if (setTemp == 3) {
							fp.updateImage(b.userInputEscapeTime(textFromBox2, textFromBox));
						}
						if (setTemp == 4) {
							fp.updateImage(multi.userInputEscapeTime(textFromBox2, textFromBox));
						}
					} else if ((isNumber(textFromBox2) == false) || a < 2 || a > 255) {
						ErrorBox("Please enter numbers between 2 and 255", "ErrorBox");
					}
				}

			}
		});

		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				i = 0;
				z = 0;
				k = 0;
				f = 0;
				width2 = 512;
				height2 = 512;
				newW = 512;
				newH = 512;
				newX = 0;
				newY = 0;

				rectW = 0;
				rectH = 0;
				// if text in box is a valid number between 2 and 255
				if (setTemp == 1) {
					fp.updateImage(m.userInputEscapeTime(textFromBox2, textFromBox));
				}
				if (setTemp == 2) {
					fp.updateImage(j.userInputEscapeTime(textFromBox2, textFromBox));
				}
				if (setTemp == 3) {
					fp.updateImage(b.userInputEscapeTime(textFromBox2, textFromBox));
				}
				if (setTemp == 4) {
					fp.updateImage(multi.userInputEscapeTime(textFromBox2, textFromBox));
				}
			}
		});

		// _buttonGrid.addMouseListener(new MouseListener(){
		// public void mouseDragged(MouseEvent m){
		// System.out.println(m.getX());
		// System.out.println(m.getY());
		// }
		// });

		// This is necessary to actually see the changes that have been made
		_window.pack();
	}

	public void changed() {

	}

	public static boolean isNumber(final String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static void ErrorBox(String infoMessage, String titleBar) {
		JOptionPane jop = new JOptionPane();
		fractal.add(jop);
		JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	public boolean ErrorBoxNotNumber(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!Character.isDigit(c)) {
				return true;
			}
		}
		return false;

	}

	private class HandlerClass extends JFrame implements MouseListener, MouseMotionListener {

		public void paint(Graphics g) {

			// gr = _buttonGrid.getGraphics();
			gr = fp.getGraphics();
			Color myColor = new Color(55, 122, 125, 225);
			gr.setColor(myColor);

//			fp.paintComponents(g);
			_buttonGrid.paintComponents(_buttonGrid.getGraphics());
			
			if (drag == true) {
				beginX = Math.min(startX, currentX);
				beginY = Math.min(startY, currentY);
				width = Math.abs(currentX - startX);
				height = Math.abs(currentY - startY);

				gr.drawRect(beginX, beginY, width, height);
				// gr.fillRect(beginX, beginY, width, height);

//				g.drawLine(0, 0, 0, 0);
				
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

			// if(drag == true){
			// beginX = Math.min(startX, currentX);
			// beginY = Math.min(startY, currentY);
			// width = Math.abs(currentX - startX);
			// height = Math.abs(currentY - startY);
			//
			// gr.drawRect(beginX, beginY, width, height);
			//
			// }

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
				newW = newW + (Math.min(startX, endX) * rectW / 512);
				// System.out.println(rectW);

				newH = newH + (Math.min(startY, endY) * rectH / 512);
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
				width2 = 512;
				height2 = 512;
				k++;
			}

			if (f != 0) {
				width1 = (width2 * Math.abs(startX - endX) / 512);
				height1 = (height2 * Math.abs(startY - endY) / 512);
				// System.out.println("part w is : " + width1);
				// System.out.println("part h is : " + height1);
			}
			// if(f!= 0){
			// width1 = width1 + (width2 - width1);
			// height1 = height1 + (height2 - height1);
			// System.out.println("part is : " + width1);
			// }

			if (f == 0) {
				width1 = Math.abs(startX - endX);
				height1 = Math.abs(startY - endY);
				// System.out.println("part is : " + width1);
				f++;
			}

			// System.out.println("whole is : " + width2);

			// if(z != 0){
			rectW = width1;
			rectH = height1;
			// System.out.println(rectW);

			// System.out.println(width1);
			////
			// System.out.println("part is : " + width1);
			// System.out.println("whole is : " + width2);
			// }
			// if(z == 0){
			// rectW = Math.abs(startX - endX);
			// rectH = Math.abs(startY - endY);
			//// System.out.println(rectW);
			//// System.out.println("part is : " + width1);
			//// System.out.println("whole is : " + width2);
			// z++;
			// }

			if (setTemp == 1) {
				// System.out.println("SDFfgsdgSD");
				fp.updateImage(m.rectangle(textFromBox2, textFromBox, newW, newH, rectW, rectH));
				// System.out.println(rectW);
			}
			if (setTemp == 2) {
				fp.updateImage(j.rectangle(textFromBox2, textFromBox, newW, newH, rectW, rectH));
			}
			if (setTemp == 3) {
				fp.updateImage(b.rectangle(textFromBox2, textFromBox, newW, newH, rectW, rectH));
			}
			if (setTemp == 4) {
				fp.updateImage(multi.rectangle(textFromBox2, textFromBox, newW, newH, rectW, rectH));
			}

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

	}

}
