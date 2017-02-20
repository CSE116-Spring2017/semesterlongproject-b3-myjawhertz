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
		assertEquals("X cordinate is -2.15", -2.15, xCoordTest.getXCord(0), 0.00001);
	}
	@Test
	public void testMandelbrotYCoordinateTranslation(){
		MandelbrotSet yCoordTest = new MandelbrotSet();
		assertEquals("Y cordinate is -1.3", -1.3, yCoordTest.getYCord(0), 0.0001);
	}
	
	@Test
	public void testMandelbrotETNeverExceedsED(){
		MandelbrotSet neverExceedsED = new MandelbrotSet();
		assertEquals("Product is 255.", 255, neverExceedsED.mandelbrotSet(0.3207031250000001, -0.07109374999999386), 0.0001);
	}
	@Test
	public void testMandelbrotETExceedsED(){
		MandelbrotSet etExceedsED = new MandelbrotSet();
		assertEquals("Product is 1.", 1,etExceedsED.mandelbrotSet(0.5946289062500001, 1.2949218750000122), 0.0001);
	}
	@Test
	public void testMandelbrotReturn(){
		MandelbrotSet returns2DArray = new MandelbrotSet();
	}
	
	//Julia Set Testss
	
	@Test
	public void testJuliaXCoordinateTranslation(){	//name of class: JuliaSet
		JuliaSet xCoordTest = new JuliaSet();
		assertEquals("X cordinate is -1.7", -1.7, xCoordTest.METHODNAME(0), 0.00001);
		
	}
	@Test
	public void testJuliaYCoordinateTranslation(){
		JuliaSet yCoordTest = new JuliaSet();
		assertEquals("Y cordinate is -1.0", -1.0, yCoordTest.METHODNAME(0), 0.0001);
	}
	@Test
	public void testJuliaETNeverExceedsED(){
		JuliaSet neverExceedsED = new JuliaSet();
		assertEquals("Product is 255.", 255, neverExceedsED.JuliaSet(1.0492187499999897, -0.234375), 0.0001);
	}
	@Test
	public void testJuliaETExceedsED(){
		JuliaSet etExceedsED = new JuliaSet();
		assertEquals("Product is 1.", 1,etExceedsED.JuliaSet(1.6933593749999853, 0.9765625), 0.0001);
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
		assertEquals("Product is 255.", 255, neverExceedsED.Burningshipset(0.3207031250000001, -0.07109374999999386), 0.0001);
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
	public void testMultibrotXCoordinateTranslation() {
		multibrotSet xCoordTest = new multibrotSet();
	}
	public void testMultibrotYCoordinateTranslation() {
		multibrotSet yCoordTest = new multibrotSet();
	}
	public void testMultibrotETNeverExceedsED() {
		multibrotSet neverExceedsED = new multibrotSet();
	}
	public void testMultibrotETExceedsED() {
		multibrotSet etExceedsED = new multibrotSet();
	}
	public void testMultibrotReturn() {
		multibrotSet returns2DArray = new multibrotSet();
	}
}
