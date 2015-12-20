package pl.chaos.theory.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.chaos.theory.db.model.AlgorithmResult;

import java.util.List;

public interface AlgorithmResultRepository extends JpaRepository<AlgorithmResult, Long> {
	List<AlgorithmResult> findAllByUserId(Long userId);
}
