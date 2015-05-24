package com.unknownpotato.dungeon.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.unknownpotato.dungeon.Level;

/**
 * 
 * @author VoxWave
 *
 */
public class PNGExporter {
	
	/**
	 * creates a png image of the level
	 * <p>
	 * In the png each pixel represents a tile with different colors representing different tiletypes.
	 * @param level
	 * @param filename
	 */
	public void export(Level level, String filename) {
		int[] ints = new int[level.getWidth()*level.getHeight()];
		for(int y = 0; y<level.getHeight(); y++) {
			for(int x = 0; x<level.getWidth(); x++) {
				ints[y*level.getHeight() + x] = level.getTile(x, y).getColor().getRGB();
			}
		}
		BufferedImage image = new BufferedImage(level.getWidth(), level.getHeight(), BufferedImage.TYPE_INT_RGB);
		image.setRGB(0, 0, level.getWidth(), level.getHeight(), ints, 0, level.getHeight());
		try {
			ImageIO.write(image, "png", new File(filename + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
