package edu.buffalo.cse116;

import java.awt.Color;
import java.awt.image.IndexColorModel;

/**
 * This class contains the code necessary to build the color models for three
 * different sets of fractal coloring. Each factory method takes in the number
 * of color required and build the appropriate IndexColorModel object.
 * 
 * @author Matthew Hertz
 *
 */
public class ColorModel {

  /**
   * Create a color model that contains the colors of the rainbow. This is the
   * model to which FractalPanel defaults and the one used to create the demo
   * images from phase #1. The number of colors included in the model is set by
   * the parameter. This should be 1 more than the maximum number of steps for
   * the fractal.
   * 
   * @param numColors
   *          Number of different color shades to use.
   * @return Color model that shows a selection of colors chosen because Prof.
   *         Hertz finds the combination pretty.
   */
  public static IndexColorModel createRainbowColorModel(int numColors) {
    byte[] reds = new byte[numColors];
    byte[] greens = new byte[numColors];
    byte[] blues = new byte[numColors];
    for (int i = 0; i < reds.length - 1; i++) {
      int rgb = Color.HSBtoRGB(i / ((float) reds.length - 1), 0.6F, 1);
      reds[i] = (byte) ((rgb & 0xFF0000) >> 16);
      greens[i] = (byte) ((rgb & 0xFF00) >> 8);
      blues[i] = (byte) (rgb & 0xFF);
    }
    IndexColorModel retVal = new IndexColorModel(8, reds.length, reds, greens, blues);
    return retVal;
  }

  /**
   * Create a color model that contains different shades of blue. The number of
   * colors included in the model is set by the parameter. This should be 1 more
   * than the maximum number of steps for the fractal.
   * 
   * @param numColors
   *          Number of different color shades to use.
   * @return Color model that shows all of the different possible shades of
   *         blue.
   */
  public static IndexColorModel createBluesColorModel(int numColors) {
    byte[] reds = new byte[numColors];
    byte[] greens = new byte[numColors];
    byte[] blues = new byte[numColors];
    for (int i = 0; i < reds.length - 1; i++) {
      blues[i] = (byte) ((Math.log10(i) / Math.log10(blues.length)) * 256);
      greens[i] = 0;
      reds[i] = 0;
    }
    IndexColorModel retVal = new IndexColorModel(8, reds.length, reds, greens, blues);
    return retVal;
  }

  /**
   * Create a color model that contains different shades of gray. The number of
   * colors included in the model is set by the parameter. This should be 1 more
   * than the maximum number of steps for the fractal.
   * 
   * @param numColors
   *          Number of different color shades to use.
   * @return Color model that shows all of the different possible shades of gray
   *         from pure black to pure white.
   */
  public static IndexColorModel createGrayColorModel(int numColors) {
    byte[] reds = new byte[numColors];
    byte[] greens = new byte[numColors];
    byte[] blues = new byte[numColors];
    for (int i = 0; i < reds.length - 1; i++) {
      reds[i] = (byte) ((Math.log10(i) / Math.log10(reds.length)) * 256);
      greens[i] = reds[i];
      blues[i] = reds[i];
    }
    IndexColorModel retVal = new IndexColorModel(8, reds.length, reds, greens, blues);
    return retVal;
  }
  
  public static IndexColorModel createCrazyGoodColor(int numColors) {
	    byte[] reds = new byte[numColors];
	    byte[] greens = new byte[numColors];
	    byte[] blues = new byte[numColors];
	    for (int i = 0; i < reds.length - 1; i++) {
	      reds[i] = (byte) ((Math.log10(i) / Math.log10(reds.length)) * 256);
	      greens[i] = (byte) ((Math.log10(i) / Math.log10(greens.length)) * 256);
	      blues[i] = (byte) ((Math.log10(i) / Math.log10(blues.length)) * 256);
	    } 
	    IndexColorModel retVal = new IndexColorModel(8, reds.length, reds, greens, blues);
	    return retVal;
	  }
}