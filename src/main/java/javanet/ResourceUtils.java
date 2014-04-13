package javanet;

import static java.lang.System.out;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ResourceUtils {
	public static void main(String[] args)
	{
		try {
			URL url = new URL("file:///www.sohu.com/a/b/c/i%20ndex.html?a=c");
			
			out.printf("Protocol %s, host %s, path %s \n", url.getProtocol(), url.getHost(), url.getPath());
			out.printf("getQuery %s, getFile %s \n", url.getQuery(), url.getFile());
			
			URI toURI = null;
			toURI = url.toURI();
			out.printf("%s convet to %s\n", url.toString(), toURI.toString());
			
			out.printf("schema %s, schema specific part %s \n", toURI.getScheme(), toURI.getSchemeSpecificPart());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
