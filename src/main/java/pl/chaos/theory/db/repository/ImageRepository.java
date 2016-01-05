package pl.chaos.theory.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.chaos.theory.db.model.Image;

/**
 * Allow download from and put data to DB for Image model .
 */
public interface ImageRepository extends JpaRepository<Image, Long> {
}
