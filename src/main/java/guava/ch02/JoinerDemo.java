package guava.ch02;

import com.google.common.base.Joiner;

public class JoinerDemo {

	public static void main(String[] args)
	{
		String[] strings = {"a", "b", "c"};
		String jointString = Joiner.on("|").skipNulls().join(strings);
		
		System.out.println(jointString);
	}
}
