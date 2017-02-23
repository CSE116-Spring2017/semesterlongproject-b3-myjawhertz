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
		assertEquals("Excape time is 255.", 255, neverExceedsED.mandelbrotSet(0.3207031250000001, -0.07109374999999386));
	}
	@Test
	public void testMandelbrotETExceedsED(){
		MandelbrotSet etExceedsED = new MandelbrotSet();
		assertEquals("Excape time is 1.", 1,etExceedsED.mandelbrotSet(0.5946289062500001, 1.2949218750000122));
	}
	@Test
	public void testMandelbrotReturn(){
		MandelbrotSet returns2DArray = new MandelbrotSet();
		assertEquals("2D 512 by 512 array", new int[512][512], returns2DArray.returnArray());
	}
	
	//Julia Set Testss
	
	@Test
	public void testJuliaXCoordinateTranslation(){	//name of class: JuliaSet
		JuliaSet xCoordTest = new JuliaSet();
		assertEquals("X cordinate is -1.7", -1.7, xCoordTest.xCoord(0), 0.00001);
		
	}
	@Test
	public void testJuliaYCoordinateTranslation(){
		JuliaSet yCoordTest = new JuliaSet();
		assertEquals("Y cordinate is -1.0", -1.0, yCoordTest.yCoord(0), 0.0001);
	}
	@Test
	public void testJuliaETNeverExceedsED(){
		JuliaSet neverExceedsED = new JuliaSet();
		assertEquals("Excape time 255.", 255, neverExceedsED.JuliaSet(1.0492187499999897, -0.234375), 0.0001);
	}
	@Test
	public void testJuliaETExceedsED(){
		JuliaSet etExceedsED = new JuliaSet();
		assertEquals("Excape time 1.", 1,etExceedsED.JuliaSet(1.6933593749999853, 0.9765625), 0.0001);
	}
	@Test
	public void testJuliaReturn(){
		JuliaSet returns2DArray = new JuliaSet();
		assertEquals("2D 512 by 512 array", new int[512][512], returns2DArray.canvaS());
	}
	
	//Burning Ship Set Tests
	
	@Test
	public void testBurningShipXCoordinateTranslation(){	//name of class: burningshipset
		burningshipset xCoordTest = new burningshipset();
		assertEquals("X cordinate is -1.8", -1.8, xCoordTest.xcor(0), 0.00001);
	}
	@Test
	public void testBurningShipYCoordinateTranslation(){
		burningshipset yCoordTest = new burningshipset();
		assertEquals("X cordinate is -0.08", -0.08, yCoordTest.ycor(0), 0.00001);
	}
	@Test
	public void testBurningShipETNeverExceedsED(){
		burningshipset neverExceedsED = new burningshipset();
		assertEquals("Excape time 255.", 255, neverExceedsED.passtester(-1.7443359374999874, -0.017451171875000338), 0.0001);
	}
	@Test
	public void testBurningShipETIsNot0or1(){	//unique test for Burning Ship Set
		burningshipset etIsNot0or1 = new burningshipset();
	//	assertEquals("Escape time is never 0 or 1", )
	}
	@Test
	public void testBurningShipReturn(){
		burningshipset returns2DArray = new burningshipset();
		assertEquals("2D 512 by 512 array", new int[512][512], returns2DArray.test());
	}
	
	//Multibrot Set Tests
	
	@Test
	public void testMultibrotXCoordinateTranslation() {
		multibrotSet xCoordTest = new multibrotSet();
		assertEquals("X cordinate is -1", -1, xCoordTest.XCoordTranslation(0), 0.00001);
	}
	@Test
	public void testMultibrotYCoordinateTranslation() {
		multibrotSet yCoordTest = new multibrotSet();
		assertEquals("X cordinate is -1.3", -1.3, yCoordTest.YCoordTranslation(0), 0.00001);
	}
	@Test
	public void testMultibrotETNeverExceedsED() {
		multibrotSet neverExceedsED = new multibrotSet();
		assertEquals("Excape time 255.", 255,neverExceedsED.mbSetETCalculation(0.5859375, 0.24375000000000108), 0.0001);
	}
	@Test
	public void testMultibrotETExceedsED() {
		multibrotSet etExceedsED = new multibrotSet();
		assertEquals("Excape time 1.", 1,etExceedsED.mbSetETCalculation(0.9921875, 1.05625), 0.0001);
	}
	@Test
	public void testMultibrotReturn() {
		multibrotSet returns2DArray = new multibrotSet();
		assertEquals("2D 512 by 512 array", new int[512][512], returns2DArray.return2DArray());
	}
}
