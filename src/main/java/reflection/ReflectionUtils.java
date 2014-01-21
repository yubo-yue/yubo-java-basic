package reflection;

public class ReflectionUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Class c = Double.TYPE;
		String canonicalName = c.getCanonicalName();
		System.out.println("Canonical Name : " + canonicalName);
		Class cc = double.class;
		canonicalName = cc.getCanonicalName();
		System.out.println("Canonical Name : " + canonicalName);
	}

}
