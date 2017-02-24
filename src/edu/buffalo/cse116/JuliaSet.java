package edu.buffalo.cse116;

public class JuliaSet {
//	int canvas [][] ;
	int arr [] [];
	double xtest;
	double ytest;
	
	public JuliaSet(){
		
	}
	/**
	 * The method below:
	 * @param XCoord - takes in X-coordinate range from -1.7 to 1.7
	 * @param YCoord takes in Y-Coordinate range from -1.0 to 1.0
	 * @return the number of passes for XCoord YCoord
	 * 
	 **/
	public int  JuliaSet(double xCoord, double yCoord){
		double xCalc = xCoord;
		double yCalc = yCoord;
		
		double x2= xCalc * xCalc;
		double y2 = yCalc*yCalc;
		
		double dist = Math.sqrt(x2+y2);
		
		int passes = 0;
		
		while (dist <=2 && passes <255){
		
			xCalc = (xCalc*xCalc) - (yCalc * yCalc)+ (-0.72689);
			double xx= xCalc*xCalc;
			
			
			yCalc= 2* xCalc * yCalc+ 0.188887;
			double yy=  yCalc*yCalc;
			
			passes++;
			
			dist =Math.sqrt(xx+yy);
		}
		
		return passes;
		
	}
	/**
	 * The method below @return new empty 2D array 512 by 512
	 */
	public int [] [] canvaS(){
         
		arr= new int [512] [512];	
		return arr;
		
		
	}
	
	/**
	 * The method below:
	 * @param row takes in XCoord on 512 by 512 and
	 * @return in pixel
	 */
	public double xCoord(int row){ 
		double xCoorPixel = -1.7+(3.4*row/512);
		return xCoorPixel;
	}
	/**
	 * The method below:
	 * @param col takes in Y-Coordinate on 512 by 512 2D array
	 * @return in Pixel
	 */
	public double yCoord(int col){
		double yCoorPixel = -1.0+(2 *col/512);
		return yCoorPixel;
		
		}
		
	}


