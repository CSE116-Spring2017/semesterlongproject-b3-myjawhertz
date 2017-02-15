package edu.buffalo.cse116;

public class MandelbrotSet{
	private int xCord = 512;
	private int yCord = 512;
	private double xCalc = -2.15 + Math.abs((-2.15 + .6) / 512);
	private double yCalc = -1.3 + Math.abs((-1.3 + 1.3) / 512);
	public int[][] mandelbrotSet(double xCalc, double yCalc){
		for(int i = 0; i < xCord; i++){
			for(int a = 0; i < yCord; a++){
				double xPrime = (xCalc * xCalc) - (yCalc * yCalc) + xCalc;
				double yPrime = (2 * xCalc * yCalc) + yCalc;
				xPrime = xCalc;
				yPrime = yCalc;
			}
		}
		return mandelbrotSet(yCalc, yCalc);
		
	}
}
