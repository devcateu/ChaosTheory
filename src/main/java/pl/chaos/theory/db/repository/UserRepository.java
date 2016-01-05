package pl.chaos.theory.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.chaos.theory.db.model.User;

/**
 * Allow download from and put data to DB for User model .
 */
public interface UserRepository extends JpaRepository<User, Long> {
	User findOneByEmail(String email);
}
