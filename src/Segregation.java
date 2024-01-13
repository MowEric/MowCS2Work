//Coded by Eric Mow and Andrew Fowler

public class Segregation {

    static public void main(String[] unused) {

        StdDraw.enableDoubleBuffering();

        double similarity = .3;
        double redBlue = .5;
        double empty = .1;
        int size = 50;

        int field[][] = new int[size][size];
        StdDraw.setScale(-.5, size-0.5);

        initField(field, empty, redBlue, size);
        drawField(field, size);

        simulate(field, similarity, empty, size);
    }


    /**Task List:
     * make isUnsatisfied function
     * make moveUnsatisfied function
     *
     */

    // Event Loop
    public static void simulate(int field[][], double similarity, double empty, int size) {
        int movesPerUpdate = 1;
        while (movesPerUpdate > 0) {
            movesPerUpdate = 0;
            for (int x = 0; x < field.length; ++x) {
                for (int y = 0; y < field.length; ++y) {
                    if (isSatisfied(field, x, y, similarity) == false && field[x][y] != 0) { //added extra statement
                        moveUnsatisfied(field, x, y, empty);
                        movesPerUpdate++;
                    }
                }
            }
            if (movesPerUpdate == 0) {
                StdOut.println("All agents are satisfied! :) 汉语的翻译：所有的人都很满意!");
            }
            drawField(field, size);
        }
    }

    public static boolean isSatisfied(int[][] field,
                                      int x, int y, double similarity) {
        int numNeighbors = 0;
        int numSatisfied = 0;
        for (int x1 = x - 1; x1 <= x + 1; ++x1) {
            for (int y1 = y - 1; y1 <= y + 1; ++y1) {
                if (x1 >= 0 && x1 < field.length &&
                        y1 >= 0 && y1 < field.length &&
                        (x1 != x || y1 != y)) {
                    if (field[x1][y1] > 0) {
                        ++numNeighbors;
                    }
                    if (field[x1][y1] == field[x][y]) {
                        ++numSatisfied;
                    }
                }
            }
        }

        if ((double)numSatisfied/numNeighbors >= similarity || numNeighbors == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void moveUnsatisfied(int field[][], int x, int y, double empty) {
        int emptyX[] = new int[(int)(field.length * field[0].length * empty)];
        int emptyY[] = new int[(int)(field.length * field[0].length * empty)];
        int c = 0;
        for (int x1 = 0; x1 < field.length; ++x1) {
            for (int y1 = 0; y1 < field.length; ++y1) {
                if (field[x1][y1] == 0) {
                    emptyX[c] = x1;
                    emptyY[c] = y1;
                    c++;
                }
            }
        }
        int rand = StdRandom.uniform((int)(field.length * field[0].length * empty));
        field[emptyX[rand]][emptyY[rand]] = field[x][y];
        field[x][y] = 0;
        //StdOut.println("Switched " + x + ", " + y + " and " + emptyX[rand] + ", " + emptyY[rand]);
    }

    public static void drawField(int[][] field, int size) {
        StdDraw.clear();
        for (int x = 0; x < size; ++x) {
            for (int y = 0; y < size; ++y) {
                if (field[x][y] == 0) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.filledSquare(x, y, 0.5);
                } else if (field[x][y] == 1) {
                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledSquare(x, y, 0.5);
                } else {
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.filledSquare(x, y, 0.5);
                }
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.square(x, y, 0.5);

            }
        }
        StdDraw.show();
        while (!StdDraw.isMousePressed()) {
            //do nothing
        }
        while (StdDraw.isMousePressed()) {
            //do nothing
        }
    }

    public static void initField(int[][] field, double empty, double redBlue, int size) {
        int numEmpty = (int) (size * size * empty);
        int numRed = (int) ((size * size - numEmpty) * redBlue);
        int numBlue = (int) ((size * size - numEmpty) * (1 - redBlue));
        int redCount = 0;
        int blueCount = 0;
        for (int x = 0; x < field.length; ++x) {
            for (int y = 0; y < field.length; ++y) {
                field[x][y] = 0;
            }
        }
        for (int i = size * size; i > numEmpty; i--) {

            int x = StdRandom.uniform(field.length); // random number between [0 ... minefield.length)
            int y = StdRandom.uniform(field[0].length);
            if (field[x][y] > 0) { // Is there already a mine here?
                i++;
            } else if (redCount < numRed) {
                field[x][y] = 1;
                redCount++;
            } else if (blueCount < numBlue) {
                field[x][y] = 2;
                blueCount++;
            }

        }
    }
}