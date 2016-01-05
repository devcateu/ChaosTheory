package pl.chaos.theory.db.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.chaos.theory.db.model.User;
import pl.chaos.theory.db.repository.UserRepository;
import pl.chaos.theory.db.service.UserService;
import pl.chaos.theory.dto.model.UserDto;
import pl.chaos.theory.util.mapper.Mapper;

import java.util.Collection;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Mapper mapper;

	@Override
	public UserDto getUserById(long id) {
		return mapper.map(userRepository.findOne(id), UserDto.class);
	}

	@Override
	public UserDto getUserByEmail(String email) {
		User oneByEmail = userRepository.findOneByEmail(email);
		return mapper.map(oneByEmail, UserDto.class);
	}

	@Override
	public UserDto create(UserDto userDto, String password) {
		User user = mapper.map(userDto, User.class);
		user.setPasswordHash(password);
		user = userRepository.save(user);
		return mapper.map(user, UserDto.class);
	}

	@Override
	public String getHashedPassword(String email) {
		return userRepository.findOneByEmail(email).getPasswordHash();
	}

	@Override
	public void changePassword(String newPassword, String email) {
		User user = userRepository.findOneByEmail(email);
		user.setPasswordHash(newPassword);
		userRepository.save(user);
	}

	@Override
	public Collection<UserDto> getAll() {
		return mapper.mapCollection(userRepository.findAll(), UserDto.class);
	}

	@Override
	public void updateRole(UserDto userDto) {
		User user = userRepository.findOneByEmail(userDto.getEmail());
		user.setRole(userDto.getRole());
		userRepository.save(user);
	}
}
