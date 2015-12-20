package pl.chaos.theory.dto.model;

public class AlgorithmResultDto extends Dto {
	private Long id;
	private Long userId;
	private Long algorithmId;
	private Long imageId;
	private String description;
	private AlgorithmDto algorithm;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAlgorithmId() {
		return algorithmId;
	}

	public void setAlgorithmId(Long algorithmId) {
		this.algorithmId = algorithmId;
	}

	public Long getImageId() {
		return imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AlgorithmDto getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(AlgorithmDto algorithm) {
		this.algorithm = algorithm;
	}
}
