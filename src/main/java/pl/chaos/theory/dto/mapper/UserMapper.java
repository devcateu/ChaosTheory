package pl.chaos.theory.dto.mapper;

import org.springframework.stereotype.Component;
import pl.chaos.theory.db.model.User;
import pl.chaos.theory.dto.model.UserDto;
import pl.chaos.theory.util.mapper.BaseMapper;

@Component
/**
 * Allow map object from User into UserDto and vice versa.
 */
public class UserMapper extends BaseMapper<User, UserDto> {

	@Override
	public UserDto mapAtoB(User user) {
		UserDto dto = new UserDto();
		dto.setEmail(user.getEmail());
		dto.setId(user.getId());
		dto.setRole(user.getRole());
		return dto;
	}

	@Override
	public User mapBtoA(UserDto userDto) {
		User user = new User();
		user.setRole(userDto.getRole());
		user.setId(userDto.getId());
		user.setEmail(userDto.getEmail());
		return user;
	}
}
