package edu.buffalo.cse116;

public class multibrotSet {
	private double dist ;
	private int passes = 0;
	
	
	public int multibrotSet(double xCalc,double yCalc){
		double x = xCalc;
		double y = yCalc;
		
		while(dist <= 2 && passes < 255){
			dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));	
			double tempX = xCalc;
			double tempY = yCalc;
			
			xCalc = xCalc + (2/512);
			yCalc = yCalc + (2.6/512);
			
			xCalc = (tempX*tempX*tempX) - (3*tempX*tempY*tempY) + x;
			yCalc = (3*tempX*tempX*tempY) - (tempY*tempY*tempY) + y;
			
			dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));

			passes++;
		}
		return passes;
	}
}
