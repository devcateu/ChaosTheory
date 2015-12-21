package pl.chaos.theory.dto.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.chaos.theory.BaseSpringTest;
import pl.chaos.theory.db.model.User;
import pl.chaos.theory.dto.model.UserDto;
import pl.chaos.theory.security.Role;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMapperTest extends BaseSpringTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testMapAtoB() {
		User user = new User();
		user.setEmail("mail");
		user.setRole(Role.USER);
		user.setLocked(true);
		user.setId(11L);

		UserDto userDto = userMapper.mapAtoB(user);

		assertThat(userDto.getRole()).isEqualTo(user.getRole());
		assertThat(userDto.getEmail()).isEqualTo(user.getEmail());
		assertThat(userDto.isLocked()).isEqualTo(user.isLocked());
		assertThat(userDto.getId()).isEqualTo(user.getId());
	}

	@Test
	public void testMapBtoA() {
		UserDto userDto = new UserDto();
		userDto.setEmail("mail");
		userDto.setRole(Role.USER);
		userDto.setLocked(true);
		userDto.setId(11L);

		User user = userMapper.mapBtoA(userDto);

		assertThat(user.getRole()).isEqualTo(userDto.getRole());
		assertThat(user.getEmail()).isEqualTo(userDto.getEmail());
		assertThat(user.isLocked()).isEqualTo(userDto.isLocked());
		assertThat(user.getId()).isEqualTo(userDto.getId());
	}

}