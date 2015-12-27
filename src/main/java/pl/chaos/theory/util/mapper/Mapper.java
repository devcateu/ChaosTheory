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

	public <RET> RET map(Object param, Class<RET> returnClass) {
		if (param == null) {
			return null;
		}
		MethodInvoker invoker = searchingInvoker(param, returnClass);
		return (RET) invoker.invoke(param);
	}

	public <RET> Set<RET> mapCollection(Collection paramsToMapping, Class<RET> returnClass) {
		Set<RET> set = new HashSet<RET>();
		if (paramsToMapping == null) {
			return set;
		}
		MethodInvoker invoker = null;
		for (Object in : paramsToMapping) {
			if (invoker == null) {
				invoker = searchingInvoker(in, returnClass);
			}
			set.add((RET) invoker.invoke(in));
		}
		return set;
	}

	private <RET> MethodInvoker searchingInvoker(Object param, Class<RET> returnClass) {
		MethodSelector selector = new MethodSelector(returnClass, param.getClass());
		MethodInvoker invoker = map.get(selector);
		if (invoker == null) {
			System.out.println("Invoker not found: " + selector);
			throw new RuntimeException("Invoker not found: " + selector);
		}
		return invoker;
	}
}
