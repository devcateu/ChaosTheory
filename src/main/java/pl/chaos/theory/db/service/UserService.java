package pl.chaos.theory.db.service;

import pl.chaos.theory.db.model.User;

public interface UserService {

	User getUserById(long id);

	User getUserByEmail(String email);

	//User create(UserCreateForm form);
}
