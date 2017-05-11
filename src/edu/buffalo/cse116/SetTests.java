package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class provides the JUnit tests that will be used to make sure that each
 * fractal set's translations and Escape-Time Calculations are working properly.
 * 
 * @author Alec Otminski
 *
 */

public class SetTests {
	/**
	 * Mandelbrot Set Tests
	 */

	// Translate a pixel's row to the associated x-coordinate in the fractal
	@Test
	public void testMandelbrotXCoordinateTranslation() {
		MandelbrotSet xCoordTest = new MandelbrotSet();
		assertEquals("X cordinate is -2.15", -2.15, xCoordTest.getXCordRect(0, 0, 0), 0.00001);
	}

	// Translate a pixel's column to the associated y-coordinate in the fractal
	@Test
	public void testMandelbrotYCoordinateTranslation() {
		MandelbrotSet yCoordTest = new MandelbrotSet();
		assertEquals("Y cordinate is -1.3", -1.3, yCoordTest.getYCordRect(0, 0, 0), 0.0001);
	}

	// Calculates the escape time for a coordinate whose distance from the
	// origin never exceeds the escape distance
	@Test
	public void testMandelbrotETNeverExceedsED() {
		MandelbrotSet neverExceedsED = new MandelbrotSet();
		assertEquals("Excape time is 255.", 255,
				neverExceedsED.holder(0.3207031250000001, -0.07109374999999386, 255, 2));
	}

	// Calculates the escape time for a coordinate whose distance from the
	// origin exceeds the escape distance after a single loop pass
	@Test
	public void testMandelbrotETExceedsED() {
		MandelbrotSet etExceedsED = new MandelbrotSet();
		assertEquals("Excape time is 1.", 1, etExceedsED.holder(0.5946289062500001, 1.2949218750000122, 255, 2));
	}

	// The method called to calculate the fractal returns a 2-d array with 512
	// rows and 512 columns
	@Test
	public void testMandelbrotReturn() {
		MandelbrotSet returns2DArray = new MandelbrotSet();
		assertEquals("2D 2048 by 2048 array", 2048,
				returns2DArray.rectangle("255", "2", 0, 0, 2047, 2047, 0, 2047).length);
		assertEquals("2D 2048 by 2048 array", 2048,
				returns2DArray.rectangle("255", "2", 0, 0, 2047, 2047, 0, 2047)[0].length);
	}

	/**
	 * Julia Set Tests
	 */

	// Translate a pixel's row to the associated x-coordinate in the fractal
	@Test
	public void testJuliaXCoordinateTranslation() { // name of class: JuliaSet
		JuliaSet xCoordTest = new JuliaSet();
		assertEquals("X cordinate is -1.7", -1.7, xCoordTest.getXCordRect(0, 0, 0), 0.00001);

	}

	// Translate a pixel's column to the associated y-coordinate in the fractal
	@Test
	public void testJuliaYCoordinateTranslation() {
		JuliaSet yCoordTest = new JuliaSet();
		assertEquals("Y cordinate is -1.0", -1.0, yCoordTest.getYCordRect(0, 0, 0), 0.0001);
	}

	// Calculates the escape time for a coordinate whose distance from the
	// origin never exceeds the escape distance
	@Test
	public void testJuliaETNeverExceedsED() {
		JuliaSet neverExceedsED = new JuliaSet();
		assertEquals("Escape time 255.", 255, neverExceedsED.juliaRealPasses(1.0492187499999897, -0.234375, 255, 2),
				0.0001);
	}

	// Calculates the escape time for a coordinate whose distance from the
	// origin exceeds the escape distance after a single loop pass
	@Test
	public void testJuliaETExceedsED() {
		JuliaSet etExceedsED = new JuliaSet();
		assertEquals("Escape time 1.", 1, etExceedsED.juliaRealPasses(1.6933593749999853, 0.9765625, 255, 2), 0.0001);
	}

	/**
	 * Burning Ship Set Tests
	 */

	// Translate a pixel's row to the associated x-coordinate in the fractal
	@Test
	public void testBurningShipXCoordinateTranslation() { // name of class:
															// burningshipset
		burningshipset xCoordTest = new burningshipset();
		assertEquals("X cordinate is -1.8", -1.8, xCoordTest.getXCordRect(0, 0, 0), 0.00001);
	}

	// Translate a pixel's column to the associated x-coordinate in the fractal
	@Test
	public void testBurningShipYCoordinateTranslation() {
		burningshipset yCoordTest = new burningshipset();
		assertEquals("X cordinate is -0.08", -0.08, yCoordTest.getYCordRect(0, 0, 0), 0.00001);
	}

	// Calculates the escape time for a coordinate whose distance from the
	// origin never exceeds the escape distance
	@Test
	public void testBurningShipETNeverExceedsED() {
		burningshipset neverExceedsED = new burningshipset();
		assertEquals("Excape time 255.", 255,
				neverExceedsED.burningshipRealPasses(-1.7443359374999874, -0.017451171875000338, 255, 2));

	}

	// Calculates that none of the pixels in the Burning Ship set have an escape
	// time of 0 or 1
	@Test
	public void testBurningShipETIsNot0or1() {
		burningshipset etIsNot0or1 = new burningshipset();
		assertTrue("Escape time is never 0 or 1", etIsNot0or1.OnlyOneOrZero());
	}

	// The method called to calculate the fractal returns a 2-d array with 512
	// rows and 512 columns
	@Test
	public void testBurningShipReturn() {
		burningshipset returns2DArray = new burningshipset();
		assertEquals("2D 2048 by 2048 array", 2048,
				returns2DArray.rectangle("255", "2", 0, 0, 2047, 2047, 0, 2047).length);
		assertEquals("2D 2048 by 2048 array", 2048,
				returns2DArray.rectangle("255", "2", 0, 0, 2047, 2047, 0, 2047)[0].length);
	}

	/**
	 * Multibrot Set Tests
	 */

	// Translate a pixel's row to the associated x-coordinate in the fractal
	@Test
	public void testMultibrotXCoordinateTranslation() {
		multibrotSet xCoordTest = new multibrotSet();
		assertEquals("X cordinate is -1", -1, xCoordTest.getXCordRect(0, 0, 0), 0.00001);
	}

	// Translate a pixel's column to the associated x-coordinate in the fractal
	@Test
	public void testMultibrotYCoordinateTranslation() {
		multibrotSet yCoordTest = new multibrotSet();
		assertEquals("X cordinate is -1.3", -1.3, yCoordTest.getYCordRect(0, 0, 0), 0.00001);
	}

	// Calculates the escape time for a coordinate whose distance from the
	// origin never exceeds the escape distance
	@Test
	public void testMultibrotETNeverExceedsED() {
		multibrotSet neverExceedsED = new multibrotSet(); // 0.5859375 ,
															// 0.24375000000000108
		assertEquals("Excape time 255.", 255,
				neverExceedsED.multibrotRealPasses(0.5859375, 0.24375000000000108, 255, 2), 0.0001);
	}

	// Calculates the escape time for a coordinate whose distance from the
	// origin exceeds the escape distance after a single loop pass
	@Test
	public void testMultibrotETExceedsED() {
		multibrotSet etExceedsED = new multibrotSet();
		assertEquals("Excape time 1.", 1, etExceedsED.multibrotRealPasses(0.9921875, 1.05625, 255, 2), 0.0001);
	}

	// The method called to calculate the fractal returns a 2-d array with 512
	// rows and 512 columns

	@Test
	public void testMultibrotReturn() {
		multibrotSet returns2DArray = new multibrotSet();
		assertEquals("2D 2048 by 2048 array", 2048,
				returns2DArray.rectangle("255", "2", 0.0, 0.0, 2047, 2047, 0, 2047).length);
		assertEquals("2D 2048 by 2048 array", 2048,
				returns2DArray.rectangle("255", "2", 0.0, 0.0, 2047, 2047, 0, 2047)[0].length);
	}

	/**
	 * Phase 2 Rubric
	 */
	// When the escape distance is set to 3, calculates the escape time for a
	// coordinate whose distance from the origin exceeds the escape distance
	// after a 10 passes of the loop
	@Test
	public void testMandelbrotsetCalEsTime() {
		MandelbrotSet mandelbrotset = new MandelbrotSet();
		assertEquals(10, mandelbrotset.holder(0.46007827788650374, -0.3383561643835661, 255, 2), 0.0001);
	}

	// When the escape distance is set to 3, calculates the escape time for a
	// coordinate whose distance from the origin exceeds the escape distance
	// after a 10 passes of the loop
	@Test
	public void testJuliasetCalEsTime() {
		JuliaSet juliaset = new JuliaSet();
		assertEquals(10, juliaset.juliaRealPasses(1.4538160469667272, -0.13502935420743645, 255, 2), 0.0001);
	}

	// When the escape distance is set to 3, calculates the escape time for a
	// coordinate whose distance from the origin exceeds the escape distance
	// after a 10 passes of the loop
	@Test
	public void testBurningshipsetCalEsTime() {
		burningshipset burningshipset = new burningshipset();
		assertEquals(10, burningshipset.burningshipRealPasses(-1.6999999999999802, 0.0030136986301371603, 225 , 3), 0.0001);
	}

	// When the escape distance is set to 3, calculates the escape time for a
	// coordinate whose distance from the origin exceeds the escape distance
	// after a 10 passes of the loop
	@Test
	public void testMultibrotsetCalEsTime() {
		multibrotSet multibrotset = new multibrotSet();
		assertEquals(10, multibrotset.multibrotRealPasses(0.7025440313111545, -0.5520547945205528, 255, 3), 0.0001);
	}

	/**
	 * Phase 3 Rubric Tests
	 */

	// When the escape distance is set to 2, calculates the escape time for a
	// coordinate whose distance from the origin exceeds the escape distance
	// after 135 passes of a loop
	@Test
	public void testMandelbrotET135ED2() {
		MandelbrotSet mandelbrotset = new MandelbrotSet();
		assertEquals("Escape time is 135.", 135, mandelbrotset.holder(0.3207031250000001, -0.07109374999999386, 135, 2),
				0.0001);
	}

	// When the escape distance is set to 2, calculates the escape time for a
	// coordinate whose distance from the origin exceeds the escape distance
	// after 135 passes of a loop
	@Test
	public void testJuliaET135ED2() {
		JuliaSet juliaset = new JuliaSet();
		assertEquals("Escape time is 135.", 135, juliaset.juliaRealPasses(1.0492187499999897, -0.234375, 135, 2),
				0.0001);
	}

	// When the escape distance is set to 2, calculates the escape time for a
	// coordinate whose distance from the origin exceeds the escape distance
	// after 135 passes of a loop
	@Test
	public void testBurningShipET135ED2() {
		burningshipset BurningShipSet = new burningshipset();
		assertEquals("Escape time is 135.", 135, BurningShipSet.burningshipRealPasses(-1.7443359374999874, -0.017451171875000338 , 135,2), 0.0001);
	}

	// When the escape distance is set to 2, calculates the escape time for a
	// coordinate whose distance from the origin exceeds the escape distance
	// after 135 passes of a loop
	@Test
	public void testMultibrotET135ED2() {
		multibrotSet multibrotset = new multibrotSet();
		assertEquals("Escape time is 135.", 135,
				multibrotset.multibrotRealPasses(0.5859375, 0.24375000000000108, 135, 2), 0.0001);
	}
}
