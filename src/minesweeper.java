import java.awt.*;

// MineSweeperSolution.java is the working code! This one was a test to see if another solution would work

public class minesweeper {

    public static void main(String[] args) {
        StdOut.println("It's mining time");
        boolean minefield[][] = new boolean[10][10];
        boolean uncovered[][] = new boolean[10][10];
        int numMines = 10;
        StdDraw.setScale(-0.5, 9.5);
        initMinefield(minefield, numMines);
        drawMinefield(minefield, uncovered);

        while (true) {
            handleMouseClick(minefield, uncovered);
            drawMinefield(minefield, uncovered);
            if (hasWon(minefield, uncovered)) {
                StdOut.println("Good Job");
                break;
            }
        }
    }
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

    public static void handleMouseClick(boolean[][] minefield, boolean[][] uncovered) {
        while (!StdDraw.isMousePressed()) {
            //do nothing
        }
        int x = (int)Math.round(StdDraw.mouseX());
        int y = (int)Math.round(StdDraw.mouseY());

        while (StdDraw.isMousePressed()) {
            //do nothing
        }
        uncover(minefield, uncovered, x, y);
    }

    public static void uncover(boolean[][] minefield, boolean[][] uncovered, int x, int y) {
        uncovered[x][y] = true;
        if (countNeighboringMines(minefield, x, y) == 0) {
            percolate(minefield, uncovered);
        }
    }

    public static int countNeighboringMines(boolean[][] minefield, int x, int y) {
        int scanX = 0;
        int scanY = 0;
        int mineRange = 0;
        for (int x1 = -1; x1 <= 1; x1++) {
            for (int y1 = -1; y1 <= 1; y1++) {
                scanX = x + x1;
                scanY = y + y1;
                if (scanX >= 0 && scanX < minefield.length && scanY >= 0 && scanY < minefield.length && (x1 != x || y1 != y)) {
                    if (minefield[scanX][scanY]) {
                        mineRange++;
                    }
                }
            }
        }
        return mineRange;
    }

    public static void percolate (boolean[][] minefield, boolean[][] uncovered) {
        boolean done = false;
        while (!done) {
            done = true;
            for (int x = 0; x < minefield.length; x++) {
                for (int y = 0; y < minefield.length; y++) {
                    if (hasNeighbor(minefield, uncovered, x, y)) {
                        uncovered[x][y] = true;
                        done = false;
                    }
                }
            }
            if (done) return;
        }
    }

    public static boolean hasNeighbor(boolean[][] minefield, boolean[][] uncovered, int x, int y) {
        for (int xtest = -1; xtest<=1; xtest++) {
            for (int ytest = -1; ytest<=1; ytest++) {
                xtest = x + xtest;
                ytest = y + ytest;
                if ((xtest != x || ytest != y) && xtest >= 0 && xtest < minefield.length && ytest >= 0
                        && ytest < minefield.length && countNeighboringMines(minefield, xtest, ytest) == 0
                        && uncovered[xtest][ytest]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasWon(boolean[][] minefield, boolean[][] uncovered) {
        for (int x1 = 0; x1<minefield.length; x1++) {
            for (int y1 = 0; y1<minefield.length; y1++) {
                if (!uncovered[x1][y1] && !minefield[x1][y1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
    /*public static void initMinefield(boolean[][] minefield, int minesLeft) {
        while (minesLeft < 10) {
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 10; y++) {
                    if (Math.random() <= .1 && minefield[x][y] != true) {
                        minefield[x][y] = true;
                        minesLeft++;
                        if (minesLeft <= 0) {
                            return;
                        }
                    } else {
                        minefield[x][y] = false;
                    }
                }
            }
        }
    }*/

        /*private static void percolate(boolean[][] minefield, boolean[][] uncovered, int x, int y) {
        uncovered[x][y] = true;
        int scanX, scanY;
        for (int c1 = -1; c1 <= 1; c1++) {
            for (int c2 = -1; c2 <= 1; c2++) {
                scanX = x + c1;
                scanY = y + c2;
                if (scanX >= 0 && scanX <= 9 && scanY >= 0 && scanY <= 9 && (scanX != x || scanY != y)) {
                    if (countNeighboringMines(minefield, scanX, scanY) == 0) {
                        StdDraw.setPenColor(Color.lightGray);
                        StdDraw.filledSquare(scanX, scanY,.5);
                        percolate(minefield, uncovered, scanX, scanY);
                        uncovered[scanX][scanY] = true;
                    }
                }
                else if (scanX >= 0 && scanX <= 9 && scanY >= 0 && scanY <= 9) {
                    if (countNeighboringMines(minefield, scanX, scanY) > 0) {
                        StdDraw.setPenColor(Color.lightGray);
                        StdDraw.filledSquare(scanX, scanY,.5);
                        StdDraw.text(x, y, "" + countNeighboringMines(minefield, scanX, scanY));
                        uncovered[scanX][scanY] = true;
                    }

                }
            }
        }
        return;
    }*/


/*
public static void uncover (boolean[][] minefield, boolean[][] uncovered, int x, int y) {
        uncovered[x][y] = true;
        if (countNeighboringMines(minefield,x, y) == 0) {
            percolate(minefield, uncovered);
        }
    }


    public static boolean hasNeighbor(boolean[][] minefield, boolean[][] uncovered, int x, int y) {
        for (int x1 = x - 1; x1 <= x-1; ++x1) {
            for (int y1 = y - 1; y1 <= y - 1; ++y1) {
                if (x1 >= 0 && x1 < minefield.length && y1>= 0 && y1 < minefield.length && (x1 != x || y1 != y) &&) {

                }
            }
        }
    }
    public static void percolate (boolean[][] minefield, boolean[][] uncovered) {
        for (int x = 0; x < minefield.length; ++x) {
            for (int y = 0; y < minefield.length; ++y) {
                if (hasNeighbor(minefield,uncovered, x, y)) {
                    uncovered[x][y] = true;
                }
            }
        }
    }
 */