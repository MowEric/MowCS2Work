public class ParallelHello extends Thread{

    private int id;

    public ParallelHello(int id) {this.id = id;}

    public void run() {
        StdOut.println("Hello, world (" + id + ")");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] a = new Thread[10];
        for (int i = 0; i < a.length; ++i)
            a[i] = new ParallelHello(i);
        for (int i = 0; i < a.length; ++i)
            a[i].start();
        for (int i = 0; i < a.length; ++i)
            a[i].join();
        StdOut.println("Done");
    }
}
