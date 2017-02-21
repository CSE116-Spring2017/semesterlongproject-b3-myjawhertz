package edu.buffalo.cse116;

public class MandelbrotSet {

	public double getXCord(int xRow) {
		double xCord = -2.15 + (2.75 * xRow / 512);
		return xCord;
	}

	public double getYCord(int YRow) {
		double yCord = -1.3 + (2.6 * YRow / 512);
		return yCord;
	}

//	private double dist;
//	private int passes = 0;
//
//	public int mandelbrotSet(double xCalc, double yCalc) {
//		double x = xCalc;
//		double y = yCalc;
//		while (dist <= 2 && passes < 255) {
//			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
//
//			double tempX = xCalc;
//			double tempY = yCalc;
//
//			xCalc = xCalc + (2.6 / 512);
//			yCalc = yCalc + (2.75 / 512);
//
//			xCalc = (tempX * tempX) - (tempY * tempY) + x;
//			yCalc = (2 * (tempX * tempY)) + y;
//
//			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
//
//			passes++;
//		}
//
//		return passes;
//	}
	
	private double dist;
	private int passes = 0;
	
	public int[][] mandelbrotSet(double xCalc, double yCalc) {
		double x = xCalc;
		double y = yCalc;
		int[][] arrayWithEscapeTime = new int[512][512];
		while (dist <= 2 && passes < 255) {
			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));
			
			for(double i = -2.15; i < .6; i = (2.75 * i) / 512){
				for (double j = -1.3; j < 1.3; j = (2.6 * j) / 512){
			
			double tempX = i;
			double tempY = j;

			xCalc = xCalc + (2.6 / 512);
			yCalc = yCalc + (2.75 / 512);

			xCalc = (i * i) - (j * j) + x;
			yCalc = (2 * (i * j)) + y;

			dist = Math.sqrt(Math.pow(xCalc, 2) + Math.pow(yCalc, 2));

			passesCount();
			xCord(i);
			yCord(j);
			}
			}
			
		}

		return arrayWithEscapeTime;
	}
	
	public int passesCount(){
		passes++;
		return passes;
	}
	
	public double xCord(double i){
		return i;
		
	}
	
	public double yCord(double j){
		return j;
		
	}
	

	// public double[][] getXAndYCalc(double xCalc, double yCalc){
	// return double[xCalc][yCalc];
	//
	// }

	// public double mandelbrotSet(double xCalc,double yCalc){
	// xCalc = -2.15;
	// yCalc = -1.3;
	// double originalX = xCalc;
	// double originalY = yCalc;
	// double dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));
	// int passes = 0;  
	// while(dist <= 4 && passes < 255){
	// double x = xCalc;
	// double y = yCalc;
	//
	// xCalc = (x * x) - (y * y) + originalX;
	// yCalc = 2 * x * y + originalY;
	//
	// yCalc =
	// passes++;
	// dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));
	//
	// }
	// return passes;
	//
	// }

	// public int mandelbrotSet(double xCalc, double yCalc){
	// double dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));
	// int[][] array = new int[512][512];
	//
	// while(dist <= 2 && passes <255){
	// passes++;
	//
	//
	//
	//
	// for(double i = -2.15; i < .6; i = i + 2.75 / 512){
	// for(double j = -1.3; j < 1.3; j = j + 2.6/512){
	//
	// int x = 0;
	// int y = 0;
	// double xPrime = xCalc;
	// double yPrime = yCalc;
	//
	// xPrime = (xPrime * xPrime) - (yPrime * yPrime) -2.15;
	// yPrime = 2 *xPrime * yPrime - 1.3;
	//
	// array[x][y] = passes;
	// y++;
	// x++;
	// }
	// }
	// }
	// return passes;
	// }
}
