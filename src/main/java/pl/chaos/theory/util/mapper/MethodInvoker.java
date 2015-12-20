package pl.chaos.theory.util.mapper;

import java.lang.reflect.Method;

class MethodInvoker {
	private final Object object;
	private final Method method;

	public MethodInvoker(Object object, Method method) {
		this.object = object;
		this.method = method;
	}

	public Object invoke(Object... params) {
		try {
			return method.invoke(object, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
