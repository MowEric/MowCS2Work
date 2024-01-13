import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursionITest {

    @Test
    void iterativeSum() {
        assertEquals(0, RecursionI.iterativeSum(0));
        assertEquals(1, RecursionI.iterativeSum(1));
        assertEquals(10, RecursionI.iterativeSum(4));
    }

    @Test
    void recursiveSum() {
        assertEquals(0, RecursionI.recursiveSum(0));
        assertEquals(1, RecursionI.recursiveSum(1));
        assertEquals(10, RecursionI.recursiveSum(4));
    }

}
