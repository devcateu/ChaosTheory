package pl.chaos.theory.db.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.chaos.theory.db.model.User;
import pl.chaos.theory.db.repository.UserRepository;
import pl.chaos.theory.db.service.UserService;
import pl.chaos.theory.dto.mapper.UserMapper;
import pl.chaos.theory.dto.model.PasswordDto;
import pl.chaos.theory.dto.model.UserDto;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private UserMapper userMapper;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	@Override
	public UserDto getUserById(long id) {
		return userMapper.toDto(userRepository.findOne(id));
	}

	@Override
	public UserDto getUserByEmail(String email) {
		return userMapper.toDto(userRepository.findOneByEmail(email));
	}

	@Override
	public UserDto create(PasswordDto passwordDto, UserDto userDto) {
		User user = new User();
		user.setRole(userDto.getRole());
		user.setEmail(userDto.getEmail());
		user.setId(userDto.getId());
		user.setPasswordHash(passwordDto.getPassword());
		user = userRepository.save(user);
		return userMapper.toDto(user);
	}

	@Override
	public String getHashedPassword(String email) {
		return userRepository.findOneByEmail(email).getEmail();
	}

	@Override
	public void changePassword(String newPassword, String email) {
		User user = userRepository.findOneByEmail(email);
		user.setPasswordHash(newPassword);
		userRepository.save(user);
	}
}
