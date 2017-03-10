package edu.buffalo.cse116;

//class for burningshipset
public class burningshipset {
	
	//@para value to be calculated for current x point
	//@para value to be calculated for currnet y point
	private int passes = 0;
	public int Burningshipset(double xCalc, double yCalc){		
		double dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));;
		double x = xCalc;//current point of x
		double y = yCalc;//current point of y
		
		while (dist <= 2 && passes < 255){
			double xxx = xCalc; //x value before update
			double yyy = yCalc;	//y value before update
			xCalc = (xxx * xxx) - (yyy * yyy) + x;//calculating x-coordinate and updating
			yCalc = Math.abs(2 * xxx * yyy) + y;//calculating y-coordinate and updating
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc)); 
			passes += 1;
			
		}
		return passes; 
	} 
	//method calculating translation of x-coord
	//@para x value before calculation
	//@return calculated xcoord value
	public double xcor(int rows){
		double xcord = -1.8 + 3.5 * (rows/512);
		return xcord;
	}
	//method calculating translation of y-coord
	//@para y value before calculation
	//@return calculated ycoord vale
	public double ycor(int cols){
		double ycord = -0.08 +  0.105 * (cols/512);
		return ycord;
	}
	
	//@return return to array with 512 rows and 512 cols
	public int[][] returnarray(){
		int[][] returnEmptyArray = new int[512][512];
		return returnEmptyArray;
	}
	
	public int[][] returnArrayWithPasses(){
		int[][] array = new int[512][512];
		for(int a = 0; a < 512; a++){
			for(int b = 0; b < 512; b++){
				array[a][b] = Burningshipset(xcor(a),ycor(b));
			}
		}  
		return array;
	}
	
	//method to be used for test whether the escape-time become 0 or 1
	//@return return to array type int with 512 rows and 512 cols
	public boolean test() {
		int x = 0;
		int y = 0;
		for (x = 0; x < 512; x++) {
			for (y = 0; y < 512; y++) {
				Burningshipset(xcor(x),ycor(y));
				if (Burningshipset(xcor(x),ycor(y)) > 2) {
					return true;
				}
			}
		}
		return false;
	}
}

