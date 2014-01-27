package reference;

import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MapLeaker {

	public ExecutorService es = Executors.newFixedThreadPool(5);
	public Map<Task, TaskStatus> taskStatus = Collections
			.synchronizedMap(new WeakHashMap<Task, TaskStatus>());
	
	private Random random = new Random();

	private enum TaskStatus {
		NOT_STARTED, STARTED, FINISHED
	}

	private class Task implements Runnable {
		private int[] numbers = new int[random.nextInt(200)];
		
		public void run()
		{
			int[] temp = new int[random.nextInt(100000)
			                     ];
			taskStatus.put(this
					, TaskStatus.STARTED);
			try {
				TimeUnit.SECONDS.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			taskStatus.put(this, TaskStatus.FINISHED);
		}
	}
	
	public Task newTask()
	{
		Task t = new Task();
		taskStatus.put(t, TaskStatus.NOT_STARTED);
		es.execute(t);
		return t;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MapLeaker ml = new MapLeaker();
		for (int i = 0; i < 10000; i++)
		{
			ml.newTask();
		}
	}

}
