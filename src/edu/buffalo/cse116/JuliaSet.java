package edu.buffalo.cse116;

public class JuliaSet {
	int canvas [][] ;
	int arr [] [];
	double xtest;
	double ytest;
	public int  JuliaSet(double xCoord, double yCoord){
		double xCalc = xCoord;
		double yCalc = yCoord;
		
		double x2= xCalc * xCalc;
		double y2 = yCalc*yCalc;
		
		double dist = Math.sqrt(x2+y2);
		
//	  //  int [][] xY = new  int [512][512];
//		int width = xY.length; //row
//		int height = xY[0].length; //column
//		
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
	
	public int [] [] canvaS(){

		arr= new int [512] [512];
		int row = arr.length;
		int col = arr[0].length;
		for (int i =0; i<row; i++){
			//row
			
			for(int j=0; j<col;j++){
			int retVal =JuliaSet(i,j);
			arr[row][col]= arr [i][j];
				//row[i];
				
			}
			
		}
		return arr;
		
		
	}
	
	
	public double xCoord(int row){
		//double xCoorPixel = row;
		 
		double xCoorPixel = -1.7+(3.4*row/512);
		return xCoorPixel;
	}
	
	public double yCoord(int col){
		double yCoorPixel = -1.0+(2 *col/512);
		return yCoorPixel;
		
		}
		
	}


