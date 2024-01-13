//Coded by Andrew Fowler and Eric Mow

import static org.junit.jupiter.api.Assertions.*;

class SegregationTest {

    @org.junit.jupiter.api.Test
    void isSatisfied() {
        int[][] field = new int[3][3];
        field[0][0] = 0;
        field[0][1] = 0;
        field[0][2] = 0;
        field[1][0] = 0;
        field[1][1] = 1;
        field[1][2] = 0;
        field[2][0] = 0;
        field[2][1] = 0;
        field[2][2] = 0;
        assertEquals(true, Segregation.isSatisfied(field, 1,1, .3));
    }

    @org.junit.jupiter.api.Test
    void isSatisfied2() {
        int[][] field = new int[3][3];
        field[0][0] = 1;
        field[0][1] = 2;
        field[0][2] = 0;
        field[1][0] = 2;
        field[1][1] = 1;
        field[1][2] = 0;
        field[2][0] = 1;
        field[2][1] = 1;
        field[2][2] = 1;
        assertEquals(false, Segregation.isSatisfied(field, 1,0, .3));
        assertEquals(true, Segregation.isSatisfied(field, 1,1, .3));
    }

   @org.junit.jupiter.api.Test
    void moveUnsatisfied() {
        int[][] field = {{2, 2, 1, 1, 1},
                        {2, 2, 1, 1, 1},
                        {2, 1, 2, 1, 1},
                        {2, 2, 2, 1, 0},
                        {2, 2, 2, 1, 1}};
        int[][] expected = {{2, 2, 1, 1, 1},
                            {2, 2, 1, 1, 1},
                            {2, 0, 2, 1, 1},
                            {2, 2, 2, 1, 1},
                            {2, 2, 2, 1, 1}};
        Segregation.moveUnsatisfied(field, 2, 1, .04);
       for (int i = 0; i < expected.length; i++) {
           assertArrayEquals(expected[i], field[i]);
       }
    }
}