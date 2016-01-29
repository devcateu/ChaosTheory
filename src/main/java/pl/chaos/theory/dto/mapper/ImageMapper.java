package pl.chaos.theory.dto.mapper;

import org.springframework.stereotype.Component;
import pl.chaos.theory.db.model.Image;
import pl.chaos.theory.dto.model.ImageDto;
import pl.chaos.theory.util.mapper.BaseMapper;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
/**
 * Allow map object from Image into ImageDto and vice versa.
 */
public class ImageMapper extends BaseMapper<Image, ImageDto> {

	@Override
	public ImageDto mapAtoB(Image image) {
		ImageDto dto = new ImageDto();
		dto.setId(image.getId());

		InputStream in = new ByteArrayInputStream(image.getImageBytes());
		try {
			dto.setImage(ImageIO.read(in));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public Image mapBtoA(ImageDto imageDto) {
		Image image = new Image();
		image.setId(imageDto.getId());

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ImageIO.write(imageDto.getImage(), "PNG" /* for instance */, out);
			image.setImageBytes(out.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}
