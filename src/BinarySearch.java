public class BinarySearch {

    /**
     * Search the key in the given array of values.
     * The type of the values must implement the Comparable interface.
     * @param key  the key
     * @param a  the array of values
     * @return the index of an occurrence of key in a, or -1 if key is not found
     */
    public static int search(Comparable key, Comparable[] a) {
        return search(key, a, 0, a.length);
    }

    /**
     * Search the key in the given array of values in the range [lo, hi).
     * This function is only to be used internally (marked private).
     * @param key  the key
     * @param a  the array of values
     * @param lo  the lower side of the range
     * @param hi  the higher side of the range
     * @return the index of an occurrence of key in a, or -1 if key is not found
     */
    private static int search(Comparable key, Comparable[] a, int lo, int hi) {
        if (hi <= lo) return -1;
        int mid = lo + (hi - lo)/2;
        int cmp = a[mid].compareTo(key);
        if (cmp > 0) return search(key, a, lo, mid);
        if (cmp < 0) return search(key, a, mid + 1, hi);
        return mid;
    }

    public static double timeTrial(int n) {
        // An array of sorted integers: 0, 1, 2, ... n - 1
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; ++i) { a[i] = i; }

        // Fixed number of random keys to search.
        int[] k = new int[1000];
        for (int i = 0; i < k.length; ++i) { k[i] = StdRandom.uniform(n); }

        // Measure the time it takes to search these keys in the sorted array.
        Stopwatch timer = new Stopwatch();
        for (int i = 0; i < k.length; ++i) { search(k[i], a); }
        return timer.elapsedTime();
    }

    public static void main(String[] unused) {
//        main();  // Uncomment this line to run the time trial.

        String[] a = { "ant", "lion", "lioness", "monkey", "orca", "zebra"};
        int k;

        k = search("ant", a);
        if (k < 0) StdOut.println("Didn't find \"ant\"");
        else       StdOut.println("Found \"ant\" at position " + k);
        k = search("zebra", a);
        if (k < 0) StdOut.println("Didn't find \"zebra\"");
        else       StdOut.println("Found \"zebra\" at position " + k);
        k = search("nano", a);
        if (k < 0) StdOut.println("Didn't find \"nano\"");
        else       StdOut.println("Found \"nano\" at position " + k);
        k = search("apple", a);
        if (k < 0) StdOut.println("Didn't find \"apple\"");
        else       StdOut.println("Found \"apple\" at position " + k);

    }

    public static void main() {
        double previous = timeTrial(256);
        for (int n = 512; true; n *= 2) {
            double current = timeTrial(n);
            double ratio = current/previous;
            StdOut.printf("%7d %4.2f\n", n ,ratio);
            previous = current;
        }
    }

}
