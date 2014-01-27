package generic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Functions {

	public static <A, B, X extends Throwable> List<B> applyAll(Function<A, B, X> f, List<A> list) throws X {
		List<B> results = new ArrayList<B>(list.size());
		for (A x : list)
		{
			results.add(f.apply(x));
		}
		return results;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Function<String, Integer, Error> length = new Function<String, Integer, Error> () {
			public Integer apply(String s)
			{
				return s.length();
			}
		};
		
		Function<String, Class<?>, ClassNotFoundException> forName = new Function<String, Class<?>, ClassNotFoundException> () {
			public Class<?> apply(String s) throws ClassNotFoundException
			{
				return Class.forName(s);
			}
		};
		
		Function<String, Method, Exception> getRunMethod = new Function<String, Method, Exception> () {
			public Method apply(String s) throws Exception
			{
				return Class.forName(s).getMethod("run");
			}
		};
		
		List<String> strings = Arrays.asList("java.lang.Thread", "java.lang.Runnable", "java.util.ArrayList");
		
		System.out.println(applyAll(length, strings));
		try {
			System.out.println(applyAll(forName, strings));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(applyAll(getRunMethod, strings));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
