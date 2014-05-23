package book.java.generic.and.collection.ch13set;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class HashSetTest {

	@Test
	public void test() {
		Set<String> s = new HashSet<String>(3);
		s.add("a");
		s.add("b");
		Assert.assertTrue(s.contains("b"));
	}
	
}
