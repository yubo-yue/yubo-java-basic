package yubo.java.generics.and.collections;

import java.io.Closeable;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GenericWildcardsTest {

	public static void count(Collection<? super Integer> ints, int n) {
		for (int i = 0; i < n; ++i) {
			ints.add(i);
		}
	}

	public static <T> void copy(List<? super T> dst, List<? extends T> src) {
		for (int i = 0; i < src.size(); ++i) {
			dst.set(i, src.get(i));
		}
	}

	/**
	 * Multiple bound copy
	 * 
	 * @throws IOException
	 */
	public static <S extends Readable & Closeable, T extends Appendable & Closeable> void copy(
			S src, T target, int size) throws IOException {
		try {
			CharBuffer buf = CharBuffer.allocate(size);
			int i = src.read(buf);
			while (i >= 0) {
				buf.flip();
				target.append(buf);
				buf.clear();
				i = src.read(buf);
			}
		} finally {
			src.close();
			target.close();
		}

	}

	@Test
	public void testCount() {
		Assert.assertTrue(true);
	}

	@Test
	public void testCopy() {
		List<Object> objs = Arrays.<Object> asList(2, 3.14, "four");
		List<Integer> ints = Arrays.<Integer> asList(5, 6);

		copy(objs, ints);
		Assert.assertTrue(objs.size() == 3);
	}

	@Test
	public void testMultiboundCopy() throws IOException {
		int size = 32;
		FileReader reader = new FileReader("data/in.txt");
		FileWriter writer = new FileWriter("data/output.txt");
		GenericWildcardsTest.copy(reader, writer, size);
		Assert.assertTrue(true);
	}

}
