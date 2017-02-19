package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

public class MandelbrotSetTest {

	@Test
	public void test03() {
		MandelbrotSet ms = new MandelbrotSet();
		assertEquals("time for a coordinate whose distance from the origin never exceeds the escape distance", 255, ms.mandelbrotSet(0.3207031250000001, -0.07109374999999386), .0001);
	}
	@Test
	public void test04() {
		MandelbrotSet ms = new MandelbrotSet();
		assertEquals("time for a coordinate whose distance after from the origin exceeds the escape distance after a single loop pass",1, ms.mandelbrotSet(0.5946289062500001, 1.2949218750000122), .0001);
	}

}
