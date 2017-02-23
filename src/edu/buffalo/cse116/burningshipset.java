package edu.buffalo.cse116;

public class burningshipset {
	//class for burningshipset
	private int passes = 0;
	public int[][] Burningshipset(double xCalc, double yCalc){		
		double dist = 0.0;
		double x = xCalc;//current point of x
		double y = yCalc;//current point of y
		while (dist <= 2 && passes < 255){
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
			double xxx = xCalc;
			double yyy = yCalc;
			xCalc = xCalc + (3.5/512);
			yCalc = yCalc + (0.105/512);
			xCalc = (xxx * xxx) - (yyy * yyy) + x;//calculating x-coordinate
			yCalc = Math.abs(2 * xxx * yyy) + y;//calculating y-coordinate
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc)); 
			passadding();
			
		}
		return null; 
		//return  Burningshipset(x,y);
	} 
	//method testing translation of x-coord
	public double xcor(int rows){
		double xcord = -1.8;
		double sum	= 3.5 * (rows/512);
		xcord = xcord + sum;
		return xcord;
	}
	//method testing translation of y-coord
	public double ycor(int cols){
		double ycord = -0.08;
		double sum = 0.105 * (cols/512);
		ycord = ycord + sum;
		return ycord;
	}
	public int passtester(double x, double y){
		Burningshipset(x,y);
		return passes;
	} 
	public int passadding(){
		passes++;
		return passes;
	}
	public int[][] returnarray(){
		int[][] returnarray = new int[512][512];
		return returnarray;
	}
	public int[][] test(){
		int[][] emptyarr = new int[512][512];
//		for (int i = 0; i <512; i++){
//			for(int j = 0; j < 512; j++){
//				emptyarr[i][j] = passtester(xcor(i),ycor(j));
//			}
//		}
		return emptyarr;
	}
}

// none of the pixels in the burningshipset have an escape time of 0 or 1
