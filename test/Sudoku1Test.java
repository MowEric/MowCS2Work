import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Sudoku1Test {

    @Test
    void convertsGridToString() {
        int[][] grid = Sudoku1.createGrid();
        String correct = ".1.......\n" +
                "........8\n" +
                ".........\n" +
                ".........\n" +
                ".........\n" +
                ".........\n" +
                ".........\n" +
                "....5....\n" +
                ".........\n";
        grid[0][1] = 1;
        grid[1][8] = 8;
        grid[7][4] = 5;
        assertEquals(correct, Sudoku1.toString(grid));
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
        int[][] grid = Sudoku1.createGrid(correct);
        assertEquals(correct, Sudoku1.toString(grid));
    }

    @Test
    void validNumberTest() {
        String correct =    ".1.......\n" +
                "........8\n" +
                ".........\n" +
                ".........\n" +
                ".........\n" +
                ".........\n" +
                ".........\n" +
                "....5....\n" +
                ".........\n";
        int[][] grid = Sudoku1.createGrid(correct);
        assertEquals(correct, Sudoku1.toString(grid));
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
        int[][] grid = Sudoku1.createGrid(diagram);
        assertFalse(Sudoku1.solve(grid));
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
        int[][] grid = Sudoku1.createGrid(diagram);
        assertTrue(Sudoku1.solve(grid));
        String correct =    "897312456\n" +
                "613594728\n" +
                "425678913\n" +
                "941867532\n" +
                "538921647\n" +
                "276435891\n" +
                "359186274\n" +
                "764253189\n" +
                "182749365\n";
        assertEquals(correct, Sudoku1.toString(grid));
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
        int[][] grid = Sudoku1.createGrid(diagram);
        assertTrue(Sudoku1.solve(grid));
        String correct =    "897312456\n" +
                "613594728\n" +
                "425678913\n" +
                "941867532\n" +
                "538921647\n" +
                "276435891\n" +
                "359186274\n" +
                "764253189\n" +
                "182749365\n";
        assertEquals(correct, Sudoku1.toString(grid));
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
        int[][] grid = Sudoku1.createGrid(diagram);
        assertTrue(Sudoku1.solve(grid));
        String correct =    "897312456\n" +
                "613594728\n" +
                "425678913\n" +
                "941867532\n" +
                "538921647\n" +
                "276435891\n" +
                "359186274\n" +
                "764253189\n" +
                "182749365\n";
        assertEquals(correct, Sudoku1.toString(grid));
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
        int[][] grid = Sudoku1.createGrid(diagram);
        assertTrue(Sudoku1.solve(grid));
        String correct =    "571692483\n" +
                "943815627\n" +
                "268347591\n" +
                "659723814\n" +
                "412958736\n" +
                "387164952\n" +
                "825436179\n" +
                "136579248\n" +
                "794281365\n";
        assertEquals(correct, Sudoku1.toString(grid));
    }

}