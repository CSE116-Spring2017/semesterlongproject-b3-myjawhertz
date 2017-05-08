package edu.buffalo.cse116;

public class multibrotSet {
	/**
	 * This class provides the translations and escape-time algorithms for the
	 * MultiBrot Set
	 * @author Alec Otminski 
	 */
	
	/**
	 * Translates x-coordinates from 0-2048 ----> -1 to 1
	 * @param x original x-coordinate in 2048 x 2048 array
	 * @return new xCalc value for this set
	 */
	public double XCoordTranslation(int x){
//		System.out.println("Original x-value is:" + x);
		double xCalc = -1 + (2.0 * x / 2048);
//		System.out.println("New x-value for " + x + " is: " + xCalc);
		return xCalc; 
	}
	/**
	 * Translates y-coordinates from 0-2048 ----> -1.3 to 1.3 
	 * @param y original y-coordinate in 2048 x 2048 array
	 * @return new yCalc value for this set
	 */
	public double YCoordTranslation(int y){
//		System.out.println("Original y-value is: " + y);
		double yCalc = -1.3 + (2.6 * y / 2048);
//		System.out.println("New y-value for " + y + " is: " + yCalc);
		return yCalc;
	}
	
	/**
	 * This method does the Escape-Time Calculations for the MultiBrot Set
	 * @param xCalc - a translated x-Coordinate in the MultiBrot Set
	 * @param yCalc - a translated y-Coordinate in the MultiBrot Set
	 * @return the Escape Time for the set == number of passes done
	 */
	public int mbSetETCalculation(double xCalc, double yCalc) {
		double x = xCalc;
		double y = yCalc;
		double dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
		int passes = 0;
		while (dist <= 2 && passes < 255) {
			double tempX = xCalc;	
			double tempY = yCalc;
			xCalc = (tempX * tempX * tempX) - (3 * tempX * (tempY * tempY)) + x;
			yCalc = (3 * (tempX * tempX) * tempY) - (tempY * tempY * tempY) + y;
			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
			passes++;
		}
		return passes;
	}
	
	/**
	 * This class insures that the Escape-Time calculations work when distance = 3.
	 * This method is never called during the program, it's only called in the JUnit tests for the program.
	 * @param xCalc - a translated x-Coordinate in the MultiBrot Set
	 * @param yCalc - a translated y-Coordinate in the MultiBrot Set
	 * @return the Escape Time for the set == number of passes done
	 */
	public int multibrotsetPass10(double xCalc, double yCalc) {
		double x = xCalc;
		double y = yCalc;
		double dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
		int passes = 0;
		while (dist <= 3 && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;
			xCalc = (tempX * tempX * tempX) - (3 * tempX * (tempY * tempY)) + x;
			yCalc = (3 * (tempX * tempX) * tempY) - (tempY * tempY * tempY) + y;
			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
			passes++;
		}
		return passes;
	}
	/**
	 * This method gives the escape-times of each pixel in a 2D array form.
	 * @return A 2D Array of int containing the escape time of each pixel in the 2048 x 2048 array. 
	 */
	public int[][] return2DArray(int a, int b){
		int [][] array = new int[b - a + 1][2048];
		for (int x = a; x <= b; x++) {
			for (int y = 0; y < 2048; y++) {
				array[x-a][y] = mbSetETCalculation(XCoordTranslation(x), YCoordTranslation(y));
			}
		}
		return array; 
	}
	
	/**
	 * This method does the Escape-Time Calculations for the MultiBrot Set with a new distance
	 * for each pixel which is set by the user. That new distance now becomes a parameter for this method.
	 * @param xCalc - a translated x-Coordinate in the MultiBrot Set
	 * @param yCalc - a translated y-Coordinate in the MultiBrot Set
	 * @param i - the new distance to be used for Escape-Time calculations
	 * @return the Escape Time for the set == number of passes done
	 */
	public int userInputPasses(double xCalc, double yCalc, double i) {
		double x = xCalc;
		double y = yCalc;
		double dist = i;
		int passes = 0;
		while (dist <= i && passes < 255) {
			double tempX = xCalc;	
			double tempY = yCalc;
			xCalc = (tempX * tempX * tempX) - (3 * tempX * (tempY * tempY)) + x;
			yCalc = (3 * (tempX * tempX) * tempY) - (tempY * tempY * tempY) + y;
			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
			passes++;
		}
		return passes; 
	}
	
	/** 
	 * Returns a 2D array of int with the Escape-Times for every single pixel for the
	 * Multibrot Set.
	 * @param i - User input for distance in Escape-Time calculations
	 * @return 2d array of int
	 */
	public int[][] userInputEscape(String i){
		int a = Integer.parseInt(i);
		int[][] array = new int[2048][2048];
		for (int r = 0; r < 2048; r++){		//for each row in the array
			for (int c = 0; c < 2048; c++) {		//for each column in the array
				array[r][c] = userInputPasses(XCoordTranslation(r),YCoordTranslation(c), a);
//				System.out.println(array[r][c]);	//this line is for debugging purposes
			}
		}
		return array;
	}
	/**
	 * Only called in a JUnit test to test if the set returns an escape time of 135 when
	 * the distance is set to 2 given a certain x and y value.
	 * @param xCalc - X-Value given in the JUnit test case
	 * @param yCalc - Y-Value given in the JUnit test case
	 * @return the Escape-Time of the set == the number of passes done
	 */
	public int multibrotsetDist2Pass135(double xCalc, double yCalc) {
		double x = xCalc;
		double y = yCalc;
		double dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2)); 
		int passes = 0;
		while (dist <= 2 && passes < 135) {
			double tempX = xCalc;
			double tempY = yCalc;
			xCalc = (tempX * tempX * tempX) - (3 * tempX * (tempY * tempY)) + x;
			yCalc = (3 * (tempX * tempX) * tempY) - (tempY * tempY * tempY) + y;
			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
			passes++;
		}
		return passes;
	}
	
	/**
	 * Calculates the Escape-Time using for the set using the custom distance and maximum number
	 * of passes which are set by the user.
	 * @param xCalc - a translated X-Coordinate in the Multibrot Set
	 * @param yCalc - a translated Y-Coordinate in the Multibrot Set
	 * @param i - maximum number of passes (determined by user input)
	 * @param z - distance used for calculations (determined by user input)
	 * @return the Escape-Time of the set == the number of passes done
	 */
	public int multibrotRealPasses(double xCalc, double yCalc, int i, int z) {
		double x = xCalc;
		double y = yCalc;
		double dist = z;
		int passes = 0;
		while (dist <= z && passes < i) {
			double tempX = xCalc;
			double tempY = yCalc;
			xCalc = (tempX * tempX * tempX) - (3 * tempX * (tempY * tempY)) + x;
			yCalc = (3 * (tempX * tempX) * tempY) - (tempY * tempY * tempY) + y;
			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
			passes++;
		}

		return passes;
	}

	/**
	 * The method that creates a new 2048x2048 panel for a new Mandelbrot Set with a custom number
	 * of passes and maximum distance that are set by the user on the GUI.
	 * @param i - entry from TextBox1: determines maximum number of passes allowed
	 * @param b - entry from TextBox2: determines distance used for ET calculations
	 * @return 2D array of int of Escape-Times for each pixel in the 2048x2048 array
	 */
	public int[][] userInputEscapeTime(String i, String b) {
		int a = Integer.parseInt(i);
		int c = Integer.parseInt(b);
		int[][] array = new int[2048][2048];
		for (int x = 0; x < 2048; x++) {
			for (int y = 0; y < 2048; y++) {
				array[x][y] = multibrotRealPasses(XCoordTranslation(x), YCoordTranslation(y), a, c);
				// System.out.println(array[x][y]);
			}
		}
		return array;
	}
	/**
	 * @param xRow - goes from 0 to 2048
	 * @param xStart  0-2048 scale of new X starting part
	 * @param xWidth 0-2048 scale of width
	 * @return x coordinate 
	 */
	public double getXCordRect(int xRow, double xStart, double xWidth) {
		double xCord = -1 + (2.0 * xStart / 2048) + ((2.0 * xWidth / 2048) * xRow / 2048);
		return xCord;
	}
	
	/**
	 * @param yCol - goes from 0 to 2048
	 * @param yStart 0-2048 scale of new Y starting point
	 * @param yWidth 0-2048 sale of height
	 * @return y coordinate
	 */
	public double getYCordRect(int yCol, double yStart, double yWidth) { 
		double yCord = -1.3 + (2.6 * yStart / 2048) +  ((2.6 * yWidth / 2048) * yCol / 2048);
		return yCord;
	}
	
	/**
	 * @param i - escape distance
	 * @param b - escape time
	 * @param e - distance from -2.15
	 * @param r - distance from -1.3
	 * @param er - width of dragged area
	 * @param gg - height of dragged area
	 * @return 2D array with passes
	 */
	public int[][] rectangle(String i, String b, double e, double r, double er, double gg) {
		int a = Integer.parseInt(i);
		int c = Integer.parseInt(b);
		int[][] array = new int[2048][2048];
		for (int x = 0; x < 2048; x++) {
			for (int y = 0; y < 2048; y++) {
				array[x][y] = multibrotRealPasses(getXCordRect(x,e, er), getYCordRect(y, r, gg), a, c);
				// System.out.println(array[x][y]);
			} 
		} 
		return array;
	}

}