package edu.buffalo.cse116;

public class burningshipset {
	
	public int[][] Burningshipset(double xCalc, double yCalc){
		int[][] burningshipset = new int[512][512];
		
		double dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		int passes = 0;
		
		while (dist <= 4 && passes < 255){
			double x = xCalc;
			double y = yCalc;
						
			xCalc = xCalc + (3.5/512);
			yCalc = yCalc + (0.105/512);
				
			double xprime = (xCalc * xCalc) - (yCalc * yCalc) + x;
			double yprime = Math.abs(2 * xCalc * yCalc) + y;
			xCalc = xprime;
			yCalc = yprime;
			passes++;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc)); 
		}
		return burningshipset;
	}
	public double xcor(int rows){
		double xcord = -1.8;  
		double sum	= 3.5 * (rows/512);
		xcord = xcord + sum;
		return xcord;
	}
	public double ycor(int cols){
		double ycord = -0.08;
		double sum = 0.105 * (cols/512);
		ycord = ycord + sum;
		return ycord;
	}
}




	
// none of the pixels in the burningshipset have an escape time of 0 or 1
