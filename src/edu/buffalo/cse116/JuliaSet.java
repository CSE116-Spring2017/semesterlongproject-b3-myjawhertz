package edu.buffalo.cse116;

public class JuliaSet {

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

public int[][] returnArrayWithPasses() {
	int[][] array = new int[512][512];
	for(int x = 0; x < 512; x++){
		for(int y = 0; y < 512; y++){
			array[x][y] = JuliaSet(getXCord(x),getYCord(y));	
			System.out.println(array[x][y]);
		}
	}
	return array;
}

}
