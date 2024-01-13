/**
 * A thread that takes the first number of its input queue, treats it
 * as a prime number, prints it out, and forwards subsequent numbers
 * from the input queueu to the output queue only if they are not
 * multiples of its prime number.
 */

import java.util.concurrent.SynchronousQueue;

public class Filter extends Thread {

    private long prime;
    private SynchronousQueue<Long> input;
    private SynchronousQueue<Long> output;

    public Filter(SynchronousQueue<Long> input, SynchronousQueue<Long> output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        try {
            this.prime = input.take();
            StdOut.println(this.prime);
            while (true) {
                long n = input.take();
                if (n % prime != 0) {
                    output.put(n);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}