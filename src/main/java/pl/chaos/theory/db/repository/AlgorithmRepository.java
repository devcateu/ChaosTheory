package pl.chaos.theory.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.chaos.theory.db.model.Algorithm;

public interface AlgorithmRepository extends JpaRepository<Algorithm, Long> {
}
