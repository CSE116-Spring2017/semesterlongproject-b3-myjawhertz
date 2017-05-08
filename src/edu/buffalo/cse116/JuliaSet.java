package edu.buffalo.cse116;

public class JuliaSet {
	int[][] emptyArray;

	/**
	 * The method below @return new empty 2D array 2048 by 2048
	 */

	/**
	 * The method below:
	 * 
	 * @param row
	 *            takes in XCoord on 2048 by 2048 and
	 * @return in pixel
	 */
	public double getXCord(int xRow) {
		double xCord = -1.7 + (3.4 * xRow / 2048);
		return xCord;
	}

	/**
	 * The method below:
	 * 
	 * @param col
	 *            takes in Y-Coordinate on 2048 by 2048 2D array
	 * @return in Pixel
	 */
	public double getYCord(int yCol) {
		double yCord = -1.0 + (2.0 * yCol / 2048);
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
	 * @return empty array 2048 by 2048
	 */

	public int[][] emptyArray() {
		emptyArray = new int[2048][2048];
		return emptyArray;
	}
	/*
	 * Generates array with passes
	 * 
	 * @return array with all the passes
	 */

	public int[][] returnArrayWithPasses(int a, int b) {
		int i = -1;
		int[][] array = new int[b-a+1][2048];

		for (int x = a; x <= b; x++) {
			for (int y = 0; y < 2048; y++) {
				
				array[x-a][y] = JuliaSet(getXCord(x), getYCord(y));
			}
		}
		return array;
	}
	/*
	 * 
	 * Takes in xCalc and YCalc and calculates the passes
	 * @param xCalc takes in X coordinate range
	 * @param yCalc takes in y Coordinate range
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
	 * @param double xCalc
	 * 		  double yCalc
	 * 		  double i 
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
		int[][] array = new int[2048][2048];
		for (int x = 0; x < 2048; x++) {
			for (int y = 0; y < 2048; y++) {
				array[x][y] = userInputPasses(getXCord(x), getYCord(y), a);
				// System.out.println(array[x][y]);
			}
		}
		return array;
	}
	/*
	 * Only called in a JUnit test to test if the set returns an escape time of 135 when
	 * the distance is set to 2 given a certain x and y value.
	 * @param xCalc - X-Value given in the JUnit test case
	 * @param yCalc - Y-Value given in the JUnit test case
	 * @return the Escape-Time of the set == the number of passes done
	 */
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
	/*
	 * Calculates the Escape-Time using for the set using the custom distance and maximum number
	 * of passes which are set by the user.
	 * @param xCalc - a translated X-Coordinate in the Multibrot Set
	 * @param yCalc - a translated Y-Coordinate in the Multibrot Set
	 * @param i - maximum number of passes (determined by user input)
	 * @param z - distance used for calculations (determined by user input)
	 * @return the Escape-Time of the set == the number of passes done
	 */
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
	/*
	 * @param  String i entry from TextBox1: determines maximum number of passes allowed
	 * 		   String b entry from TextBox2: determines distance used for ET calculations
	 * @return 2D array of int of Escape-Times for each pixel in 2048*2048 array
	 */
	public int[][] userInputEscapeTime(String i, String b) {
		int a = Integer.parseInt(i);
		int c = Integer.parseInt(b);
		int[][] array = new int[2048][2048];
		for (int x = 0; x < 2048; x++) {
			for (int y = 0; y < 2048; y++) {
				array[x][y] = juliaRealPasses(getXCord(x), getYCord(y), a, c);
			}
		}
		return array;
	}
	/*@param int xRow
	 * 		 int xStart
	 * 		 int xWidth
	 * 
	 */
	public double getXCordRect(int xRow, double xStart, double xWidth) {
		double xCord = -1.7 + (3.4 * xStart / 2048) + ((3.4 * xWidth / 2048) * xRow / 2048);
		return xCord;
	}
	/*
	 * @param int yCol
	 * 		  int yStart is height start
	 * 		  int yWidth is total width of drawn rectangle
	 * 
	 */
	public double getYCordRect(int yCol, double yStart, double yWidth) { 
		double yCord = -1.0 + (2.0 * yStart / 2048) +  ((2.0 * yWidth / 2048) * yCol / 2048);
		return yCord;
	}
	/*
	 * Gets the recalculated image once user selects an area to zoom to
	 * @param String i  gets user desired escape distance
	 *        String b  gets user desired escape time
	 *        double e  starting x
	 *        double r  starting y
	 *        double er rectangle width
	 *        double gg rectangle height
	 * @return array 
	 */
	public int[][] rectangle(String i, String b, double e, double r, double er, double gg) {
		int a = Integer.parseInt(i);
		int c = Integer.parseInt(b);
		int[][] array = new int[2048][2048];
		for (int x = 0; x < 2048; x++) {
			for (int y = 0; y < 2048; y++) {
				array[x][y] = juliaRealPasses(getXCordRect(x,e, er), getYCordRect(y, r, gg), a, c);
				// System.out.println(array[x][y]);
			} 
		}
		return array;
	}
	
}
