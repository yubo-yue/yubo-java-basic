package book.java.generic.and.collection.ch13set;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

public class SetTest {

	
	@Test
	public void test() {
		Set<Character> cSet = new LinkedHashSet<Character>(8);
		Collections.addAll(cSet, 'a', 'b', 'j');
		assertEquals("[a, b, j]", cSet.toString());
	}
	
	@Test
	public void test1()
	{
		Set<Character> cSet  = new HashSet<Character>();
		Collections.addAll(cSet, 'a', 'c', 'e', 'f');
		assertFalse(cSet.toArray().equals("[a, c, e, f]"));
	}

	@Test
	public void testEnumSet()
	{
		EnumSet<Text.Style> s = EnumSet.of(Text.Style.BOLD, Text.Style.UNDERLINE);
		assertTrue(s.contains(Text.Style.BOLD));
		assertEquals(2, s.size());
		
	}
	
	
	public static class Text {
		public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH};
		public void applyStyle(Set<Style> s) {};
	}
}
