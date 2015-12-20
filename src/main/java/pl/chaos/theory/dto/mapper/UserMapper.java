package pl.chaos.theory.dto.mapper;

import org.springframework.stereotype.Component;
import pl.chaos.theory.db.model.User;
import pl.chaos.theory.dto.model.UserDto;
import pl.chaos.theory.util.mapper.BaseMapper;

@Component
public class UserMapper extends BaseMapper<User, UserDto> {

	@Override
	public UserDto mapAtoB(User user) {
		UserDto dto = new UserDto();
		dto.setEmail(user.getEmail());
		dto.setId(user.getId());
		dto.setRole(user.getRole());
		dto.setLocked(user.isLocked());
		return dto;
	}

	@Override
	public User mapBtoA(UserDto userDto) {
		User user = new User();
		user.setRole(userDto.getRole());
		user.setId(userDto.getId());
		user.setLocked(userDto.isLocked());
		user.setEmail(userDto.getEmail());
		return user;
	}
}
