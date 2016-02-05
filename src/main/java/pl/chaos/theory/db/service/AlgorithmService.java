package pl.chaos.theory.db.service;

import pl.chaos.theory.algorithm.AlgorithmType;
import pl.chaos.theory.dto.model.AlgorithmResultDto;
import pl.chaos.theory.dto.model.ImageDto;

import java.util.Collection;
import java.util.Map;

/**
 * DB Service which allow operate on algorithm data.
 */
public interface AlgorithmService {

	/**
	 * Get all Result for selected user.
	 *
	 * @param userId user if for which will be returned Collection.
	 * @return Collection of results for selected user.
	 */
	Collection<AlgorithmResultDto> getAllResultForUser(Long userId);

	/**
	 * Return AlgorithmResult for id.
	 *
	 * @param id Id of searched result.
	 * @return Result of selected id, if not find return null.
	 */
	AlgorithmResultDto getResultById(Long id);

	/**
	 * Return image by imageId.
	 *
	 * @param imageId Id of searching image.
	 * @return Image of selected id, if not find return null.
	 */
	byte[] getImageBytesById(Long imageId);

	/**
	 * Save result in DB.
	 *
	 * @param description   Description for result.
	 * @param algorithmType Type of algorithm for which result is saved.
	 * @param parametersMap Map of parameter which was used to compute algorithm.
	 * @param imageDto      Image result of computing.
	 * @return Saved result.
	 */
	AlgorithmResultDto saveResult(String description, AlgorithmType algorithmType, Map<String, Double> parametersMap, ImageDto imageDto);
}
