package generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericMethod {

	
	public static <T> void fromArrayToCollection(T[] a, Collection<T> c)
	{
		for (T o : a)
		{
			c.add(o);
		}
	}
	
	public static <T> void copy(final List<T> dest, final List<? extends T> src)
	{
		for (T o : src)
		{
			dest.add(o);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> s = new ArrayList<String>();
		String[] ss = new String[] {"a", "b", "c"};
		fromArrayToCollection(ss, s);
		System.out.print(s.get(0));
	}

}
