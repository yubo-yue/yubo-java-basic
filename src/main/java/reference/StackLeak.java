package reference;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.concurrent.TimeUnit;

public class StackLeak {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public StackLeak() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public Object pop() {
		if (size == 0)
			throw new EmptyStackException();
		return elements[--size];
	}

	/**
	 * Ensure space for at least one more element, roughly doubling the capacity
	 * each time the array needs to grow.
	 */
	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		StackLeak s = new StackLeak();
		for (int i = 0; i < Integer.MAX_VALUE; i++)
		{
			s.push(new Object());
			if (i % 1000 == 0)
				TimeUnit.SECONDS.sleep(20);
		}
	}

}
