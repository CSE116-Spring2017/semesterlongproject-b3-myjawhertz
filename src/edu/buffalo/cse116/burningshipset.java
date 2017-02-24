package edu.buffalo.cse116;

//class for burningshipset
public class burningshipset {
	
	//@para value to be calculated for current x point
	//@para value to be calculated for currnet y point
	private int passes = 0;
	public int[][] Burningshipset(double xCalc, double yCalc){		
		double dist = 0.0;
		double x = xCalc;//current point of x
		double y = yCalc;//current point of y
		while (dist <= 2 && passes < 255){
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
			double xxx = xCalc; //x value before update
			double yyy = yCalc;	//y value before update
			xCalc = xCalc + (3.5/512);
			yCalc = yCalc + (0.105/512);
			xCalc = (xxx * xxx) - (yyy * yyy) + x;//calculating x-coordinate and updating
			yCalc = Math.abs(2 * xxx * yyy) + y;//calculating y-coordinate and updating
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc)); 
			passadding();
			
		}
		return null; 
	} 
	//method calculating translation of x-coord
	//@para x value before calculation
	//@return calculated xcoord value
	public double xcor(int rows){
		double xcord = -1.8;
		double sum	= 3.5 * (rows/512);
		xcord = xcord + sum;
		return xcord;
	}
	//method calculating translation of y-coord
	//@para y value before calculation
	//@return calculated ycoord vale
	public double ycor(int cols){
		double ycord = -0.08;
		double sum = 0.105 * (cols/512);
		ycord = ycord + sum;
		return ycord;
	}
	//@para x value to be used for test
	//@para y value to be used for test
	public int passtester(double x, double y){
		Burningshipset(x,y);
		return passes;
	}
	
	//adding value of 1 to passes
	//@return return to the total number of passes
		public int passadding(){
		passes++;
		return passes;
	}
		
	//@return return to array with 512 rows and 512 cols
	public int[][] returnarray(){
		int[][] returnarray = new int[512][512];
		return returnarray;
	}
	
	//method to be used for test whether the escape-time become 0 or 1
	//@return return to array type int with 512 rows and 512 cols
	public boolean test() {
		
		int x = 0;
		int y = 0;
		for (x = 0; x < 512; x++) {
			for (y = 0; y < 512; y++) {
				passtester(xcor(x),ycor(y));
				
				if (passtester(xcor(x),ycor(y)) > 2) {
					return true;
				}
			}
		}
		return false;
	}
}

