import static org.junit.jupiter.api.Assertions.*;

class MinesweeperTest {

    @org.junit.jupiter.api.Test
    void countNeighboringMines() {
        boolean[][] minefield = new boolean[3][3];
        minefield[0][0] = true;
        minefield[0][1] = true;

        assertEquals(2, minesweeper.countNeighboringMines(minefield, 1,1));
        assertEquals(0, minesweeper.countNeighboringMines(minefield, 2,2));
    }

    @org.junit.jupiter.api.Test
    void uncover() {
        boolean[][] minefield = new boolean[3][3];
        minefield[0][0] = true;
        minefield[0][1] = true;
        boolean[][] uncovered = new boolean[3][3];
        boolean[][] expected = new boolean[3][3];
        expected[2][0] = true;
        expected[2][1] = true;
        expected[2][2] = true;

        minesweeper.uncover(minefield, uncovered, 2, 2);
        assertArrayEquals(expected, uncovered);
    }

}