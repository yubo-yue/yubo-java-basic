package generic;

public interface Function<A, B, X extends Throwable> {
	public B apply(A a) throws X;
}
