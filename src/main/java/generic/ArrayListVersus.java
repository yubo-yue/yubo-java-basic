package generic;

public class ArrayListVersus {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object[] a = new Integer[10];
		a[0] = "abc";
		//sub is subtype of super, than sub[] is subtype of super[]
		System.out.println(a[0]);
		
		
	}

}
