package book.java.io.secondedition;

import java.io.FileInputStream;
import java.io.IOException;

public class FileTyper {

	public static void main(String[] args) throws IOException {
		typeFile("pom.xml");
	}

	public static void typeFile(String filename) throws IOException {
		FileInputStream fin = new FileInputStream(filename);
		try {
			StreamCopier.copy(fin, System.out);
		} finally {
			fin.close();
		}

	}

}
