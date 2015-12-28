package pl.chaos.theory.db.model;

import pl.chaos.theory.algorithm.AlgorithmType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "algorithm_result")
public class AlgorithmResult extends Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	@Column(name = "user_id", nullable = false)
	private Long userId;
	@Column(name = "image_id", nullable = false)
	private Long imageId;
	@Column(name = "description_id", nullable = false)
	private String description;
	@OneToMany(mappedBy = "algorithmResult", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Parameter> parameters;
	@Column(name = "type", nullable = false)
	@Enumerated(EnumType.STRING)
	private AlgorithmType algorithmType;

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

	public Set<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(Set<Parameter> parameters) {
		this.parameters = parameters;
	}

	public AlgorithmType getAlgorithmType() {
		return algorithmType;
	}

	public void setAlgorithmType(AlgorithmType algorithmType) {
		this.algorithmType = algorithmType;
	}
}
