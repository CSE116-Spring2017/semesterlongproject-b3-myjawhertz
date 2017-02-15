package edu.buffalo.cse116;

public class burningshipset {
	public int[][] Burningshipset(){
		int[][] burningshipset = new int[512][512];
		int rows = burningshipset.length;
		int cols = burningshipset[0].length;
		
		
		double xCalc = 0.0; //current point's x-coordinate;
		double yCalc = 0.0;// current point's y-coordinate;
		double x = (xCalc * xCalc) - (yCalc * yCalc) + 0;//add current point x
		double y = Math.abs(2 * xCalc * yCalc) + 0; //add current point y
		double dist = 0.0;
		int passes = 0;
		
		for(int i =0; i < rows; i++){
			for(int n = 0; n < cols; n++){
				while (dist <= 0 && passes < 0){
					xCalc = x;
					yCalc = y;
					passes++;
					dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc)); 
				}
				//Set the current point's escape-time equal to passes 
			}
		}
		
		
		
		
		
		
		return burningshipset;
		
	}
	
}
