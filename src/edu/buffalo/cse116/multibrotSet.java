package edu.buffalo.cse116;

public class multibrotSet {
	
	public double XCoordTranslation(int x){
		double xCalc = -1 + ((2 * x) / 512);
		return xCalc;
	}
	
	public double YCoordTranslation(int y){
		double yCalc = -1.3 + ((2.6 * y) / 512);
		return yCalc;
	}
	
	private double dist;
	private int passes = 0;
	public int mbSetETCalculation(double xCalc, double yCalc) {
		while (dist <= 2 && passes < 255) {
			dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));
			xCalc = (xCalc * xCalc * xCalc) - (3 * xCalc * (yCalc * yCalc));
			yCalc = (3 * (xCalc * xCalc) * yCalc) - (yCalc * yCalc * yCalc);
			passes = passes + 1;
			dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));
		}
		return passes;
	}
}
