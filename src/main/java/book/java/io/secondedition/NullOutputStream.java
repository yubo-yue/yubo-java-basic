package book.java.io.secondedition;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class NullOutputStream extends OutputStream {

	public static void main(String[] args) {
		OutputStream out = new NullOutputStream();
		PrintStream ps = new PrintStream(out);
		System.setOut(ps);
		System.out.println("Don't print");
	}
	
	private boolean closed = false;

	@Override
	public void write(int b) throws IOException {
		if (closed) throw new IOException("Write to closed stream.");
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		if (b == null) throw new NullPointerException("data is null");
		if (closed) throw new IOException("Write to closed stream.");
	}

	@Override
	public void close() throws IOException {
		closed = true;
	}
	
	

}
