package pl.chaos.theory.dto.model;

/**
 * Base class for all dtos
 */
public abstract class Dto {
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
