package edu.buffalo.cse116;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/** This class provides the JUnit tests that will be used
 * to make sure that each fractal set's translations and Escape-Time Calculations
 * are working properly.
 * @author Alec Otminski
 *
 */

public class SetTests {
	//Mandelbrot Set Tests
	
	@Test
	public void testMandelbrotXCoordinateTranslation(){	//this tests is the X-Coordinate Translation works
		int [][] emptySet = new int[512][512];
		MandelbrotSet xCoordTest = new MandelbrotSet();
		assertEquals("Product is -2.15", -2.15, xCoordTest.mandelbrotSet(0, 0));
	}
	@Test
	public void testMandelbrotYCoordinateTranslation(){
		int [][] emptySet = new int[512][512];
		MandelbrotSet yCoordTest = new MandelbrotSet();
		
	}
	@Test
	public void testMandelbrotETNeverExceedsED(){
		int [][] emptySet = new int[512][512];
		MandelbrotSet neverExceedsED = new MandelbrotSet();
	}
	@Test
	public void testMandelbrotETExceedsED(){
		int [][] emptySet = new int[512][512];
		MandelbrotSet etExceedsED = new MandelbrotSet();
	}
	@Test
	public void testMandelbrotReturn(){
		int[][] emptySet = new int [512][512];
		MandelbrotSet returns2DArray = new MandelbrotSet();
	}
	//Julia Set Tests
	
	@Test
	public void testJuliaXCoordinateTranslation(){	//name of class: JuliaSet
		int [][] emptySet = new int[512][512];
		JuliaSet xCoordTest = new JuliaSet();
		
	}
	@Test
	public void testJuliaYCoordinateTranslation(){
		int [][] emptySet = new int[512][512];
		JuliaSet yCoordTest = new JuliaSet();
		
	}
	@Test
	public void testJuliaETNeverExceedsED(){
		int [][] emptySet = new int[512][512];
		JuliaSet neverExceedsED = new JuliaSet();
	}
	@Test
	public void testJuliaETExceedsED(){
		int [][] emptySet = new int[512][512];
		JuliaSet etExceedsED = new JuliaSet();
	}
	@Test
	public void testJuliaReturn(){
		int[][] emptySet = new int [512][512];
		JuliaSet returns2DArray = new JuliaSet();
	}
	//Burning Ship Set Tests
	
	@Test
	public void testBurningShipXCoordinateTranslation(){	//name of class: burningshipset
		int [][] emptySet = new int[512][512];
		burningshipset xCoordTest = new burningshipset();
		
	}
	@Test
	public void testBurningShipYCoordinateTranslation(){
		int [][] emptySet = new int[512][512];
		burningshipset yCoordTest = new burningshipset();
		
	}
	@Test
	public void testBurningShipETNeverExceedsED(){
		int [][] emptySet = new int[512][512];
		burningshipset neverExceedsED = new burningshipset();
	}
	@Test
	public void testBurningShipETIsNot0or1(){	//unique test for Burning Ship Set
		int [][] emptySet = new int[512][512];
		burningshipset etIsNot0or1 = new burningshipset();
	}
	@Test
	public void testBurningShipReturn(){
		int[][] emptySet = new int [512][512];
		burningshipset returns2DArray = new burningshipset();
	}
}
