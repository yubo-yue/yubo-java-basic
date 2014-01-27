package generic;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TruthInAdvertising {

	public static class Wrong {
		public static <T> T[] toArray(Collection<T> c) {
			@SuppressWarnings("unchecked")
			T[] a = (T[]) new Object[c.size()];
			int i = 0;
			for (T x : c) {
				a[i++] = x;
			}
			return a;
		}
	}

	public static class Right {
		@SuppressWarnings("unchecked")
		public static <T> T[] toArray(Collection<T> c, T[] a) {
			if (a.length < c.size()) {
				a = (T[]) java.lang.reflect.Array.newInstance(a.getClass()
						.getComponentType(), c.size());
			}
			int i = 0;
			for (T x : c) {
				a[i++] = x;
			}
			// a.length > c.size
			if (i < a.length)
				a[i] = null;
			return a;
		}
	}
	
	public static class RightWithClass {
		public static <T> T[] toArray(Collection<T> c, Class<T> clz)
		{
			@SuppressWarnings("unchecked")
			T[] a = (T[]) java.lang.reflect.Array.newInstance(clz, c.size());
			int i = 0;
			for (T x : c)
			{
				a[i++] = x;
			}
			return a;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> strings = Arrays.asList("one", "two");

		String[] a = Right.toArray(strings, new String[0]);
		for (String s : a) {
			System.out.println(s);
		}
		
		a = RightWithClass.toArray(strings, String.class);
		
		for (String s : a) {
			System.out.println(s);
		}
		// String[] a = Wrong.toArray(strings); // class cast error
	}

}
