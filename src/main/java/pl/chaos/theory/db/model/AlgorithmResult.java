package pl.chaos.theory.db.model;

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
	@Column(name = "algorithm_id", nullable = false, insertable = false, updatable = false)
	private Long algorithmId;
	@Column(name = "image_id", nullable = false)
	private Long imageId;
	@Column(name = "description_id", nullable = false)
	private String description;
	@ManyToOne
	@JoinColumn(name = "algorithm_id")
	private Algorithm algorithm;
	@OneToMany(mappedBy = "algorithmResultId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Parameter> parameters;

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

	public Algorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	public Set<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(Set<Parameter> parameters) {
		this.parameters = parameters;
	}
}
