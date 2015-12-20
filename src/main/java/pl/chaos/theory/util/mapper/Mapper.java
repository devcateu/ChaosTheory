package pl.chaos.theory.util.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.*;

@Component
public class Mapper {

	private Map<MethodSelector, MethodInvoker> map;

	@Autowired
	public Mapper(List<BaseMapper> baseMappers) {
		map = new HashMap<MethodSelector, MethodInvoker>();

		for (BaseMapper baseMapper : baseMappers) {
			baseMapper.setMapper(this);
			Method[] methods = baseMapper.getClass().getDeclaredMethods();
			for (Method method : methods) {
				Class[] parametersClasses = method.getParameterTypes();
				if (!("mapAtoB".equals(method.getName()) || "mapBtoA".equals(method.getName())) || parametersClasses.length != 1) {
					continue;
				}
				Class returnClass = method.getReturnType();
				map.put(new MethodSelector(returnClass, parametersClasses[0]), new MethodInvoker(baseMapper, method));
			}
		}
	}

	public <RET, IN> RET map(IN in, Class<RET> returnClass) {
		MethodInvoker invoker = searchingInvoker(in, returnClass);
		return (RET) invoker.invoke(in);
	}

	public <RET, IN> Set<RET> mapCollection(Collection<IN> paramsToMapping, Class<RET> returnClass) {
		Set<RET> set = new HashSet<RET>();
		MethodInvoker invoker = null;
		for (IN in : paramsToMapping) {
			if (invoker == null) {
				invoker = searchingInvoker(in, returnClass);
			}
			set.add((RET) invoker.invoke(in));
		}
		return set;
	}

	private <RET, IN> MethodInvoker searchingInvoker(IN in, Class<RET> returnClass) {
		MethodSelector selector = new MethodSelector(returnClass, in.getClass());
		MethodInvoker invoker = map.get(selector);
		if (invoker == null) {
			throw new RuntimeException("Invoker not found: " + selector);
		}
		return invoker;
	}
}
