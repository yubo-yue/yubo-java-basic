package generic;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.CharBuffer;

public class MultipleBound {

	public static <S extends Readable & Closeable, T extends Appendable & Closeable> void copy(
			S src, T dst, int size) throws IOException {

		try {
			CharBuffer buf = CharBuffer.allocate(size);
			int i = src.read(buf);
			while (i >= 0) {
				buf.flip(); // prepare buffer for writing
				dst.append(buf);
				buf.clear();
				i = src.read(buf);
			}
		} finally {
			src.close();
			dst.close();
		}
	}

	public static class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Point clone() {
			return new Point(x, y);
		}

	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		InputStream in = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("data/in.file");
		InputStreamReader reader = new InputStreamReader(in);
		
		for (Method m : Point.class.getMethods())
		{
			System.out.println(m.toGenericString());
		}
		
		MultipleBound.copy(reader, System.out, 32);
	}

}
