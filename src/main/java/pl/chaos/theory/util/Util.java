package pl.chaos.theory.util;

import java.util.Collection;

public class Util {
	public static <T> void copyCollection(Collection<T> purpose, Collection<T> source) {
		purpose.clear();
		purpose.addAll(source);
	}
}
