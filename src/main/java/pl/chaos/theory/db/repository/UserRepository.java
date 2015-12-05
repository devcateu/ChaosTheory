package pl.chaos.theory.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.chaos.theory.db.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findOneByEmail(String email);
}
