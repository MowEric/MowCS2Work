import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {

    /** This method isn't a test. It's a helper method used in the other tests. */
    static boolean locationsEqual(Location here, Location there) {
        return here.row == there.row && here.column == there.column;
    }

    @Test
    void createsLocation() {
        Location correct = new Location();
        correct.row = 7;
        correct.column = 4;
        assertTrue(locationsEqual(correct, Sudoku.createLocation(7, 4)));
    }

    @Test
    void findsRow() {
        Location here = new Location();
        here.row = 2;
        here.column = 5;
        // Produce correct answer
        Location[] correct = new Location[8];
        int[][] numbers = {{2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {2, 6}, {2, 7}, {2, 8}};
        for (int i = 0; i < correct.length; i++) {
            correct[i] = Sudoku.createLocation(numbers[i][0], numbers[i][1]);
        }
        // Compute answer
        Location[] computed = Sudoku.findRow(here);
        // Verify that they match
        for (int i = 0; i < correct.length; i++) {
            assertTrue(locationsEqual(correct[i], computed[i]));
        }
    }

    @Test
    void findsColumn() {
        Location here = new Location();
        here.row = 2;
        here.column = 5;
        // Produce correct answer
        Location[] correct = new Location[8];
        int[][] numbers = {{0, 5}, {1, 5}, {3, 5}, {4, 5}, {5, 5}, {6, 5}, {7, 5}, {8, 5}};
        for (int i = 0; i < correct.length; i++) {
            correct[i] = Sudoku.createLocation(numbers[i][0], numbers[i][1]);
        }
        // Compute answer
        Location[] computed = Sudoku.findColumn(here);
        // Verify that they match
        for (int i = 0; i < correct.length; i++) {
            assertTrue(locationsEqual(correct[i], computed[i]));
        }
    }

    @Test
    void findsBlock() {
        Location here = new Location();
        here.row = 2;
        here.column = 6;
        // Produce correct answer
        Location[] correct = new Location[8];
        int[][] numbers = {{0, 6}, {0, 7}, {0, 8}, {1, 6}, {1, 7}, {1, 8}, {2, 7}, {2, 8}};
        for (int i = 0; i < correct.length; i++) {
            correct[i] = Sudoku.createLocation(numbers[i][0], numbers[i][1]);
        }
        // Compute answer
        Location[] computed = Sudoku.findBlock(here);
        // Verify that they match
        for (int i = 0; i < correct.length; i++) {
            assertTrue(locationsEqual(correct[i], computed[i]));
        }
    }

    @Test
    void createsSquares() {
        Square[][] grid = Sudoku.createSquares();
        // We're not checking everything here, just looking at a couple of elements
        assertEquals(0, grid[8][3].value);
        // assertSame is similar to assertEquals, but it verifies that the two objects are the same one,
        // not merely copies
        assertSame(grid[6][0], grid[6][1].row[0]);
        assertSame(grid[7][0], grid[4][0].column[6]);
        assertSame(grid[4][6], grid[3][7].block[2]);
    }

    @Test
    void convertsGridToString() {
        Square[][] grid = Sudoku.createSquares();
        String correct = ".1.......\n" +
                         "........8\n" +
                         ".........\n" +
                         ".........\n" +
                         ".........\n" +
                         ".........\n" +
                         ".........\n" +
                         "....5....\n" +
                         ".........\n";
        grid[0][1].value = 1;
        grid[1][8].value = 8;
        grid[7][4].value = 5;
        assertEquals(correct, Sudoku.toString(grid));
    }

    @Test
    void convertsStringToGrid() {
        String correct =    ".1.......\n" +
                            "........8\n" +
                            ".........\n" +
                            ".........\n" +
                            ".........\n" +
                            ".........\n" +
                            ".........\n" +
                            "....5....\n" +
                            ".........\n";
        Square[][] grid = Sudoku.createSquares(correct);
        assertEquals(correct, Sudoku.toString(grid));
    }

    @Test
    void findsValidNumbers() {
        String diagram =    ".........\n" +
                            "..2....4.\n" +
                            ".......7.\n" +
                            "......8..\n" +
                            "...3....1\n" +
                            "........5\n" +
                            ".........\n" +
                            "6..2.....\n" +
                            ".......9.\n";
        Square[][] grid = Sudoku.createSquares(diagram);
        Square s = grid[4][7];
        boolean[] correct = {false, false, true, false, false, false, true, false, false, false};
        assertArrayEquals(correct, Sudoku.findValidNumbers(s));
    }

    @Test
    void rejectsUnsolvablePuzzle() {
        String diagram =    ".12345678\n" +
                            "2........\n" +
                            "3........\n" +
                            "4........\n" +
                            "5........\n" +
                            "6........\n" +
                            "7........\n" +
                            "8........\n" +
                            "9........\n";
        Square[][] grid = Sudoku.createSquares(diagram);
        assertFalse(Sudoku.solve(grid));
    }

    @Test
    void findsOneMissingNumber() {
        // This puzzle adapted from www.puzzles.ca/sudoku/
        String diagram =    "897312456\n" +
                            "613594728\n" +
                            "425678913\n" +
                            "941867532\n" +
                            "538921647\n" +
                            "276435.91\n" +
                            "359186274\n" +
                            "764253189\n" +
                            "182749365\n";
        Square[][] grid = Sudoku.createSquares(diagram);
        assertTrue(Sudoku.solve(grid));
        String correct =    "897312456\n" +
                            "613594728\n" +
                            "425678913\n" +
                            "941867532\n" +
                            "538921647\n" +
                            "276435891\n" +
                            "359186274\n" +
                            "764253189\n" +
                            "182749365\n";
        assertEquals(correct, Sudoku.toString(grid));
    }

    @Test
    void findsTwoMissingNumbers() {
        // This puzzle adapted from www.puzzles.ca/sudoku/
        String diagram =    "897312456\n" +
                "6135..728\n" +
                "425678913\n" +
                "941867532\n" +
                "538921647\n" +
                "276435891\n" +
                "359186274\n" +
                "764253189\n" +
                "182749365\n";
        Square[][] grid = Sudoku.createSquares(diagram);
        assertTrue(Sudoku.solve(grid));
        String correct =    "897312456\n" +
                "613594728\n" +
                "425678913\n" +
                "941867532\n" +
                "538921647\n" +
                "276435891\n" +
                "359186274\n" +
                "764253189\n" +
                "182749365\n";
        assertEquals(correct, Sudoku.toString(grid));
    }

    @Test
    void solvesEasyPuzzle() {
        // This puzzle from www.puzzles.ca/sudoku/
        String diagram =    ".97..24..\n" +
                            "....9..28\n" +
                            "4.567..1.\n" +
                            ".....7...\n" +
                            ".3.......\n" +
                            "..6..5.9.\n" +
                            "...1....4\n" +
                            "764......\n" +
                            "18....36.\n";
        Square[][] grid = Sudoku.createSquares(diagram);
        assertTrue(Sudoku.solve(grid));
        String correct =    "897312456\n" +
                            "613594728\n" +
                            "425678913\n" +
                            "941867532\n" +
                            "538921647\n" +
                            "276435891\n" +
                            "359186274\n" +
                            "764253189\n" +
                            "182749365\n";
        assertEquals(correct, Sudoku.toString(grid));
    }

    @Test
    void solvesHardPuzzle() {
        // This puzzle from www.puzzles.ca/sudoku/
        String diagram =    "...6.2..3\n" +
                            "..3......\n" +
                            "..8..7.91\n" +
                            "6........\n" +
                            ".12.5.7..\n" +
                            ".....49..\n" +
                            "..5.3....\n" +
                            ".3.5....8\n" +
                            "7....1.6.\n";
        Square[][] grid = Sudoku.createSquares(diagram);
        assertTrue(Sudoku.solve(grid));
        String correct =    "571692483\n" +
                            "943815627\n" +
                            "268347591\n" +
                            "659723814\n" +
                            "412958736\n" +
                            "387164952\n" +
                            "825436179\n" +
                            "136579248\n" +
                            "794281365\n";
        assertEquals(correct, Sudoku.toString(grid));
    }

}