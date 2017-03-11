package edu.buffalo.cse116;

//class for burningshipset
public class burningshipset {
	public double getXCord(int xRow) {
		double xCord = -1.8 + (.1 * xRow / 512);
		return xCord;
	}

	/**
	 * translate from 0-512 row to yCord
	 * @param yCol - column from 0 - 512
	 * @return y coordinate
	 **/
	public double getYCord(int yCol) {
		double yCord = -0.08 + (.105 * yCol / 512);
		return yCord;
	}

//	private double dist;
//	private int passes = 0;

	/**
	 * calculates passes
	 * 
	 * @param xCalc - X-coordinate range from -2.15 to 0.6
	 * @param yCalc - Y-coordinate range from -1.3 to 1.3
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
			yCalc = Math.abs(2*tempX*tempY) + y;

			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));

			passes++;
		}

		return passes;
	}
	
	public int[][] return2DArray(){
		int[][] array = new int[512][512];
		return array;
	}


	/**
	 * creates a 2D array with passes for each point
	 * @return 2D array with passes for each point
	 */
	public int[][] returnArrayWithPasses() {
		int[][] array = new int[512][512];
		for(int x = 0; x < 512; x++){
			for(int y = 0; y < 512; y++){
				array[x][y] = burningShip(getXCord(x), getYCord(y));	
//				System.out.println(array[x][y]);
			}
		}
		return array;
	}
	
	public int userInputPasses(double xCalc, double yCalc, double i) {
		double x = xCalc;
		double y = yCalc;
		double dist = i;
		int passes = 0;
		while (dist <= i && passes < 255) {
			double tempX = xCalc;	
			double tempY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) + x;
			yCalc = Math.abs(2*tempX*tempY) + y;

			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));

			passes++;
		}

		return passes;
	}
	
	
	
	public boolean OnlyOneOrZero() {
		int[][] array = new int[512][512];
		for(int x = 0; x < 512; x++){
			for(int y = 0; y < 512; y++){
				if(array[x][y] <= 2){
					return true;
				}
				else{
					return false;
				}
			}
			
		}
		return false;
		
	}
	
	public int[][] userInputEscape(String i) {
		int a = Integer.parseInt(i);
		int[][] array = new int[512][512];
		for(int x = 0; x < 512; x++){
			for(int y = 0; y < 512; y++){
				array[x][y] = userInputPasses(getXCord(x), getYCord(y), a);	
//				System.out.println(array[x][y]);
			}
		}
		return array;
	} 
	
	
	
	public int burningshipsetPass10(double xCalc, double yCalc) {
		double x = xCalc;
		double y = yCalc;
		double dist = 0;
		int passes = 0;
		while (dist <= 3 && passes < 255) {
			double tempX = xCalc;	
			double tempY = yCalc;

			xCalc = (tempX * tempX) - (tempY * tempY) + x;
			yCalc = Math.abs(2*tempX*tempY) + y;

			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));

			passes++;
		}

		return passes;
	}
}