package pl.chaos.theory.db.model;

import javax.persistence.*;

@Entity
@Table(name = "parameter")
public class Parameter extends Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	@Column(name = "algorithm_result_id", nullable = false)
	private Long algorithmResultId;
	@Column(name = "parameter_info_id", nullable = false, insertable = false, updatable = false)
	private Long parameterInfoId;
	@ManyToOne
	@JoinColumn(name = "parameter_info_id")
	private ParameterInfo parameterInfo;
	@Column(name = "value", nullable = false)
	private Double value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParameterInfoId() {
		return parameterInfoId;
	}

	public void setParameterInfoId(Long parameterInfoId) {
		this.parameterInfoId = parameterInfoId;
	}

	public ParameterInfo getParameterInfo() {
		return parameterInfo;
	}

	public void setParameterInfo(ParameterInfo parameterInfo) {
		this.parameterInfo = parameterInfo;
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
}
