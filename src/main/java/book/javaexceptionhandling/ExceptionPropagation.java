package book.javaexceptionhandling;

/**
 * A()->B() fillInExceptionstack->C() throw exception
 * 
 * @author yubo
 * 
 */
public class ExceptionPropagation {

	public static void main(String[] args) {
		a();
	}

	public static void a() {
		try {
			b();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public static void b() throws Throwable {
		try {
			c();
		} catch (Exception e) {
			e.printStackTrace();

			Throwable eCopy = e.fillInStackTrace();

			throw eCopy;
		}
	}

	public static void c() throws Exception {
		throw new Exception("test");
	}

}
