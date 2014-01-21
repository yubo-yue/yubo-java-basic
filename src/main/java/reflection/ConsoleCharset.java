package reflection;

import static java.lang.System.out;

import java.io.Console;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

public class ConsoleCharset {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Constructor[] ctors = Console.class.getDeclaredConstructors();
		Constructor ctor = null;

		for (int i = 0; i < ctors.length; i++) {
			ctor = ctors[i];
			if (ctor.getGenericParameterTypes().length == 0)
				break;
		}

		try {
			ctor.setAccessible(true);
			Console c = (Console) ctor.newInstance();
			Field f = c.getClass().getDeclaredField("cs");
			f.setAccessible(true);
			out.format("Console charset         :  %s%n", f.get(c));
		    out.format("Charset.defaultCharset():  %s%n",
			       Charset.defaultCharset());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
