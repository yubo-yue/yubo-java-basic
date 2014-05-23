package yubo.java.generics.and.collections;

import static org.junit.Assert.*;

import java.io.PrintStream;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;


import java.util.ArrayList;

import org.junit.Test;

public class ReflectionTest {
	public static final PrintStream out = System.out;

	public static void printType(Type type) {
		if (type instanceof Class) {
			Class<?> c = (Class) type;
			out.print(c.getName());
		} else if (type instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) type;
			Class c = (Class) pt.getRawType();
			Type o = pt.getOwnerType();
			if (o != null) {
				printType(o);
				out.print(".");
			}
			out.print(c.getName());
			printParams(pt.getActualTypeArguments());
		} else if (type instanceof TypeVariable<?>) {
			TypeVariable<?> v = (TypeVariable<?>) type;
			out.print(v.getName());
		} else if (type instanceof GenericArrayType) {
			GenericArrayType a = (GenericArrayType) type;
			printType(a.getGenericComponentType());
			out.print("[]");
		} else if (type instanceof WildcardType) {
			WildcardType w = (WildcardType) type;
			Type[] uppers = w.getUpperBounds();
			Type[] lowers = w.getLowerBounds();
			if (uppers.length == 1 && lowers.length == 0) {
				out.print("? extends ");
				printType(uppers[0]);
			} else if (uppers.length == 0 && lowers.length == 1) {
				out.print("? super ");
				printType(lowers[0]);
			} else
				throw new AssertionError();
		}
	}

	public static void printParams(Type[] types) {
		if (types != null && types.length > 0) {
			out.print("<");
			int i = 0;
			for (Type type : types) {
				if (i++ > 0)
					out.print(",");
				printType(type);
			}
			out.print(">");
		}
	}

	public static void printSuperClass(Type sup) {
		if (sup != null && !sup.equals(Object.class)) {
			out.print(" extends ");
			printType(sup);
			out.println();
		}
	}

	public static void printInterfaces(Type[] impls) {
		if (impls != null && impls.length > 0) {
			out.print(" implements ");
			int i = 0;
			for (Type impl : impls) {
				if (i++ > 0)
					out.print(",");
				printType(impl);
			}
			out.println();
		}
	}

	public static void printTypeParameters(TypeVariable<?>[] vars) {
		if (vars != null && vars.length > 0) {
			out.print("<");
			int i = 0;
			for (TypeVariable<?> tv : vars) {
				if (i++ > 0)
					out.print(",");
				out.print(tv.getName());
				;

				printBounds(tv.getBounds());
			}
			out.print(">");
		}
	}

	public static void printBounds(Type[] bounds) {
		if (bounds != null && bounds.length > 0
				&& !(bounds.length == 1 && bounds[0] == Object.class)) {
			out.print(" extends ");
			int i = 0;
			for (Type bound : bounds) {
				if (i++ > 0)
					out.print("&");
				printType(bound);
			}
		}
	}

	public static void printClass(Class c) {
		out.print("class ");
		out.print(c.getName());
		printTypeParameters(c.getTypeParameters());
		out.println();
		printSuperClass(c.getGenericSuperclass());
		printInterfaces(c.getGenericInterfaces());

	}

	static class Cell<E> {
		private E value;

		public Cell(E value) {
			this.value = value;
		}

		public E getValue() {
			return value;
		}

		public void setValue(E value) {
			this.value = value;
		}

		public static <T> Cell<T> copy(Cell<T> cell) {
			return new Cell<T>(cell.getValue());
		}
	}

	@Test
	public void test() {
		ReflectionTest.printClass(Cell.class);
		ReflectionTest.printClass(ArrayList.class);
		ReflectionTest.printClass(Enum.class);
		assertTrue(true);
	}

}
