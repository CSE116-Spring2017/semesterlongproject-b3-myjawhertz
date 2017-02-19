package edu.buffalo.cse116;

public class burningshipset {
	private double xcor;
	private double ycor;
	public int[][] Burningshipset(double xCalc, double yCalc){
		int[][] burningshipset = new int[512][512];
		
	
		double dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
		int passes = 0;
		
		
		while (dist <= 4 && passes < 255){
			double x = xCalc;
			double y = yCalc;
			
			xcor = x;
			ycor = y;
			
			
			xCalc = xCalc + (3.5/512);
			yCalc = yCalc + (0.105/512);
			
			
					
			double xprime = (xCalc * xCalc) - (yCalc * yCalc) + x;
			double yprime = Math.abs(2 * xCalc * yCalc) + y;
			xCalc = xprime;
			yCalc = yprime;
			passes++;
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc)); 
		}
		//Set the current point's escape-time equal to passes 
		return burningshipset;
		
	}
	public void translation(double X,double Y){
		X = xcor;
		Y = ycor;
		
	}
}




	
// none of the pixels in the burningshipset have an escape time of 0 or 1
