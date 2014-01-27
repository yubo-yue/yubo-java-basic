package generic;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static java.lang.System.out;

public class CuteCollections {

	public static <T extends Comparable<? super T>> T max(Collection<? extends T> col) {
		T candidate = col.iterator().next();
		for (T elem : col) {
			if (candidate.compareTo(elem) < 0)
				candidate = elem;
		}
		return candidate;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(1, 2, 3);
		int maxInt = max(ints);
		out.println("Max int: " + maxInt);
		
	}

}
