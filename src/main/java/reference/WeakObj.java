package reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class WeakObj {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReferenceQueue<Object> rq = new ReferenceQueue<Object>();
		Object o = new Object();

		WeakReference<Object> ref = new WeakReference<Object>(o, rq);

		String extraData = "Extra Data";
		HashMap<WeakReference<Object>, String> aHashMap = new HashMap<WeakReference<Object>, String>();
		aHashMap.put(ref, extraData);

		System.out.println("*** created ref to some object");
		System.out.println();
		System.out.println("contents of ref: " + ref.get());

		System.out.println();
		System.out.println("ref.isEnqueued(): " + ref.isEnqueued());
		System.out.println();

		o = null;

		if (o == null) {
			extraData = null;
		}

		// Run the garbage collector, and
		// Check the reference object's referent
		System.out.println("*** running gc...");
		System.gc();
		System.out.println();
		System.out.println("contents of ref: " + ref.get());
		System.out.println();

		// Enqueue the reference object.
		// This method returns false
		// if the reference object is already enqueued.
		System.out.println("enqueued=" + ref.enqueue());
	}

}
