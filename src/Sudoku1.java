public class Sudoku1 {

    /**
     * Return a 9x9 grid of integers initialized with zeroes.
     * @return a 9x9 grid of zeroes
     */
    public static int[][] createGrid() {
        return new int[9][9];
    }

    /**
     * Return a 9x9 grid of integers initialized according to the
     * given diagram.  The diagram consists of the digits '1' through
     * '9' for filled spots or '.' for unfilled positions.  The
     * diagram may contain newlines.  This method should be able to
     * process the output of the toString() method.
     * @param diagram  a String representing a Sudoku grid
     * @return a 9x9 grid initialized according to the given diagram
     */
    public static int[][] createGrid(String diagram) {
        int[][] grid = createGrid();
        int i = 0;
        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                if (diagram.charAt(i) == '\n') ++i;
                char c = diagram.charAt(i++);
                if (c == '.') grid[row][col] = 0;
                else          grid[row][col] = c - '0';
            }
        }
        return grid;
    }

    /**
     * Return a String representing the given Sudoku grid.
     * @param grid  a 9x9 Sudoku grid, partially or fully filled
     * @return a String representing the given Sudoku grid
     */
    public static String toString(int[][] grid) {
        String diagram = "";
        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                if (grid[row][col] == 0)
                    diagram += ".";
                else
                    diagram += grid[row][col];
            }
            diagram += "\n";
        }
        return diagram;
    }

    /**
     * Solve the given Sudoku grid.  Unfilled positions contain the
     * value 0.  If the grid is solvable, this method returns true;
     * if so, a solution is available in grid.
     * @param grid  a 9x9 Sudoku grid
     * @return true if the grid is solvable
     */
    public static boolean solve(int[][] grid) {
        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                if (grid[row][col] == 0) {
                    for (int v = 1; v < 10; ++v) {
                        grid[row][col] = v;
                        if (solve(grid)) {
                            return true;
                        }
                    }
                    grid[row][col] = 0;
                }
            }
        }
        return isValid(grid);
    }

    public static boolean isValid(int[][] grid) {
        for (int row = 0; row < 9; ++row)
            if (!rowIsValid(grid, row)) return false;
        for (int col = 0; col < 9; ++col)
            if (!colIsValid(grid, col)) return false;
        for (int blkRow = 0; blkRow < 3; ++blkRow)
            for (int blkCol = 0; blkCol < 3; ++blkCol)
                if (!blkIsValid(grid, blkRow, blkCol)) return false;
        return true;
    }

    private static boolean rowIsValid(int[][] grid, int row) {
        nextValue: for (int v = 1; v < 10; ++v) {
            for (int col = 0; col < 9; ++col)
                if (grid[row][col] == v) continue nextValue;
            return false;
        }
        return true;
    }

    private static boolean colIsValid(int[][] grid, int col) {
        nextValue: for (int v = 1; v < 10; ++v) {
            for (int row = 0; row < 9; ++row)
                if (grid[row][col] == v) continue nextValue;
            return false;
        }
        return true;
    }

    private static boolean blkIsValid(int[][] grid, int blkRow, int blkCol) {
        nextValue: for (int v = 1; v < 10; ++v) {
            for (int row = blkRow*3; row < blkRow*3 + 3; ++row)
                for (int col = blkCol*3; col < blkCol*3 + 3; ++col)
                    if (grid[row][col] == v) continue nextValue;
            return false;
        }
        return true;
    }

}