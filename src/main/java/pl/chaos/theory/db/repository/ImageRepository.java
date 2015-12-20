package pl.chaos.theory.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.chaos.theory.db.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
