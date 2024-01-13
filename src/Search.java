public class Search {

    /**
     * Searches the integer key in the given array of integers.
     * @param key  the key
     * @param a  the array
     * @return the index of an occurrence of key in a, or -1 if key is not found
     */
    public static int search(Comparable key, Comparable[] a) {
        return search(key, a, 0, a.length);
    }

    private static int search(Comparable key, Comparable[] a, int lo, int hi) {
        if (hi <= lo) return -1;
        int mid = (hi+lo)/2;
        int cmp = a[mid].compareTo(key);
        if (cmp > 0) return search(key, a, lo, mid);
        if (cmp < 0) return search(key, a, mid+1, hi);
        return mid;
    }

    //public static double timeTrial(int n) {
    //     int[] a = new int[n];
    //     for (int i = 0; i < n; ++i) { a[i] = i; }
    //     int[] k = new int[1000];
    //     for (int i = 0; i < k.length; ++i) { k[i] = StdRandom.uniform(n); }
    //     Stopwatch timer = new Stopwatch();
    //     for (int i = 0; i < k.length; ++i) { search(k[i], a); }
    //     return timer.elapsedTime();
    // }

    public static void main(String[] unused) {
        Integer[] a = { 2, 10, 11, 11, 13, 17 };
        int k;

        k = search(2, a);
        if (k == -1) StdOut.println("Key 2 not found\n");
        else         StdOut.println("Key 2 found at position " + k);

        k = search(13, a);
        if (k == -1) StdOut.println("Key 13 not found\n");
        else         StdOut.println("Key 13 found at position " + k);

        k = search(1, a);
        if (k == -1) StdOut.println("Key 1 not found\n");
        else         StdOut.println("Key 1 found at position " + k);
    }

    //public static void main() {
    //    double previous = timeTrial(256);
    //    for (int n = 512; true; n *= 2) {
    //        double current = timeTrial(n);
    //        double ratio = current/previous;
    //        StdOut.printf("%7d %4.2f\n", n ,ratio);
    //        previous = current;
    //    }
    //}

}
