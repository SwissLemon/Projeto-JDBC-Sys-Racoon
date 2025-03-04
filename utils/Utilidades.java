package utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Utilidades {
	public static byte[] convertImageToBytes(Image image) {
	    if (image == null) return null;
	    BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2d = bufferedImage.createGraphics();
	    g2d.drawImage(image, 0, 0, null);
	    g2d.dispose();

	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    try {
	        ImageIO.write(bufferedImage, "png", baos); 
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return baos.toByteArray();
	}
}