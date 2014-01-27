package generic;

import static java.lang.System.out;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionForGeneric {

	public static void toString(Class<?> clazz) {
		out.println(clazz + "(toString)");
		for (Field f : clazz.getFields())
			out.println(f.toString());
		for (Constructor<?> ctor : clazz.getConstructors())
			out.println(ctor.toString());
		for (Method m : clazz.getMethods())
			out.println(m.toString());
		out.println();
	}
	
	public static void toGenericString(Class<?> clazz)
	{
		out.println(clazz + "(toString)");
		for (Field f : clazz.getFields())
			out.println(f.toGenericString());
		for (Constructor<?> ctor : clazz.getConstructors())
			out.println(ctor.toGenericString());
		for (Method m : clazz.getMethods())
			out.println(m.toGenericString());
		out.println();
	}
	
	public static class Cell<E>
	{
		private E value;
		public Cell (E value)
		{
			this.value = value;
		}
		
		public E getValue() {return value;}
		public void setValue(E value) { this.value = value; }
		public static <T> Cell<T> copy(Cell<T> cell)
		{
			return new Cell<T>(cell.getValue());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		toString(ReflectionForGeneric.Cell.class);
		toGenericString(ReflectionForGeneric.Cell.class);
	}

}
