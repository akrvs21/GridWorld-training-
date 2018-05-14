import imagereader.IImageIO;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BMPImageIO implements IImageIO
{
    // transparency
    private static final int ALPHA = 0xFF << 24;
    // size of file header
    private static final int F_HEADER_SIZE = 14;
    // size of DIB header
    private static final int DIB_HEADER_SIZE = 40;
    // default bit per pixel
    private static final int DEFAULT_BPP = 24;
    // count of red, green, blue = 3
    private static final int RGB_COUNT = 3;
    // 4 bytes
    private static final int FOUR_BYTES = 4;
    // 2 bytes
    private static final int TWO_BYTES = 2;
    // offset of size in fileHeader
    private static final int SIZE_OFFSET = 2;
    // offset of width in DIB header
    private static final int WIDTH_OFFSET = 4;
    // offset of height in DIB header
    private static final int HEIGHT_OFFSET = 8;
    // offset of bits per pixel in DIB header
    private static final int BPP_OFFSET = 14;

    public Image myRead(String filepath) throws IOException
    {
        BufferedInputStream inputStream = new BufferedInputStream(
                new FileInputStream(filepath));

         
        byte[] FileH = new byte[F_HEADER_SIZE]; // first 14 bytes
        inputStream.read(FileH, 0, F_HEADER_SIZE);
        int size = readBytes(FileH, SIZE_OFFSET, FOUR_BYTES);

        byte[] DHeader = new byte[DIB_HEADER_SIZE];// next 40 bytes
        inputStream.read(DHeader, 0, DIB_HEADER_SIZE);

        int width = readBytes(DHeader, WIDTH_OFFSET, FOUR_BYTES);
        int height = readBytes(DHeader, HEIGHT_OFFSET, FOUR_BYTES);

       
        int Bpxs = readBytes(DHeader, BPP_OFFSET, TWO_BYTES);

        if (Bpxs == DEFAULT_BPP)
        {
            int pdg = (size / height) - width * RGB_COUNT;

            // pixels of the file
            int[] pixel = new int[height * width];
            byte[] rgb = new byte[size];
            inputStream.read(rgb, 0, size);

            int n = 0;
            for (int i = height - 1; i >= 0; i--)
            {
                for (int j = 0; j < width; j++)
                {
                    // the rgb for each pixel is each 3 bytes | alpha
                	pixel[i * width + j] = ALPHA
                            | readBytes(rgb, n, RGB_COUNT);
                    n += RGB_COUNT;
                }
                n += pdg;
            }

            inputStream.close();
            return Toolkit.getDefaultToolkit().createImage(
                    new MemoryImageSource(width, height, pixel, 0, width));
        }
        else
        {
            inputStream.close();
            throw new IOException("Bits per pixel is not 24");
        }
    }

    /**
     * @param image
     *            the image to be written
     * @param filename
     *            the file name of the output image
     */
  
    public Image myWrite(Image image, String fileName) throws IOException
    {
        BufferedImage bufferedImage = toBufferedImage(image);
        ImageIO.write(bufferedImage, "bmp", new File(fileName));
        return image;
    }

    /**
     * Read in given number of bytes, from given offset in the byte array,
     * convert it to int, then return the integer.
     *
     * @param buffer
     *            the byte array as the data source.
     * @param offset
     *            where the reading starts
     * @param size
     *            number of bytes to read
     * @return the converted integer
     */
    private int readBytes(byte[] buffer, int offset, int size)
    {
        int result = 0;
        for (int i = 0; i < size; ++i)
        {
            result |= (buffer[offset + i] & 0x00FF) << i * 8;
        }

        return result;
    }

    /**
     * Converts a given Image into a BufferedImage
     *
     * @param img
     *            The Image to be converted
     * @return The converted BufferedImage
     */
    private static BufferedImage toBufferedImage(Image img)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(
                img.getWidth(null),
                img.getHeight(null),
                BufferedImage.TYPE_INT_RGB);

        
        Graphics bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        
        return bimage;
    }
}