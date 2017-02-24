package edu.buffalo.cse116;

//class for burningshipset
public class burningshipset {
<<<<<<< HEAD
	
	//@para value to be calculated for current x point
	//@para value to be calculated for currnet y point
=======
	// class for burningshipset
>>>>>>> branch 'master' of https://github.com/CSE116-Spring2017/semesterlongproject-b3-myjawhertz.git
	private int passes = 0;

	public int[][] Burningshipset(double xCalc, double yCalc) {
		double dist = 0.0;
		double x = xCalc;// current point of x
		double y = yCalc;// current point of y
		while (dist <= 2 && passes < 255) {
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
<<<<<<< HEAD
			double xxx = xCalc; //x value before update
			double yyy = yCalc;	//y value before update
			xCalc = xCalc + (3.5/512);
			yCalc = yCalc + (0.105/512);
			xCalc = (xxx * xxx) - (yyy * yyy) + x;//calculating x-coordinate and updating
			yCalc = Math.abs(2 * xxx * yyy) + y;//calculating y-coordinate and updating
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc)); 
=======
			double xxx = xCalc;
			double yyy = yCalc;
			xCalc = xCalc + (3.5 / 512);
			yCalc = yCalc + (0.105 / 512);
			xCalc = (xxx * xxx) - (yyy * yyy) + x;// calculating x-coordinate
			yCalc = Math.abs(2 * xxx * yyy) + y;// calculating y-coordinate
			dist = Math.sqrt((xCalc * xCalc) + (yCalc * yCalc));
>>>>>>> branch 'master' of https://github.com/CSE116-Spring2017/semesterlongproject-b3-myjawhertz.git
			passadding();

		}
<<<<<<< HEAD
		return null; 
	} 
	//method calculating translation of x-coord
	//@para x value before calculation
	//@return calculated xcoord value
	public double xcor(int rows){
=======
		return null;
		// return Burningshipset(x,y);
	}

	// method testing translation of x-coord
	public double xcor(int rows) {
>>>>>>> branch 'master' of https://github.com/CSE116-Spring2017/semesterlongproject-b3-myjawhertz.git
		double xcord = -1.8;
		double sum = (3.5 * rows) / 512;
		xcord = xcord + sum;
		return xcord;
	}
<<<<<<< HEAD
	//method calculating translation of y-coord
	//@para y value before calculation
	//@return calculated ycoord vale
	public double ycor(int cols){
=======

	// method testing translation of y-coord
	public double ycor(int cols) {
>>>>>>> branch 'master' of https://github.com/CSE116-Spring2017/semesterlongproject-b3-myjawhertz.git
		double ycord = -0.08;
		double sum = (0.105 * cols) / 512;
		ycord = ycord + sum;
		return ycord;
	}
<<<<<<< HEAD
	//@para x value to be used for test
	//@para y value to be used for test
	public int passtester(double x, double y){
		Burningshipset(x,y);
=======

	public int passtester(double x, double y) {
		Burningshipset(x, y);
>>>>>>> branch 'master' of https://github.com/CSE116-Spring2017/semesterlongproject-b3-myjawhertz.git
		return passes;
	}
<<<<<<< HEAD
	
	//adding value of 1 to passes
	//@return return to the total number of passes
		public int passadding(){
=======

	public int passadding() {
>>>>>>> branch 'master' of https://github.com/CSE116-Spring2017/semesterlongproject-b3-myjawhertz.git
		passes++;
		return passes;
	}
<<<<<<< HEAD
		
	//@return return to array with 512 rows and 512 cols
	public int[][] returnarray(){
=======

	public int[][] returnarray() {
>>>>>>> branch 'master' of https://github.com/CSE116-Spring2017/semesterlongproject-b3-myjawhertz.git
		int[][] returnarray = new int[512][512];
		return returnarray;
	}
<<<<<<< HEAD
	
	//method to be used for test whether the escape-time become 0 or 1
	//@return return to array type int with 512 rows and 512 cols
	public int[][] test(){
		int[][] emptyarr = new int[512][512];
		for (int i = 0; i <512; i++){
			for(int j = 0; j < 512; j++){
				emptyarr[i][j] = passtester(xcor(i),ycor(j));
=======

	public int[][] test(int i, int j) {
		int[][] arr = new int[512][512];

		arr[i][j] = passtester(xcor(i), ycor(j));

		return arr;
	}
	
	

	public boolean test() {
		
		int x = 0;
		int y = 0;
		for (x = 0; x < 512; x++) {
			for (y = 0; y < 512; y++) {
				passtester(xcor(x),ycor(y));
				
				if (passtester(xcor(x),ycor(y)) > 2) {
					return true;
				}
>>>>>>> branch 'master' of https://github.com/CSE116-Spring2017/semesterlongproject-b3-myjawhertz.git
			}
		}
		return false;
	}
}

