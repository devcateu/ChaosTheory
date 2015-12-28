package pl.chaos.theory.db.model;

import javax.persistence.*;

@Entity
@Table(name = "parameter")
public class Parameter extends Model {
	@ManyToOne
	@JoinColumn(name = "algorithm_Result_Id", nullable = false)
	public AlgorithmResult algorithmResult;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	@Column(name = "algorithm_Result_Id", nullable = false, insertable = false, updatable = false)
	private Long algorithmResultId;
	@Column(name = "symbol", nullable = false)
	private String symbol;
	@Column(name = "value", nullable = false)
	private Double value;

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

	public Long getAlgorithmResultId() {
		return algorithmResultId;
	}

	public void setAlgorithmResultId(Long algorithmResultId) {
		this.algorithmResultId = algorithmResultId;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public AlgorithmResult getAlgorithmResult() {
		return algorithmResult;
	}

	public void setAlgorithmResult(AlgorithmResult algorithmResult) {
		this.algorithmResult = algorithmResult;
	}
}
