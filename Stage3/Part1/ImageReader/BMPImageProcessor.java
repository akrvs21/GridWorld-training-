import imagereader.IImageProcessor;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;

/*@author Sadi*/

public class BMPImageProcessor implements IImageProcessor
{
	/**
     * Get the green channel image.
     *
     * @param sourceImage
     *            the source image.
     */
    @Override
    public Image showChanelG(Image sourceImage)
    {
        return Toolkit.getDefaultToolkit().createImage(
                new FilteredImageSource(
                        sourceImage.getSource(),
                        new ChannelFilter(ChannelFilter.RED)));
    }

    /**
     * Get the gray scale image.
     *
     * @param sourceImage
     *            the source image.
     */
    
    public Image showGray(Image sourceImage)
    {
        return Toolkit.getDefaultToolkit().createImage(
                new FilteredImageSource(
                        sourceImage.getSource(),
                        new GrayFilter()));
    }
    /**
     * Get the blue channel image.
     *
     * @param sourceImage
     *            the source image.
     */
    @Override
    public Image showChanelB(Image sourceImage)
    {
        return Toolkit.getDefaultToolkit().createImage(
                new FilteredImageSource(
                        sourceImage.getSource(),
                        new ChannelFilter(ChannelFilter.BLUE)));
    }

    /**
     * Get the red channel image.
     *
     * @param sourceImage
     *            the source image.
     */

    public Image showChanelR(Image sourceImage)
    {
        return Toolkit.getDefaultToolkit().createImage(
                new FilteredImageSource(
                        sourceImage.getSource(),
                        new ChannelFilter(ChannelFilter.RED)));
    }


}

/**
 * The filter class for obtaining channel images.*/
class ChannelFilter extends RGBImageFilter
{
    // the color mask
    private int mask;
    public static final int RED = 0xFFFF0000;
    public static final int GREEN = 0xFF00FF00;
    public static final int BLUE = 0xFF0000FF;

    /**
     * Construct a channel filter with given mask.
     *
     * @param mask
     *            mask for each pixel.
     */
    
    public ChannelFilter(int mask)
    {
        this.mask = mask;
        canFilterIndexColorModel = true;
    }
    /**
     * Convert a single input pixel in the default RGB
     * ColorModel to a filtered pixel.
     *
     * @param x
     *            the X coordinate of the pixel
     * @param y
     *            the Y coordinate of the pixel
     * @param rgb
     *            the integer pixel representation in the default RGB color
     *            model
     * @return a filtered pixel in the default RGB color model.
     */
    
    public int filterRGB(int x, int y, int rgb)
    {
        return rgb & mask;
    }
}

/**
 * The filter class for obtaining gray scale images.*/
class GrayFilter extends RGBImageFilter
{
    // masks to extract each channel
    private static final int RED_ONLY_MASK = 0x00FF0000;
    private static final int GREEN_ONLY_MASK = 0x0000FF00;
    private static final int BLUE_ONLY_MASK = 0x000000FF;
    // weight for each channel to get gray scale
    private static final double RED_WEIGHT = 0.299;
    private static final double GREEN_WEIGHT = 0.587;
    private static final double BLUE_WEIGHT = 0.114;

    /**
     * Construct a gray scale filter with given mask.
     *
     * @param mask
     *            mask for each pixel.
     */
    public GrayFilter()
    {
        // From Java API ---
        // The filter's operation does not depend on the
        // pixel's location, so IndexColorModels can be
        // filtered directly.
        canFilterIndexColorModel = true;
    }

    /**
     * Convert a single input pixel in the default RGB
     * ColorModel to a gray scale pixel.
     *
     * @param x
     *            the X coordinate of the pixel
     * @param y
     *            the Y coordinate of the pixel
     * @param rgb
     *            the integer pixel representation in the default RGB color
     *            model
     * @return a gray scale pixel in the default RGB color model.
     */

    public int filterRGB(int x, int y, int rgb)
    {
        int r = (RED_ONLY_MASK & rgb) >> 16;
        int g = (GREEN_ONLY_MASK & rgb) >> 8;
        int b = BLUE_ONLY_MASK & rgb;
        int Gr = (int) (r * RED_WEIGHT
                + g * GREEN_WEIGHT
                + b * BLUE_WEIGHT);
        return (rgb & 0xFF000000) | (Gr << 16) | (Gr << 8) | Gr;
    }
}