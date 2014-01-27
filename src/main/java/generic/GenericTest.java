package generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

	public static <T> List<T> factory() { return new ArrayList<T>(); }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<?> list = factory();
		List<?> listOfObjs = GenericTest.<Object>factory();
		//List<?> listOfUnknown = GenericTest.<?>factory(); //illegal
	}

}
