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
}