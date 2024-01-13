/** Various functions dealing with vectors and matrices. */
class LinearAlgebra {

    /**
     * Returns the magnitude of the vector v (which may be of any length).
     * This is found by adding up the squares of all of the elements of v
     * and taking the square root of the total.
     */
    static double magnitude(double[] v) {
        double a = 0.0;
        for (int c = 0; v.length > c; c++) {
            a += v[c]*v[c];
        }
        a = Math.sqrt(a);
        return a;
    }

    /**
     * Returns the sum of vectors v and w. This is a vector of the same
     * length, each of whose elements is the sum of the corresponding
     * elements in v and w.
     */
    static double[] sum(double[] v, double[] w) {
        double a[] = new double[v.length];
        for (int c = 0; v.length > c; c++) {
            a[c] = v[c]+w[c];
        }
        return a;
    }

    /**
     * Returns the difference between vectors v and w. This is a vector
     * of the same length, each of whose elements is the difference
     * between the corresponding elements in v and w.
     */
    static double[] difference(double[] v, double[] w) {
        double a[] = new double[v.length];
        for (int c = 0; v.length > c; c++) {
            a[c] = v[c]-w[c];
        }
        return a;
    }

    /**
     * Returns the element-wise between vectors v and w. This is a vector
     * of the same length, each of whose elements is the product of the
     * corresponding elements in v and w.
     */
    static double[] elementwiseProduct(double[] v, double[] w) {
        double a[] = new double[v.length];
        for (int c = 0; v.length > c; c++) {
            a[c] = v[c]*w[c];
        }
        return a;
    }

    /**
     * Returns the dot product of vectors v and w. This is the sum of
     * the products of the corresponding elements.
     */
    static double dotProduct(double[] v, double[] w) {
        double a = 0;
        for (int c = 0; v.length > c; c++) {
            a += v[c]*w[c];
        }
        return a;
    }

    /**
     * Returns, as an array of two elements, the dimensions of matrix m.
     */
    static int[] dimensions(double[][] m) {
        int a[] = new int[2];
        for (int x = 0; m.length > x; x++) {
            a[0]++;
        }
        for (int y = 0; m[0].length > y; y++) {
            a[1]++;
        }
        return a;
    }

    /**
     * Returns the element-wise sum of matrices m and n.
     */
    static double[][] sum(double[][] m, double[][] n) {
        double a[][] = new double[m.length][m[0].length];
        for (int x = 0; m.length > x; x++) {
            for (int y = 0; m[0].length > y; y++) {
                a[x][y] = m[x][y] + n[x][y];
            }
        }
        return a;
    }

    /**
     * Returns the element-wise product of matrices m and n.
     */
    static double[][] elementwiseProduct(double[][] m, double[][] n) {
        double a[][] = new double[m.length][m[0].length];
        for (int x = 0; m.length > x; x++) {
            for (int y = 0; m[0].length > y; y++) {
                a[x][y] = m[x][y] * n[x][y];
            }
        }
        return a;
    }

    /**
     * Returns the transpose of m, that is, a matrix where element
     * i, j is element j, i from m.
     * [1] [2] [3]
     * [4] [5] [6]
     */
    static double[][] transpose(double[][] m) {
        double a[][] = new double[m[0].length][m.length];
        for (int x = 0; m[0].length > x; x++) {
            for (int y = 0; m.length > y; y++) {
                a[x][y] = m[y][x];
            }
        }
        return a;
    }

    /**
     * Returns the matrix product of m and n. (Search the web for a
     * definition.)
     */
    static double[][] product(double[][] m, double[][] n) {
        int xrange = LinearAlgebra.dimensions(m)[0];
        int yrange = LinearAlgebra.dimensions(n)[1];
        double a[][] = new double[xrange][yrange];
        for (int x = 0; xrange > x; x++) {
            for (int y = 0; yrange > y; y++) {
                for (int c = 0; c < LinearAlgebra.dimensions(m)[1]; c++) {
                    a[x][y] += m[x][c] * n[c][y];
                }
            }
        }
        return a;
    }

}
