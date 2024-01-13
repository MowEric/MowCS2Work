public class ThreeSum {

    static int countTriples(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j)
                for (int k = j + 1; k < n; ++k)
                    if (a[i] + a[j] + a[k] == 0) ++count;
        return count;
    }

    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = StdRandom.uniform(2000000) - 1000000;
        Stopwatch timer = new Stopwatch();
        int count = countTriples(a);
        return timer.elapsedTime();
    }

    public static void main(String[] unused) {
        double previous = timeTrial(128);
        for (int n = 256; true; n *= 2) {
            double current = timeTrial(n);
            double ratio = current/previous;
            StdOut.printf("%7d %4.2f\n", n, ratio);
            previous = current;
        }
    }

}