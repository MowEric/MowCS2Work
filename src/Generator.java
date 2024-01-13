/**
 * A thread that generates the numbers [2, 3, 4, 5, ...) writes them
 * into a queue.
 */

import java.util.concurrent.SynchronousQueue;

public class Generator extends Thread {

    private SynchronousQueue<Long> queue;

    public Generator(SynchronousQueue<Long> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            for (long n = 2; ; ++n) {
                    queue.put(n);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
