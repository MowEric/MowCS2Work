import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearAlgebraTest {

    /**
     * Due to rounding error, doubles should not be checked for exact equality. This value defines what counts as
     * "close enough" for the tests.
     */
    static final double EPSILON = 0.0001;

    @Test
    void magnitudeReturnsCorrectAnswer() {
        double[] v = {1, 2, 3};
        assertEquals(3.7416, LinearAlgebra.magnitude(v), EPSILON);
    }

    @Test
    void magnitudeDoesNotModifyInput() {
        double[] v = {1, 2, 3, 4};
        double[] w = {1, 2, 3, 4}; // Second copy so that we can verify that v doesn't change
        LinearAlgebra.magnitude(v);
        assertArrayEquals(v, w, EPSILON);
    }

    @Test
    void vectorSumReturnsCorrectAnswer() {
        double[] v = {1, 2, 3};
        double[] w = {4, 5, 6};
        double[] expected = {5, 7, 9};
        assertArrayEquals(expected, LinearAlgebra.sum(v, w), EPSILON);
    }

    @Test
    void vectorSumDoesNotModifyInputs() {
        double[] v = {1, 2, 3, 4};
        double[] w = {1, 2, 3, 4};
        LinearAlgebra.sum(v, v);
        assertArrayEquals(v, w, EPSILON);
    }

    @Test
    void vectorDifferenceReturnsCorrectAnswer() {
        double[] v = {1, 2, 3};
        double[] w = {4, 1, 0};
        double[] expected = {-3, 1, 3};
        assertArrayEquals(expected, LinearAlgebra.difference(v, w), EPSILON);
    }

    @Test
    void vectorDifferenceDoesNotModifyInputs() {
        double[] v = {1, 2, 3, 4};
        double[] w = {1, 2, 3, 4};
        LinearAlgebra.difference(v, v);
        assertArrayEquals(v, w, EPSILON);
    }

    @Test
    void vectorElementwiseProductReturnsCorrectAnswer() {
        double[] v = {1, 2, 3};
        double[] w = {4, 1, 0};
        double[] expected = {4, 2, 0};
        assertArrayEquals(expected, LinearAlgebra.elementwiseProduct(v, w), EPSILON);
    }

    @Test
    void vectorElementwiseProductDoesNotModifyInputs() {
        double[] v = {1, 2, 3, 4};
        double[] w = {1, 2, 3, 4};
        LinearAlgebra.elementwiseProduct(v, w);
        assertArrayEquals(v, w, EPSILON);
    }

    @Test
    void dotProductReturnsCorrectAnswer() {
        double[] v = {1, 2, 3};
        double[] w = {4, 1, 0};
        assertEquals(6.0, LinearAlgebra.dotProduct(v, w), EPSILON);
    }

    @Test
    void dotProductDoesNotModifyInputs() {
        double[] v = {1, 2, 3, 4};
        double[] w = {1, 2, 3, 4};
        double[] p = {1, 2, 3, 4};
        double[] q = {5, 5, 5, 5};
        LinearAlgebra.dotProduct(v, v);
        assertArrayEquals(v, w, EPSILON);
    }

    @Test
    void dimensionsWorksForSmallSquareMatrix() {
        double[][] m = new double[3][3];
        int[] expected = {3, 3};
        assertArrayEquals(expected, LinearAlgebra.dimensions(m));
    }

    @Test
    void dimensionsWorksForLargeRectangularMatrix() {
        double[][] m = new double[20][100];
        int[] expected = {20, 100};
        assertArrayEquals(expected, LinearAlgebra.dimensions(m));
    }

    @Test
    void matrixSumReturnsCorrectAnswer() {
        double[][] m = {{1, 2},
                        {3, 4}};
        double[][] n = {{5, 6},
                        {7, 8}};
        double[][] expected = {{6, 8},
                               {10, 12}};
        double[][] result = LinearAlgebra.sum(m, n);
        // assertArrayEquals doesn't work for multidimensional arrays, so we have to go row by row
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], result[i], EPSILON);
        }
    }

    @Test
    void matrixSumDoesNotModifyInputs() {
        double[][] m = {{1, 2},
                        {3, 4}};
        double[][] n = {{1, 2},
                        {3, 4}};
        LinearAlgebra.sum(m, m);
        for (int i = 0; i < m.length; i++) {
            assertArrayEquals(m[i], n[i], EPSILON);
        }
    }

    @Test
    void matrixElementwiseProductReturnsCorrectAnswer() {
        double[][] m = {{1, 2},
                        {3, 4}};
        double[][] n = {{5, 6},
                        {7, 8}};
        double[][] expected = {{5, 12},
                               {21, 32}};
        double[][] result = LinearAlgebra.elementwiseProduct(m, n);
        // assertArrayEquals doesn't work for multidimensional arrays, so we have to go row by row
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], result[i], EPSILON);
        }
    }

    @Test
    void matrixElementwiseProductDoesNotModifyInputs() {
        double[][] m = {{1, 2},
                        {3, 4}};
        double[][] n = {{1, 2},
                        {3, 4}};
        LinearAlgebra.elementwiseProduct(m, m);
        for (int i = 0; i < m.length; i++) {
            assertArrayEquals(m[i], n[i], EPSILON);
        }
    }

    @Test
    void transposeReturnsCorrectAnswer() {
        double[][] m = {{1, 2, 3},
                        {4, 5, 6}};
        double[][] expected = {{1, 4},
                               {2, 5},
                               {3, 6}};
        double[][] result = LinearAlgebra.transpose(m);
        // assertArrayEquals doesn't work for multidimensional arrays, so we have to go row by row
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], result[i], EPSILON);
        }
    }

    @Test
    void transposeDoesNotModifyInputs() {
        double[][] m = {{1, 2, 3},
                        {4, 5, 6}};
        double[][] n = {{1, 2, 3},
                        {4, 5, 6}};
        LinearAlgebra.transpose(m);
        for (int i = 0; i < m.length; i++) {
            assertArrayEquals(m[i], n[i], EPSILON);
        }
    }

    @Test
    void matrixProductWorksForSquareMatrices() {
        double[][] m = {{1, 2},
                        {3, 4}};
        double[][] n = {{5, 6},
                        {7, 8}};
        double[][] expected = {{19, 22},
                               {43, 50}};
        double[][] result = LinearAlgebra.product(m, n);
        // assertArrayEquals doesn't work for multidimensional arrays, so we have to go row by row
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], result[i], EPSILON);
        }
    }

    @Test
    void matrixProductWorksForRectangularMatrices() {
        double[][] m = {{1, 2, 3},//2x3 matrix
                        {4, 5, 6}};
        double[][] n = {{1, 2, 3, 4},//3x4 matrix
                        {5, 6, 7, 8},
                        {9, 10, 11, 12}};
        double[][] expected = {{38, 44, 50, 56}, //2x4 matrix
                               {83, 98, 113, 128}};
        double[][] result = LinearAlgebra.product(m, n);
        assertArrayEquals(new int[] {2, 4}, LinearAlgebra.dimensions(result)); // Result must be correct size
        // assertArrayEquals doesn't work for multidimensional arrays, so we have to go row by row
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], result[i], EPSILON);
        }
    }

}