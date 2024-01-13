/** Sudoku solver. */
public class Sudoku {

    /**
     * Prints the solution to the puzzle in the specified directory.
     */
    public static void main(String[] args) {
        String puzzle = new In("sudoku1.txt").readAll();
        Square[][] grid = createSquares(puzzle);
        solve(grid);
        StdOut.println(toString(grid));
    }

    /**
     * Returns a new Location object with the specified row and column.
     */
    static Location createLocation(int r, int c) {
        Location x = new Location();
        x.row = r;
        x.column = c;
        return x;
    }

    /**
     * Returns an array of the eight Locations in the same row as here.
     */
    static Location[] findRow(Location here) {

        Location[] location = new Location[8];

        for (int i = 0; i < location.length; i++) {
            if (i >= here.column) {
                location[i] = createLocation(here.row, i + 1);
            } else {
                location[i] = createLocation(here.row, i);
            }
        }
        return location;
    }

    /**
     * Returns an array of the eight Locations in the same column as here.
     */
    static Location[] findColumn(Location here) {

        Location[] location = new Location[8];

        for (int i = 0; i < location.length; i++) {
            if (i >= here.row) {
                location[i] = createLocation(i + 1, here.column);
            } else {
                location[i] = createLocation(i, here.column);
            }
        }
        return location;
    }

    /**
     * Returns an array of the eight Locations in the same 3x3 block as here.
     */
    static Location[] findBlock(Location here) {
        Location a[] = new Location[8];
        int row = (here.row / 3) * 3;
        int column = (here.column / 3) * 3;
        int count = 0;

        for (int x = row; x <= row + 2; x++) {
            for (int y = column; y <= column + 2; y++) {
                if (x != here.row || y != here.column) {
                    a[count] = createLocation(x, y);
                    count++;
                }
            }
        }
        return a;
    }

    /**
     * Returns a 9x9 array of Squares, each of which has value 0 and knows about the other squares in its row,
     * column, and block.
     */
    static Square[][] createSquares() {
        Square[][] grid = new Square[9][9];

        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                grid[row][col] = new Square();
                grid[row][col].value = 0;
                grid[row][col].row = new Square[8];
                grid[row][col].column = new Square[8];
                grid[row][col].block = new Square[8];
            }
        }

        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                Location[] neighbors_r = findRow(createLocation(row, col));
                Location[] neighbors_c = findColumn(createLocation(row, col));
                Location[] neighbors_b = findBlock(createLocation(row, col));

                for (int i = 0; i < 8; ++i) {
                    grid[row][col].row[i] = grid[neighbors_r[i].row][neighbors_r[i].column];
                    grid[row][col].column[i] = grid[neighbors_c[i].row][neighbors_c[i].column];
                    grid[row][col].block[i] = grid[neighbors_b[i].row][neighbors_b[i].column];
                }
            }
        }
        return grid;
    }

    /**
     * Returns a String representing grid, showing the numbers (or . for squares with value 0).
     */
    static String toString(Square[][] grid) {
        String grid_string = new String();// sus line
        grid_string = "";
        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                if (grid[row][col].value > 0) {
                    grid_string += grid[row][col].value;
                } else {
                    grid_string += ".";
                }

            }
            grid_string += "\n";
        }
        return grid_string;
    }

    /**
     * Returns a 9x9 array of Squares, each of which has value 0 and knows about the other squares in its row,
     * column, and block. Any numbers in diagram are filled in to the grid; empty squares should be given as
     * periods.
     */
    static Square[][] createSquares(String diagram) {
        Square[][] grid = new Square[9][9];

        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                grid[row][col] = new Square();
                grid[row][col].value = 0;
                grid[row][col].row = new Square[8];
                grid[row][col].column = new Square[8];
                grid[row][col].block = new Square[8];
            }
        }

        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                Location[] neighbors_r = findRow(createLocation(row, col));
                Location[] neighbors_c = findColumn(createLocation(row, col));
                Location[] neighbors_b = findBlock(createLocation(row, col));

                for (int i = 0; i < 8; ++i) {
                    grid[row][col].row[i] = grid[neighbors_r[i].row][neighbors_r[i].column];
                    grid[row][col].column[i] = grid[neighbors_c[i].row][neighbors_c[i].column];
                    grid[row][col].block[i] = grid[neighbors_b[i].row][neighbors_b[i].column];
                }
            }
        }

        //String to grid

        int count = 0;
        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                if (count < diagram.length()) {
                    if (diagram.charAt(count) != '.') {
                        grid[row][col].value = diagram.charAt(count) - 48;
                    }
                }
                count++;
            }
            count++;
        }
        return grid;
    }

    /**
     * Returns a boolean array of length 10. For each digit, the corresponding entry in the array is true
     * if that number does not appear elsewhere in s's row, column, or block.
     */
    static boolean[] findValidNumbers(Square s) {
        boolean isValid[] = new boolean[10];
        for (int c = 0; c < 10; c++) {
            isValid[c] = true;
        }
        isValid[0] = false;
        for (int c = 0; c < s.row.length; c++) {
            if (s.row[c].value >= 0) {
                isValid[s.row[c].value] = false;
            }
            if (s.column[c].value >= 0) {
                isValid[s.column[c].value] = false;
            }
            if (s.block[c].value >= 0) {
                isValid[s.block[c].value] = false;
            }
        }
        return isValid;
    }

    /**
     * Returns true if grid can be solved. If so, grid is modified to fill in that solution.
     */
    static boolean solve(Square[][] grid) {
        for (int row = 0; row < 9; ++row) {
            for (int col = 0; col < 9; ++col) {
                if (grid[row][col].value == 0) {
                    for (int c = 0; c < 10; c++) {
                        if (findValidNumbers(grid[row][col])[c]) {
                            grid[row][col].value = c;
                            if (solve(grid) == true) {
                                return true;
                            }
                        }
                    }
                    grid[row][col].value = 0;
                    return false;
                }
            }
        }
        return true;
    }

        // Here's an outline of the algorithm:
        // for each square
        //     if its value is 0
        //         for each valid number that could be filled in
        //             if you can solve the rest of the grid
        //                 return true
        //         nothing worked: set value back to 0 and return false
        // no squares left to fill in: return true
}