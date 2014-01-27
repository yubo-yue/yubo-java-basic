package effectivev2.creation2nddestroy;

import java.util.HashMap;
import java.util.Map;
import static java.lang.System.out;


public class GenericTypeHelper {

	public static <K, V> HashMap<K, V> getHashMapInstance()
	{
		return new HashMap<K, V>();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, String> dict = getHashMapInstance();
		dict.put("hello", "greeting");
		dict.put("test", "experiment");
		
		out.println(dict.get("hello"));
		
	}

}
