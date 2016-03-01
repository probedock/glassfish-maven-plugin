package io.probedock.maven.plugin.glassfish.utils;

import java.util.Arrays;
import java.util.Set;

/**
 * Utility class to stringify sets of data
 *  
 * @author Laurent Prevost laurent.prevost@probedock.io
 */
public class Stringifier {
	public static <T> String toString(Set<T> setCollection) {
		if (setCollection == null) {
			return "null";
		} else if (setCollection.isEmpty()) {
			return "empty";
		}
		
		// Transform the set to array and sort by property names
		T[] array = (T[]) setCollection.toArray(new Object[setCollection.size()]);
		Arrays.sort(array);
		
		return toString(array);
	}
	
	public static <T> String toString(T[] array) {
		StringBuilder sb = new StringBuilder("{ ");
		for (T item : array) {
			sb.append(item).append(", ");
		}
		return sb.toString().replaceAll(", $", " }");
	}
}
