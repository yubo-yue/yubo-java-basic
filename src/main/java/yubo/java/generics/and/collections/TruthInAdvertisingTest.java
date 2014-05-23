package yubo.java.generics.and.collections;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class TruthInAdvertisingTest {

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
		if (i < a.length)
			a[i] = null;
		return a;
	}

	public static <T> T[] toArray(Collection<T> c, Class<T> k) {
		T[] a = (T[]) java.lang.reflect.Array.newInstance(k, c.size());
		int i = 0;
		for (T x : c)
		{
			a[i++] = x;
		}
		return a;
	}

	@Test
	public void test() {
		List<String> strings = Arrays.asList("one", "two");
		String[] a = TruthInAdvertisingTest.toArray(strings, new String[0]);
		assertEquals("[one, two]", Arrays.toString(a));
		String[] b = new String[] { "x", "x", "x", "x" };
		TruthInAdvertisingTest.toArray(strings, b);
		assertEquals("[one, two, null, x]", Arrays.toString(b));
		
		String[] c = TruthInAdvertisingTest.toArray(strings, String.class);
		assertEquals("[one, two]", Arrays.toString(c));
	}

}
