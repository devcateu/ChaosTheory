package pl.chaos.theory.dto.mapper;

import org.springframework.stereotype.Component;
import pl.chaos.theory.db.model.Image;
import pl.chaos.theory.dto.model.ImageDto;
import pl.chaos.theory.util.mapper.BaseMapper;

@Component
/**
 * Allow map object from Image into ImageDto and vice versa.
 */
public class ImageMapper extends BaseMapper<Image, ImageDto> {

	@Override
	public ImageDto mapAtoB(Image image) {
		ImageDto dto = new ImageDto();
		dto.setId(image.getId());
		return dto;
	}

	@Override
	public Image mapBtoA(ImageDto imageDto) {
		Image image = new Image();
		image.setId(imageDto.getId());
		return image;
	}
}
