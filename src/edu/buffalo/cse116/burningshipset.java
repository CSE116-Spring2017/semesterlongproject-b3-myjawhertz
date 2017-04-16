package edu.buffalo.cse116;

//class for burningshipset
public class burningshipset {
	/**
	 * @param xRow
	 *            - row from 0 - 512
	 * @return x cordinate
	 */
	public double getXCord(int xRow) {
		double xCord = -1.8 + (.1 * xRow / 512);
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
		double yCord = -0.08 + (.105 * yCol / 512);
		return yCord;
	}

	// private double dist;
	// private int passes = 0;

	/**
	 * calculates passes
	 * 
	 * @param xCalc
	 *            - X-coordinate range from -1.8 to -1.7
	 * @param yCalc
	 *            - Y-coordinate range from -0.08 to 0.025
	 * @return number of passes for the inserted xCalc and yCalc
	 **/
	public int burningShip(double xCalc, double yCalc) {
		double x = xCalc;
		double y = yCalc;
		double dist = 0;
		int passes = 0;
		while (dist <= 2 && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) + x;
			yCalc = Math.abs(2 * tempX * tempY) + y;

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
				array[x][y] = burningShip(getXCord(x), getYCord(y));
				// System.out.println(array[x][y]);
			}
		}
		return array;
	}

	/**
	 * @param xCalc
	 *            - X-coordinate range from -1.8 to -1.7
	 * @param yCalc
	 *            - Y-coordinate range from -0.08 to 0.025
	 * @param i
	 *            - distance
	 * @return a single pass
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
			yCalc = Math.abs(2 * tempX * tempY) + y;

			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));

			passes++;
		}

		return passes;
	}

	/**
	 * checks to make sure none of the escape distance is 0 or 1
	 * 
	 * @return a boolean value
	 */
	public boolean OnlyOneOrZero() {
		int[][] array = new int[512][512];
		for (int x = 0; x < 512; x++) {
			for (int y = 0; y < 512; y++) {
				if (array[x][y] <= 2) {
					return true;
				} else {
					return false;
				}
			}

		}
		return false;

	}

	/**
	 * 
	 * @param i
	 *            - escape distance
	 * @return 2D array of passes
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
	 * @param xCalc
	 *            - X-coordinate range from -1.8 to -1.7
	 * @param yCalc
	 *            - Y-coordinate range from -0.08 to 0.025
	 * @return - passes with an escape distance of 3
	 */
	public int burningshipsetPass10(double xCalc, double yCalc) {
		double x = xCalc;
		double y = yCalc;
		double dist = 0;
		int passes = 0;
		while (dist <= 3 && passes < 255) {
			double tempX = xCalc;
			double tempY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) + x;
			yCalc = Math.abs(2 * tempX * tempY) + y;

			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));

			passes++;
		}

		return passes;
	}
	/**
	 * 
	 * @param xCalc x - coordinate range from -1.8 from -1.7
	 * @param yCalc y - coordinate range from -0.08 from 0.025
	 * @return number of passes when distance is 2 and passes less than 135
	 */
	public int burningshipsetDist2Pass135(double xCalc, double yCalc) {
		double x = xCalc;
		double y = yCalc;
		double dist = 0;
		int passes = 0;
		while (dist <= 2 && passes < 135) {
			double tempX = xCalc;
			double tempY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) + x;
			yCalc = Math.abs(2 * tempX * tempY) + y;

			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));

			passes++;
		}

		return passes;
	}
	/**
	 * 
	 * @param xCalc x - coordinate range from -1.8 from -1.7
	 * @param yCalc y - coordinate range from -0.08 from 0.025
	 * @param i escape distance
	 * @param z escape time
	 * @return number of passes calculated
	 */
	public int burningshipRealPasses(double xCalc, double yCalc, int i, int z) {
		double x = xCalc;
		double y = yCalc;
		double dist = z;
		int passes = 0;
		while (dist <= z && passes < i) {
			double tempX = xCalc;
			double tempY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) + x;
			yCalc = Math.abs(2 * tempX * tempY) + y;

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
				array[x][y] = burningshipRealPasses(getXCord(x), getYCord(y), a, c);
			}
		} 
		return array;
	}
	/**
	 * 
	 * @param xRow numbor of rows
	 * @param xStart current location of x
	 * @param xWidth width 
	 * @return calculated x coordinates
	 */
	public double getXCordRect(int xRow, double xStart, double xWidth) { 
		double xCord = -1.8 + (0.1 * xStart / 512) + ((0.1 * xWidth / 512) * xRow / 512);
		return xCord;
	}
	/**
	 * 
	 * @param yCol number of columns
	 * @param yStart current location of y
	 * @param yWidth height
	 * @return calculated y coordinates
	 */
	public double getYCordRect(int yCol, double yStart, double yWidth) {
		double yCord = -0.08 + (0.105 * yStart / 512) +  ((0.105 * yWidth / 512) * yCol / 512);
		return yCord;
	}
	/**
	 * 
	 * @param i text read from userinput
	 * @param b text read from userinput
	 * @param e	starting point of x value
	 * @param r starting point of y value
	 * @param er rectangle's width
	 * @param gg rectangle's height
	 * @return
	 */
	public int[][] rectangle(String i, String b, double e, double r, double er, double gg) {
		int a = Integer.parseInt(i);
		int c = Integer.parseInt(b);
		int[][] array = new int[512][512];
		for (int x = 0; x < 512; x++) {
			for (int y = 0; y < 512; y++) {
				array[x][y] = burningshipRealPasses(getXCordRect(x,e, er), getYCordRect(y, r, gg), a, c);
				
			} 
		}
		return array;
	}
	
	
}