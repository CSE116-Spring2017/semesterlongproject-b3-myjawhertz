package edu.buffalo.cse116;

public class MandelbrotSet {

	/**
	 * translate from 0-512 row to xCord
	 * 
	 * @param xRow - row from 0 - 512
	 * @return y coordinate
	 **/
	public double getXCord(int xRow) {
		double xCord = -2.15 + (2.75 * xRow / 512);
		return xCord;
	}

	/**
	 * translate from 0-512 row to yCord
	 * @param yCol - column from 0 - 512
	 * @return y coordinate
	 **/
	public double getYCord(int yCol) {
		double yCord = -1.3 + (2.6 * yCol / 512);
		return yCord;
	}

	/**
	 * calculates passes
	 * 
	 * @param xCalc - X-coordinate range from -2.15 to 0.6
	 * @param yCalc - Y-coordinate range from -1.3 to 1.3
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
	 * @return 2D array with passes for each point
	 */
	public int[][] returnArrayWithPasses() {
		int[][] array = new int[512][512];
		for(int x = 0; x < 512; x++){
			for(int y = 0; y < 512; y++){
				array[x][y] = mandelbrotSet(getXCord(x), getYCord(y));	
//				System.out.println(array[x][y]);
			}
		}
		return array;
	}
	
}

