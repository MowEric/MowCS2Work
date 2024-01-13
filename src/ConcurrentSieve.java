/**
 * A Concurrent Sieve of Eratosthenes
 */

import java.util.concurrent.SynchronousQueue;

public class ConcurrentSieve {

    public static void main(String[] unused) {
	// Create a queue.
        SynchronousQueue<Long> q = new SynchronousQueue<Long>();

	// Create and start a thread that outputs the numbers [2, 3,
	// 4, 5, 6, ...] into that queue.
        new Generator(q).start();

        while (true) {
	    // Create another queue.
            SynchronousQueue<Long> q1 = new SynchronousQueue<Long>();

	    // Create and start a thread that filters out numbers from
	    // the first queue that are multiple of the first number
	    // and copies the others to the second queue.
            new Filter(q, q1).start();

	    // The other queue becomes the first queue.
            q = q1;
        }

    }
}
