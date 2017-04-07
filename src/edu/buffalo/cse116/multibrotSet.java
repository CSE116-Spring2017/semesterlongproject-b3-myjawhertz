package edu.buffalo.cse116;

public class multibrotSet {
	/**
	 * This class provides the translations and escape-time algorithms for the
	 * MultiBrot Set
	 * @author Alec Otminski 
	 */
	
	/**
	 * Translates x-coordinates from 0-512 ----> -1 to 1
	 * @param x original x-coordinate in 512 x 512 array
	 * @return new xCalc value for this set
	 */
	public double XCoordTranslation(int x){
//		System.out.println("Original x-value is:" + x);
		double xCalc = -1 + (2.0 * x / 512);
//		System.out.println("New x-value for " + x + " is: " + xCalc);
		return xCalc; 
	}
	/**
	 * Translates y-coordinates from 0-512 ----> -1.3 to 1.3 
	 * @param y original y-coordinate in 512 x 512 array
	 * @return new yCalc value for this set
	 */
	public double YCoordTranslation(int y){
//		System.out.println("Original y-value is: " + y);
		double yCalc = -1.3 + (2.6 * y / 512);
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
	 * @return A 2D Array of int containing the escape time of each pixel in the 512 x 512 array. 
	 */
	public int[][] return2DArray(){
		int[][] array = new int[512][512];
		for (int r = 0; r < 512; r++){		//for each row in the array
			for (int c = 0; c < 512; c++) {		//for each column in the array
				array[r][c] = mbSetETCalculation(XCoordTranslation(r),YCoordTranslation(c));
//				System.out.println(array[r][c]);	//this line is for debugging purposes
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
		int[][] array = new int[512][512];
		for (int r = 0; r < 512; r++){		//for each row in the array
			for (int c = 0; c < 512; c++) {		//for each column in the array
				array[r][c] = userInputPasses(XCoordTranslation(r),YCoordTranslation(c), a);
//				System.out.println(array[r][c]);	//this line is for debugging purposes
			}
		}
		return array;
	}
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

	public int[][] userInputEscapeTime(String i, String b) {
		int a = Integer.parseInt(i);
		int c = Integer.parseInt(b);
		int[][] array = new int[512][512];
		for (int x = 0; x < 512; x++) {
			for (int y = 0; y < 512; y++) {
				array[x][y] = multibrotRealPasses(XCoordTranslation(x), YCoordTranslation(y), a, c);
				// System.out.println(array[x][y]);
			}
		}
		return array;
	}
	
	public double getXCordRect(int xRow, int xStart, int xWidth) {
		double xCord = -1 + (2.0 * xStart / 512) + ((2.0 * xWidth / 512) * xRow / 512);
		return xCord;
	}
	
	public double getYCordRect(int yCol, int yStart, int yWidth) {
		double yCord = -1.3 + (2.6 * yStart / 512) +  ((2.6 * yWidth / 512) * yCol / 512);
		return yCord;
	}
	
	
	public int[][] rectangle(String i, String b, int e, int r, int er, int gg) {
		int a = Integer.parseInt(i);
		int c = Integer.parseInt(b);
		int[][] array = new int[512][512];
		for (int x = 0; x < 512; x++) {
			for (int y = 0; y < 512; y++) {
				array[x][y] = multibrotRealPasses(getXCordRect(x,e, er), getYCordRect(y, r, gg), a, c);
				// System.out.println(array[x][y]);
			} 
		} 
		return array;
	}

}