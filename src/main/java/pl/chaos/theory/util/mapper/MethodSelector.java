package pl.chaos.theory.util.mapper;

class MethodSelector {
	private final Class returnClass;
	private final Class parameterClass;

	public MethodSelector(Class returnClass, Class parameterClass) {
		this.returnClass = returnClass;
		this.parameterClass = parameterClass;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		MethodSelector that = (MethodSelector) o;
		return returnClass.equals(that.returnClass) && parameterClass.equals(that.parameterClass);
	}

	@Override
	public int hashCode() {
		int result = returnClass.hashCode();
		result = 31 * result + parameterClass.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "MethodSelector{" +
				"returnClass=" + returnClass +
				", parameterClass=" + parameterClass +
				'}';
	}
}
