package yubo.java.generics.and.collections;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Test;

public class BridgeMethodTest {

	public static class MyInteger implements Comparable<MyInteger>
	{
		private final int value;
		
		public MyInteger(int v)
		{
			value = v;
		}
		
		public int compareTo(MyInteger o) {
			return (value < o.value) ? -1 : (value == o.value) ? 0 : 1;
		}
		
		/**
		 * Covariant overriding - has same arguments, has same return type or return type of override is subtype of overrided method.
		 */
		public MyInteger clone()
		{
			return new MyInteger(value);
		}
		
	}
	@Test
	public void test() {
		for (Method m : MyInteger.class.getMethods())
		{
			if (m.getName().equals("compareTo"))
			{
				System.out.println(m.toString());
				System.out.println(m.toGenericString());
			}
		}
		
		for (Method m : MyInteger.class.getMethods())
		{
			if (m.getName().equals("clone"))
			{
				System.out.println(m.toGenericString());
			}
		}
		assertTrue(true);
	}

}
