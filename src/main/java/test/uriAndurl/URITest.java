package test.uriAndurl;

import java.net.URI;

public class URITest {

	public static void main(String [] args)
	{
		URI uri = URI.create("file:/tmp/test.txt");
		String schemeSpecificPart = uri.getSchemeSpecificPart();
		System.out.println(schemeSpecificPart);
	}
}
