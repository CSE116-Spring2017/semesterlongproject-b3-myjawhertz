package edu.buffalo.cse116;

public class MandelbrotSet{
	
//	private int xCord = 512;
//	private int yCord = 512;
//	private double passes = 0;
//	private double xCalc = -2.15 + Math.abs((2.15 + .6) / 512);
//	private double yCalc = -1.3 + Math.abs((1.3 + 1.3) / 512);
//	public double mandelbrotSet(double xCalc, double yCalc){
//		for(int i = 0; i < xCord; i++){
//			for(int a = 0; i < yCord; a++){
//				double xPrime = (xCalc * xCalc) - (yCalc * yCalc) + xCalc;
//				double yPrime = (2 * xCalc * yCalc) + yCalc;
//				xPrime = xCalc;
//				yPrime = yCalc;
//				passes++;
//			}
//		}
//		return passes;
//		
//	}
//	
//	public int[][] xCoordTranslation(double[][] al){
//		int i = al.length;
//		for (int r = 0; r < i; r++){
//				al[r] = (-2.15 + (2.75/512)*r);
//		}
//	}
	
	
	
	
	
	private double dist ;
	private int passes = 0;
	public int mandelbrotSet(double xCalc,double yCalc){
		double x = xCalc;
		double y = yCalc;
		
		
	
		while(dist <= 2 && passes < 255){
//		for(double i = xCalc; i < 0.6; i = i + ((2.15 + .6) / 512)){
//			for(double j = yCalc; j < 1.3; j = j + ((1.3 + 1.3) / 512)){
			
			dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));
			
			
				
			double tempX = xCalc;
			double tempY = yCalc;
			
			xCalc = xCalc + (2.6/512);
			yCalc = yCalc + (2.75/512);
			
			xCalc = (tempX*tempX) - (tempY*tempY) + x;
			yCalc = (2 * (tempX * tempY)) + y;
			
			dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));
			
			
//			xCalc = (i * i) - (j * j) - 2.15;
//			yCalc = 2 * i * j - 1.3;
			passes++;
		}
//			}
//		}
			
	
		
		return passes;
	}
	
	
	
//	public double mandelbrotSet(double xCalc,double yCalc){
//		xCalc = -2.15;
//		yCalc = -1.3;
//		double originalX = xCalc;
//		double originalY = yCalc;
//		double dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));
//		int passes = 0;
//		while(dist <= 4 && passes < 255){
//			double x = xCalc;
//			double y = yCalc;
//			
//			xCalc = (x * x) - (y * y) + originalX;
//			yCalc = 2 * x * y + originalY;
//			
//			yCalc = 
//			passes++;
//			dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));
//			
//		}
//		return passes;
//		
//	}
	
//	public int mandelbrotSet(double xCalc, double yCalc){
//		double dist = Math.sqrt(Math.pow(xCalc,2) + Math.pow(yCalc,2));
//		int[][] array = new int[512][512];
//		
//		while(dist <= 2 && passes <255){
//			passes++;
//			
//			
//			
//			
//			for(double i = -2.15; i < .6; i = i + 2.75 / 512){
//				for(double j = -1.3; j < 1.3; j = j + 2.6/512){
//					
//					int x = 0;
//					int y = 0;
//					double xPrime = xCalc;
//					double yPrime = yCalc;
//					
//					xPrime = (xPrime * xPrime) - (yPrime * yPrime) -2.15;
//					yPrime = 2 *xPrime * yPrime - 1.3;
//					
//					array[x][y] = passes;
//					y++;
//					x++;
//				}
//			}	
//		}
//		return passes;
//	}
}
