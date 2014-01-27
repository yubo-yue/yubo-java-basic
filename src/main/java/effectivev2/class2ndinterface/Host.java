package effectivev2.class2ndinterface;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import static java.lang.System.out;
public class Host {

	private static class StrLenCmp implements Comparator<String>, Serializable{
		private static final long serialVersionUID = -3838381956264259790L;

		public int compare(String a, String b)
		{
			return a.length() - b.length();
		}
	}
	
	public static final Comparator<String> STRING_LENGTH_COMPARATOR = new StrLenCmp();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ss = {"a", "bb", "ccc", "dd", "e"};
		out.println("before sort: ");
		for (String a : ss)
		{
			out.println(a);
		}
		Arrays.sort(ss, Host.STRING_LENGTH_COMPARATOR);
		out.println("after sort: ");
		for (String a : ss)
		{
			out.println(a);
		}
	}

}
