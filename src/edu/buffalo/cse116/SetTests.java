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
		MandelbrotSet xCoordTest = new MandelbrotSet();
		assertEquals("Product is -2.15", -2.15, xCoordTest.mandelbrotSet(0, 0), 0.0001);
	}
	@Test
	public void testMandelbrotYCoordinateTranslation(){
		MandelbrotSet yCoordTest = new MandelbrotSet();
		assertEquals("Product is -1.3", -1.3, yCoordTest.mandelbrotSet(0, 0), 0.0001);
	}
	
	@Test
	public void testMandelbrotETNeverExceedsED(){
		MandelbrotSet neverExceedsED = new MandelbrotSet();
		assertEquals("Product is 255.", 255, neverExceedsED.mandelbrotSet(0.3207031250000001, -0.07109374999999386), 0.0001);
	}
	@Test
	public void testMandelbrotETExceedsED(){
		MandelbrotSet etExceedsED = new MandelbrotSet();
		assertEquals("Product is 1.", 1 ,etExceedsED.mandelbrotSet(0.5946289062500001, 1.2949218750000122), 0.0001);
	}
	@Test
	public void testMandelbrotReturn(){
		MandelbrotSet returns2DArray = new MandelbrotSet();
	}
	
	//Julia Set Tests
	
	@Test
	public void testJuliaXCoordinateTranslation(){	//name of class: JuliaSet
		JuliaSet xCoordTest = new JuliaSet();
		
	}
	@Test
	public void testJuliaYCoordinateTranslation(){
		JuliaSet yCoordTest = new JuliaSet();
		
	}
	@Test
	public void testJuliaETNeverExceedsED(){
		JuliaSet neverExceedsED = new JuliaSet();
	}
	@Test
	public void testJuliaETExceedsED(){
		JuliaSet etExceedsED = new JuliaSet();
	}
	@Test
	public void testJuliaReturn(){
		JuliaSet returns2DArray = new JuliaSet();
	}
	
	//Burning Ship Set Tests
	
	@Test
	public void testBurningShipXCoordinateTranslation(){	//name of class: burningshipset
		burningshipset xCoordTest = new burningshipset();
		
	}
	@Test
	public void testBurningShipYCoordinateTranslation(){
		burningshipset yCoordTest = new burningshipset();
		
	}
	@Test
	public void testBurningShipETNeverExceedsED(){
		burningshipset neverExceedsED = new burningshipset();
	}
	@Test
	public void testBurningShipETIsNot0or1(){	//unique test for Burning Ship Set
		burningshipset etIsNot0or1 = new burningshipset();
	}
	@Test
	public void testBurningShipReturn(){
		burningshipset returns2DArray = new burningshipset();
	}
	
	//Multibrot Set Tests
	
	@Test
	public void testMultibrotXCoordinateTranslation(){	//this tests is the X-Coordinate Translation works
		MandelbrotSet xCoordTest = new multibrotSet();
		assertEquals("Product is -1.00", -1.00, xCoordTest.mandelbrotSet(0, 0), 0.0001);
	}
	@Test
	public void testMultibrotYCoordinateTranslation(){
		MandelbrotSet yCoordTest = new multibrotSet();
		assertEquals("Product is -1.3", -1.3, yCoordTest.mandelbrotSet(0, 0), 0.0001);
	}
	@Test
	public void testMultibrotETNeverExceedsED(){
		MandelbrotSet neverExceedsED = new multibrotSet();
		assertEquals("Product is 255.", 255, neverExceedsED.mandelbrotSet(0.5859375, 0.24375000000000108), 0.0001);
	}
	@Test
	public void testMultibrotETExceedsED(){
		MandelbrotSet etExceedsED = new multibrotSet();
		assertEquals("Product is 1.", 1 ,etExceedsED.mandelbrotSet(0.9921875, 1.05625), 0.0001);
	}
	@Test
	public void testMultibrotReturn(){
		MandelbrotSet returns2DArray = new multibrotSet();
	}
}
