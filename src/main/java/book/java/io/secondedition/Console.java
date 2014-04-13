package book.java.io.secondedition;

public class Console {

	public static void main(String[] args)
	{
		java.io.Console console = System.console();
		for (double degrees = 0.0; degrees < 360.0; degrees++)
		{
			double radians = Math.PI * degrees / 180;
			double grads = 400 * radians / 360.0;
			console.printf("%5.1f %5.1f %5.1f\n", degrees, radians, grads);
		}
		int a = 0, b = 0;
		console.readPassword("input password : ", a, b);
	}
}
