package edu.buffalo.cse116;

public class MandelbrotSet {

	/**
	 * translate from 0-512 row to xCord
	 * 
	 * @param xRow
	 *            - row from 0 - 512
	 * @return y coordinate
	 **/
	public double getXCord(int xRow) {
		double xCord = -2.15 + (2.75 * xRow / 512);
		return xCord;
	}

	/**
	 * translate from 0-512 row to yCord
	 * 
	 * @param yCol
	 *            - column from 0 - 512
	 * @return y coordinate
	 **/
	public double getYCord(int yCol) {
		double yCord = -1.3 + (2.6 * yCol / 512);
		return yCord;
	}

	/**
	 * calculates passes
	 * 
	 * @param xCalc
	 *            - X-coordinate range from -2.15 to 0.6
	 * @param yCalc
	 *            - Y-coordinate range from -1.3 to 1.3
	 * @return number of passes for the inserted xCalc and yCalc
	 **/
	public int mandelbrotSet(double xCalc, double yCalc) {
		double x = xCalc;
		double y = yCalc;
		double dist = 0;
		int passes = 0;
		while (dist <= 2 && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) + x;
			yCalc = (2 * (tempX * tempY)) + y;

			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));

			passes++;
		}

		return passes;
	}

	/**
	 * creates a 2D array with passes for each point
	 * 
	 * @return 2D array with passes for each point
	 */
	public int[][] returnArrayWithPasses() {
		int[][] array = new int[512][512];
		for (int x = 0; x < 512; x++) {
			for (int y = 0; y < 512; y++) {
				array[x][y] = mandelbrotSet(getXCord(x), getYCord(y));
				// System.out.println(array[x][y]);
			}
		}
		return array;
	}

	/**
	 * Returns a single pass
	 * 
	 * @param xCalc
	 *            - X-coordinate range from -2.15 to 0.6
	 * @param yCalc
	 *            - Y-coordinate range from -1.3 to 1.3
	 * @param i
	 *            - distance
	 * @return - the number of passes
	 */

	public int userInputPasses(double xCalc, double yCalc, double i) {
		double x = xCalc;
		double y = yCalc;
		double dist = i;
		int passes = 0;
		while (dist <= i && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;
			xCalc = (tempX * tempX) - (tempY * tempY) + x;
			yCalc = (2 * (tempX * tempY)) + y;
			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
			passes++;
		}
		return passes;
	}

	/**
	 * Return a 2D array of passes
	 * 
	 * @param i
	 *            - distance
	 * @return- the number of passes
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

	/**
	 * 
	 * @param xCalc
	 *            - Y-coordinate range from -2.15 to 0.6
	 * @param yCalc
	 *            - Y-coordinate range from -1.3 to 1.3
	 * @return
	 */

	public int mandelbrotsetPass10(double xCalc, double yCalc) {
		double x = xCalc;
		double y = yCalc;
		double dist = 0;
		int passes = 0;
		while (dist <= 3 && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;
			xCalc = (tempX * tempX) - (tempY * tempY) + x;
			yCalc = (2 * (tempX * tempY)) + y;
			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
			passes++;
		}
		return passes;
	}

	public int mandelbrotDist2Pass135(double xCalc, double yCalc) {
		double x = xCalc;
		double y = yCalc;
		double dist = 0;
		int passes = 0;
		while (dist <= 2 && passes < 135) {
			double tempX = xCalc;
			double tempY = yCalc;
			xCalc = (tempX * tempX) - (tempY * tempY) + x;
			yCalc = (2 * (tempX * tempY)) + y;
			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
			passes++;
		}
		return passes;
	}

	public int holder(double xCalc, double yCalc, int i, int z) {
		double x = xCalc;
		double y = yCalc;
		double dist = z;
		int passes = 0;
		while (dist <= z && passes < i) {
			double tempX = xCalc;
			double tempY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) + x;
			yCalc = (2 * (tempX * tempY)) + y;

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
				array[x][y] = holder(getXCord(x), getYCord(y), a, c);
				// System.out.println(array[x][y]); 
			} 
		}
		return array;

	}
	
	
	public double getXCordRect(int xRow, double xStart, double xWidth) { 
		double xCord = -2.15 + (2.75 * xStart / 512) + ((2.75 * xWidth / 512) * xRow / 512);
		return xCord;
	}
	
	public double getYCordRect(int yCol, double yStart, double yWidth) {
		double yCord = -1.3 + (2.6 * yStart / 512) +  ((2.6 * yWidth / 512) * yCol / 512);
		return yCord;
	}
	
	
	public int[][] rectangle(String i, String b, double e, double r, double er, double gg) {
		int a = Integer.parseInt(i);
		int c = Integer.parseInt(b);
		int[][] array = new int[512][512];
		for (int x = 0; x < 512; x++) {
			for (int y = 0; y < 512; y++) {
				array[x][y] = holder(getXCordRect(x,e, er), getYCordRect(y, r, gg), a, c);
				// System.out.println(array[x][y]);
			} 
		}
		return array;
	}
	
}
