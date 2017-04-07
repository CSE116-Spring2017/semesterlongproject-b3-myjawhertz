package edu.buffalo.cse116;

public class JuliaSet {
	int[][] emptyArray;

	/**
	 * The method below @return new empty 2D array 512 by 512
	 */

	/**
	 * The method below:
	 * 
	 * @param row
	 *            takes in XCoord on 512 by 512 and
	 * @return in pixel
	 */
	public double getXCord(int xRow) {
		double xCord = -1.7 + (3.4 * xRow / 512);
		return xCord;
	}

	/**
	 * The method below:
	 * 
	 * @param col
	 *            takes in Y-Coordinate on 512 by 512 2D array
	 * @return in Pixel
	 */
	public double getYCord(int yCol) {
		double yCord = -1.0 + (2.0 * yCol / 512);
		return yCord;
	}

	/**
	 * The method below:
	 * 
	 * @param XCoord
	 *            - takes in X-coordinate range from -1.7 to 1.7
	 * @param YCoord
	 *            takes in Y-Coordinate range from -1.0 to 1.0
	 * @return the number of passes for XCoord YCoord
	 * 
	 **/

	public int JuliaSet(double xCalc, double yCalc) {

		double dist = 0;
		int passes = 0;
		while (dist <= 2 && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) - 0.72689;
			yCalc = (2 * tempX * tempY) + 0.188887;

			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
			passes++;

		}

		return passes;

	}
	/*
	 * @return empty array 512 by 512
	 */

	public int[][] emptyArray() {
		emptyArray = new int[512][512];
		return emptyArray;
	}
	/*
	 * Generates array with passes
	 * 
	 * @return array with all the passes
	 */

	public int[][] returnArrayWithPasses() {
		int[][] array = new int[512][512];
		for (int x = 0; x < 512; x++) {
			for (int y = 0; y < 512; y++) {
				array[x][y] = JuliaSet(getXCord(x), getYCord(y));
				// System.out.println(array[x][y]);
			}
		}
		return array;
	}

	/*
	 * 
	 * Takes in xCalc and YCalc and calculates the passes
	 * 
	 * @return passes
	 */
	public int juliasetPass10(double xCalc, double yCalc) {

		double dist = 0;
		int passes = 0;
		while (dist <= 3 && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) - 0.72689;
			yCalc = (2 * tempX * tempY) + 0.188887;

			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
			passes++;

		}

		return passes;

	}

	/*
	 * Takes in user input for distance and returns passes
	 * 
	 * @return passes
	 * 
	 */
	public int userInputPasses(double xCalc, double yCalc, double i) {

		double dist = i;
		int passes = 0;
		while (dist <= i && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) - 0.72689;
			yCalc = (2 * tempX * tempY) + 0.188887;

			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
			passes++;

		}

		return passes;
	}

	/*
	 * 
	 * Takes in String turns it into int and re-calculates the fractal escapre
	 * distance
	 * 
	 * @return array with passes
	 * 
	 */
	public int[][] userInputEscape(String i) {
		int a = Integer.parseInt(i);
		int[][] array = new int[512][512];
		for (int x = 0; x < 512; x++) {
			for (int y = 0; y < 512; y++) {
				array[x][y] = userInputPasses(getXCord(x), getYCord(y), a);
				// System.out.println(array[x][y]);
			}
		}
		return array;
	}

	public int juliaDist2Pass135(double xCalc, double yCalc) {

		double dist = 0;
		int passes = 0;
		while (dist <= 2 && passes < 135) {
			double tempX = xCalc;
			double tempY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) - 0.72689;
			yCalc = (2 * tempX * tempY) + 0.188887;

			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
			passes++;

		}

		return passes;

	}

	public int juliaRealPasses(double xCalc, double yCalc, int i, int z) {
		double x = xCalc;
		double y = yCalc;
		double dist = z;
		int passes = 0;
		while (dist <= z && passes < i) {
			double tempX = xCalc;
			double tempY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) - 0.72689;
			yCalc = (2 * tempX * tempY) + 0.188887;

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
				array[x][y] = juliaRealPasses(getXCord(x), getYCord(y), a, c);
				// System.out.println(array[x][y]);
			}
		}
		return array;
	}
	public double getXCordRect(int xRow, int xStart, int xWidth) {
		double xCord = -1.7 + (3.4 * xStart / 512) + ((3.4 * xWidth / 512) * xRow / 512);
		return xCord;
	}
	
	public double getYCordRect(int yCol, int yStart, int yWidth) {
		double yCord = -1.0 + (2.0 * yStart / 512) +  ((2.0 * yWidth / 512) * yCol / 512);
		return yCord;
	}
	
	public int[][] rectangle(String i, String b, int e, int r, int er, int gg) {
		int a = Integer.parseInt(i);
		int c = Integer.parseInt(b);
		int[][] array = new int[512][512];
		for (int x = 0; x < 512; x++) {
			for (int y = 0; y < 512; y++) {
				array[x][y] = juliaRealPasses(getXCordRect(x,e, er), getYCordRect(y, r, gg), a, c);
				// System.out.println(array[x][y]);
			} 
		}
		return array;
	}
	
}
