package reflection;

import static java.lang.System.out;

public class ClassDeclarationSpy {

	public static void main(String[] args) {

		try {
			Class<?> c = Class.forName(args[0]);
			out.format("Class:%n %s%n%n", c.getCanonicalName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
