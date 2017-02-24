package edu.buffalo.cse116;

public class multibrotSet {
	/**
	 * This class provides the translations and escape-time algorithms for the
	 * MultiBrot Set
	 * @author Alec Otminski
	 */
	
	private int[][] array = new int[512][512];
	/**
	 * Translates x-coordinates from 0-512 ----> -1 to 1
	 * @param x original x-coordinate in 512 x 512 array
	 * @return new xCalc value for this set
	 */
	public double XCoordTranslation(int x){
		double xCalc = -1 + ((2 * x) / 512);
		return xCalc;
	}
	/**
	 * Translates y-coordinates from 0-512 ----> -1.3 to 1.3 
	 * @param y original y-coordinate in 512 x 512 array
	 * @return new yCalc value for this set
	 */
	public double YCoordTranslation(int y){
		double yCalc = -1.3 + ((2.6 * y) / 512);
		return yCalc;
	}
	/**
	 * This method does the Escape-Time Calculations for the MultiBrot Set
	 * @param xCalc - a translated x-Coordinate in the MultiBrot Set
	 * @param yCalc - a translated y-Coordinate in the MultiBrot Set
	 * @return the Escape Time for the set == number of passes done
	 */
	private double dist;
	private int passes = 0;
	public int mbSetETCalculation(double xCalc, double yCalc) {
		while (dist <= 2 && passes < 255) {
			dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));
			xCalc = (xCalc * xCalc * xCalc) - (3 * xCalc * (yCalc * yCalc));
			yCalc = (3 * (xCalc * xCalc) * yCalc) - (yCalc * yCalc * yCalc);
			passes = passes + 1;
			dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));
		}
		return passes;
	}
	
	public int[][] return2DArray(){
		return array;
	}
}
