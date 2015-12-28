package pl.chaos.theory.algorithm;

public class AlgorithmInfo {
	private String name;
	private String description;
	private AlgorithmType algorithmType;

	public AlgorithmInfo(String name, String description, AlgorithmType algorithmType) {
		this.name = name;
		this.description = description;
		this.algorithmType = algorithmType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AlgorithmType getAlgorithmType() {
		return algorithmType;
	}

	public void setAlgorithmType(AlgorithmType algorithmType) {
		this.algorithmType = algorithmType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		AlgorithmInfo that = (AlgorithmInfo) o;
		return algorithmType == that.algorithmType;

	}

	@Override
	public int hashCode() {
		return algorithmType.hashCode();
	}
}
