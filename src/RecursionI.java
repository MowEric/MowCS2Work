public class RecursionI {

    /**
     * Compute the sum of the natural numbers from 0 to n with a loop
     * (any loop will do).
     *
     * Examples:
     * iterativeSum(0) returns 0
     * iterativeSum(1) returns 1
     * iterativeSum(4) returns 10
     *
     * @param n
     * @return the sum of the natural numbers from 0 to n
     */
    public static int iterativeSum(int n) {
        int a = 0;
        for (int c = 0; c <= n; c++) {
            a += c ;
        }
        return a;
    }

    /**
     * Compute the sum of the natural numbers from 0 to n *without* a
     * loop (no loop; just if statement(s)).
     *
     * Examples:
     * recursiveSum(0) returns 0
     * recursiveSum(1) returns 1
     * recursiveSum(4) returns 10
     *
     * @param n
     * @return the sum of the natural numbers from 0 to n
     */
    public static int recursiveSum(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return n + recursiveSum(n-1);
        }
    }

}