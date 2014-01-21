package generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericMethod {

	public static <T> void fromArrayToCollection(final T[] a, final Collection<T> c) {
		for (T o : a) {
			c.add(o);
		}
	}

	public static <T> void copy(final List<T> dest, final List<? extends T> src) {
		for (T o : src) {
			dest.add(o);
		}
	}

	public interface Sink<T> {
		void flush(T t);
	}

	public static <T> T writeAll(Collection<T> c1, Sink<? super T> snk) {
		T last = null;
		for (T t : c1){
			last = t;
			snk.flush(last);
		}
		
		return last;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> s = new ArrayList<String>();
		String[] ss = new String[] { "a", "b", "c" };
		fromArrayToCollection(ss, s);
		System.out.print(s.get(0));
		
		Sink<Object> snk = null;
		Collection<String> cs = null;
		

		String str = writeAll(cs, snk);
	}

}
