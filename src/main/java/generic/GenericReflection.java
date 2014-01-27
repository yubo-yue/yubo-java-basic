package generic;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

public class GenericReflection {

	@SuppressWarnings("unchecked")
	public static <T> T newInstance(T obj) throws InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		Object newObj = obj.getClass().getConstructor().newInstance();
		return (T) newObj;
	}

	@SuppressWarnings("unchecked")
	public static <T> Class<? extends T> getComponentType(T[] a) {
		Class<?> k = a.getClass().getComponentType();
		return (Class<? extends T>) k;
	}

	@SuppressWarnings("unchecked")
	public static <T> T[] newArray(Class<? extends T> k, int size) {
		if (k.isPrimitive())
			throw new IllegalArgumentException();
		Object a = java.lang.reflect.Array.newInstance(k, size);
		return (T[]) a;
	}

	public static <T> T[] newArray(T[] a, int size) {
		return newArray(getComponentType(a), size);
	}

	public static <T, C extends Collection<T>> C copy(C coll)
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		C copy = GenericReflection.newInstance(coll);
		copy.addAll(coll);
		return copy;
	}

	public static <T> T[] toArray(Collection<T> c, T[] a) {
		if (a.length < c.size())
			a = GenericReflection.newArray(a, c.size());
		int i = 0;
		for (T x : c)
		{
			a[i++] = x;
		}
		if (i < a.length) a[i] = null;
		
		return a;
	}

	/**
	 * @param args
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		Integer a = GenericReflection.newInstance(Integer.valueOf(10));

	}

}
