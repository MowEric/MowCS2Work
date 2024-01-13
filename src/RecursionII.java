public class RecursionII {

    public static void main(String[] args) {
        runFactorials();
        runFibonaccis();
    }

    public static void runFactorials() {
        Stopwatch timer = new Stopwatch();
        factorial(1);
        double time1 = timer.elapsedTime();
        factorial(5);
        double time5 = timer.elapsedTime();
        factorial(10);
        double time10 = timer.elapsedTime();
        factorial(50);
        double time50 = timer.elapsedTime();
        StdOut.printf("factorial(1) took %.2f seconds\n", time1);
        StdOut.printf("factorial(5) took %.2f seconds\n", time5 - time1);
        StdOut.printf("factorial(10) took %.2f seconds\n", time10 - time5);
        StdOut.printf("factorial(50) took %.2f seconds\n", time50 - time10);
    }

    public static void runFibonaccis() {
        Stopwatch timer = new Stopwatch();
        fibonacci(1);
        double time1 = timer.elapsedTime();
        fibonacci(5);
        double time5 = timer.elapsedTime();
        fibonacci(10);
        double time10 = timer.elapsedTime();
        fibonacci(50);
        double time50 = timer.elapsedTime();
        StdOut.printf("fibonacci(1) took %.2f seconds\n", time1);
        StdOut.printf("fibonacci(5) took %.2f seconds\n", time5 - time1);
        StdOut.printf("fibonacci(10) took %.2f seconds\n", time10 - time5);
        StdOut.printf("fibonacci(50) took %.2f seconds\n", time50 - time10);
    }

    public static long factorial(long n) {
        if (n == 0) return 1;
        return factorial(n - 1)*n;
    }

    public static long fibonacci(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
