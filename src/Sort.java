public class Sort {

    /**
     * Sort the elements of the given array.
     * @param a  the array of elements to sort
     */
    public static void selectionSort(Comparable[] a) {
        selectionSort(a, 0);
    }

    /**
     * Sort the elements in the range [lo ...) of the given array.
     * This is an internal function not meant to be called directly by a client.
     * @param a  the array of elements to sort
     * @param lo  the lower side of the range
     */
    private static void selectionSort(Comparable[] a, int lo) {
	    // Base case.  If there are one or fewer elements to sort,
	    // we're done.
        if (lo >= a.length - 1) return;

	    // Guess that the smallest element in the range is at the
	    // lowest end of that range.
        int min = lo;

	    // Check our guess with every element to its right.
        for (int i = lo + 1; i < a.length; ++i) {
            if (a[i].compareTo(a[min]) < 0) {
		        // We found a counter example; update our new guess
		        // for the lower element in [lo ...).
                min = i;
            }
        }

	    // Swap the smallest element into the lowest spot in the range.
	    Comparable tmp = a[min];
	    a[min] = a[lo];
	    a[lo] = tmp;

	    // Now the smallest element in [lo ...) is in a[lo], then we can
	    // focus on sorting the rest of the range.
        selectionSort(a, lo + 1);
    }

    public static void mergeSort (Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];
        mergeSort(a, aux, 0, n);
    }

    public static void mergeSort (Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi - lo <= 1) return;
        int mid = lo + (hi-lo/2);
        mergeSort(a, aux, lo, mid);
        mergeSort(a, aux, mid, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void merge (Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid;
        for (int k = lo; k < hi; ++k) {
            if (i == mid) aux[k] = a[j++];
            else if (j == hi) aux[k] = a[i++];
            else if (a[j].compareTo(a[i]) < 0) aux[k] = a[j++];
            else aux[k] = a[i++];
        }
        //Copy back
        for (int k = lo; k < hi; ++k) {
            a[k] = aux[k];
        }
    }

    public static void sort(Comparable[] a) {
        selectionSort(a);
    }

    public static void main(String[] unused) {
        String[] a = { "zebra", "orca", "monkey", "lioness", "lion", "ant"};

        sort(a);
        for (int i = 0; i < a.length; ++i) {
            StdOut.println(a[i]);
        }
    }
}