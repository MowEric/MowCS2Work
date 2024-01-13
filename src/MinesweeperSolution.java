public class MinesweeperSolution {

    class MineLocation {
        boolean mine;
        boolean uncovered;
    }

    public static void main(String[] unused) {

        StdOut.println("Welcome to Minesweeper!");
        int NUM_MINES = 10;
        boolean minefield[][] = new boolean[10][10];
        boolean uncovered[][] = new boolean[10][10];
        initMinefield(minefield, NUM_MINES);
        //MineLocation minefield = new MineLocation[10][10];

        StdDraw.setScale(-0.5, 9.5);

        drawMinefield(minefield, uncovered);

        // Event loop
        for (;;) {
            handleMouseClick(minefield, uncovered);
            drawMinefield(minefield, uncovered);
            if (hasWon(minefield, uncovered)) {
                StdOut.println("You won!");
                break;
            }
        }

    }

    public static boolean hasWon(boolean[][] minefield, boolean[][] uncovered) {
        for (int x = 0; x < minefield.length; ++x) {
            for (int y = 0; y < minefield.length; ++y) {
                if (!minefield[x][y] && !uncovered[x][y]) return false;
            }
        }
        return true;
    }

    public static void handleMouseClick(boolean[][] minefield, boolean[][] uncovered) {
        while (!StdDraw.isMousePressed()) {
            // do nothing
        }

        int x = (int)Math.round(StdDraw.mouseX());
        int y = (int)Math.round(StdDraw.mouseY());

        while (StdDraw.isMousePressed()) {
            // do nothing
        }

        uncover(minefield, uncovered, x, y);

        if (minefield[x][y]) {
            StdOut.println("BOOM");
        }
    }

    /**
     * Uncovers the location identified by the given coordinates.  If
     * the location has no neighboring mines, uncovers all neighboring
     * locations and continues this process until there are no more
     * locations to uncover or these locations have at least one
     * neighboring mine.
     * @param minefield a two-dimensional minefield
     * @param uncovered a two-dimensional record of what is uncovered so far
     * @param x         x-coordinate of mine location
     * @param y         y-coordinate of mine location
     */
    public static void uncover(boolean[][] minefield, boolean[][] uncovered, int x, int y) {
        uncovered[x][y] = true;
        if (countNeighboringMines(minefield, x, y) == 0) {
            percolate(minefield, uncovered);
        }
    }

    public static void percolate(boolean[][] minefield, boolean[][] uncovered) {
        while (true) {
            boolean equilibriumReached = true;
            for (int x = 0; x < minefield.length; ++x) {
                for (int y = 0; y < minefield.length; ++y) {
                    if (hasAMineFreeAndUncoveredNeighbor(minefield, uncovered, x, y)) {
                        if (!uncovered[x][y]) {
                            equilibriumReached = false;
                            uncovered[x][y] = true;
                        }
                    }
                }
            }
            if (equilibriumReached) return;
        }
    }

    public static boolean hasAMineFreeAndUncoveredNeighbor(boolean[][] minefield, boolean[][] uncovered, int x, int y) {
        for (int x1 = x - 1; x1 <= x + 1; ++x1) {
            for (int y1 = y - 1; y1 <= y + 1; ++y1) {
                if (x1 >= 0 && x1 < minefield.length &&
                        y1 >= 0 && y1 < minefield.length &&
                        (x1 != x || y1 != y) &&
                        uncovered[x1][y1] &&
                        countNeighboringMines(minefield, x1, y1) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* Place mines at random locations in the minefield. */
    public static void initMinefield(boolean[][] minefield, int numMines) {
        for (int i = 0; i < numMines; ++i) {
            int x = StdRandom.uniform(minefield.length); // random number between [0 ... minefield.length)
            int y = StdRandom.uniform(minefield[0].length);
            if (minefield[x][y]) { // Is there already a mine here?
                --i;
            }
            else {
                minefield[x][y] = true;
            }
        }
    }

    public static void drawMinefield(boolean[][] minefield, boolean[][] uncovered) {
        StdDraw.clear();
        for (int x = 0; x < 10; ++x) {
            for (int y = 0; y < 10; ++y) {
                if (!uncovered[x][y]) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.filledSquare(x, y, 0.5);
                    StdDraw.setPenColor(StdDraw.BLACK);
                }
                else if (minefield[x][y]) {
                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledCircle(x, y, 0.3);
                    StdDraw.setPenColor(StdDraw.BLACK);
                }
                else {
                    int count = countNeighboringMines(minefield, x, y);
                    if (count != 0) StdDraw.text(x, y, Integer.toString(count));
                }
                StdDraw.square(x, y, 0.5);
            }
        }
    }

    /**
     * Counts the number of mines located immediately next
     * to the mine identified by the given coordinates.
     * @param minefield a two-dimensional minefield
     * @param x         x-coordinate of mine location
     * @param y         y-coordinate of mine location
     * @return          the number of mines next to the given mine
     */
    public static int countNeighboringMines(boolean[][] minefield,
                                            int x, int y) {
        int count = 0;
        for (int x1 = x - 1; x1 <= x + 1; ++x1) {
            for (int y1 = y - 1; y1 <= y + 1; ++y1) {
                if (x1 >= 0 && x1 < minefield.length &&
                        y1 >= 0 && y1 < minefield.length &&
                        (x1 != x || y1 != y)) {
                    if (minefield[x1][y1]) ++count;
                }
            }
        }
        return count;
    }

}