package pl.chaos.theory.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.chaos.theory.db.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
