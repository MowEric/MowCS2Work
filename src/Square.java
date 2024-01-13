/** One square in the Sudoku grid. */
public class Square {

    /** 1 through 9, or 0 if this square doesn't have a value yet. */
    int value;

    /** Other squares in the same row with this one. */
    Square[] row;

    /** Other squares in the same column with this one. */
    Square[] column;

    /** Other squares in the same 3x3 block with this one. */
    Square[] block;

}
