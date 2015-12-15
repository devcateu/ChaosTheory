package pl.chaos.theory.dto.mapper;

import org.springframework.stereotype.Component;
import pl.chaos.theory.db.model.User;
import pl.chaos.theory.dto.model.UserDto;

@Component
public class UserMapper {
	public UserDto toDto(User user) {
		UserDto dto = new UserDto();
		dto.setEmail(user.getEmail());
		dto.setId(user.getId());
		dto.setRole(user.getRole());
		return dto;
	}
}
