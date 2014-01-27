package generic;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class WildcardsWithSuper {

	public static <T> void copy(List<? super T> dst, List<? extends T> src) {
		for (int i = 0; i < src.size(); i++) {
			dst.set(i, src.get(i));
		}
	}

	public static double sum(Collection<? extends Number> nums) {
		double s = 0.0;
		for (Number n : nums)
			s = s + n.doubleValue();

		return s;
	}

	public static void reverse(List<?> list) {
		//captured the wildcards
		rev(list);
	}

	private static <T> void rev(List<T> list) {
		List<T> temp = new ArrayList<T>(list);
		for (int i = 0; i < list.size(); i++)
		{
			list.set(i, temp.get(list.size() - i - 1));
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Object> objs = Arrays.<Object> asList(2, 3.14, "abc");
		List<Integer> ints = Arrays.asList(1, 3);
		WildcardsWithSuper.copy(objs, ints);

		out.print(objs.toString());

		ints = Arrays.asList(1, 2, 3);
		List<Double> dbls = Arrays.asList(1.0, 2.0, 3.0);
		List<Number> nums = Arrays.<Number> asList(1, 2, 3.0);
		out.println("ints:" + sum(ints));
		out.println("doubles:" + sum(dbls));
		out.println("numbers:" + sum(nums));
		
		reverse(ints);
		out.println("ints:" + ints.toString());
	}

}
