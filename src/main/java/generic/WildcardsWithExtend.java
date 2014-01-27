package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.lang.System.out;

public class WildcardsWithExtend {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Number> nums = new ArrayList<Number>();
		List<Integer> ints = Arrays.asList(1, 2, 3);
		List<Double> dbls = Arrays.asList(1.1, 2.2, 3.3);

		nums.addAll(ints);
		nums.addAll(dbls);
		
		out.println(nums.toString());

	}

}
