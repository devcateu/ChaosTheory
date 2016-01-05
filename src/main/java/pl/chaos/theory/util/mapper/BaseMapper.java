package pl.chaos.theory.util.mapper;

/**
 * Base class for all mappers implementation.
 */
public abstract class BaseMapper<A, B> {
	protected Mapper mapper;

	public abstract B mapAtoB(final A model);

	public abstract A mapBtoA(final B dto);

	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}
}
