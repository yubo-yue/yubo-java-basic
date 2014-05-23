package learn.java.thread.cookbook.ch01;

public class PrimeGenerator extends Thread {

	public PrimeGenerator(String threadName) {
		super(threadName);
	}

	public void run() {

		long number = 1L;
		while (true) {
			if (isPrime(number)) {
				System.out.printf(Thread.currentThread().getName()
						+ " : Number %d is Prime\n", number);
			}

			if (isInterrupted()) {
				System.out.printf(Thread.currentThread().getName()
						+ " : The Prime Generator has been Interrupted\n");
				return;
			}
			number++;
		}
	}

	private boolean isPrime(long number) {
		if (number <= 2) {
			return true;
		}
		for (long i = 2; i < number; i++) {
			if ((number % i) == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Thread task = new PrimeGenerator("Prime-Generator-Thread");
		task.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		task.interrupt();
	}
}
