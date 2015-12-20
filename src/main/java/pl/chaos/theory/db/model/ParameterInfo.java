package pl.chaos.theory.db.model;

import javax.persistence.*;

@Entity
@Table(name = "parameter_info")
public class ParameterInfo extends Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	@Column(name = "symbol", nullable = false)
	private String symbol;
	@Column(name = "description", nullable = false)
	private String description;
	@Column(name = "algorithm_id", nullable = false)
	private Long algorithmId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getAlgorithmId() {
		return algorithmId;
	}

	public void setAlgorithmId(Long algorithmId) {
		this.algorithmId = algorithmId;
	}
}
