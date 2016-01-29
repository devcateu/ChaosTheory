package pl.chaos.theory.dto.model;

import java.awt.image.BufferedImage;

/**
 * Dto represent Image with all needed parameters
 */
public class ImageDto extends Dto {
	private BufferedImage image;

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
}
