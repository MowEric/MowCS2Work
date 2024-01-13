import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void gettersAndSettersWork() {
        Vector v = new Vector(8.0, 5.0);
        assertEquals(8, v.getX(), 0.0001);
        assertEquals(5, v.getY(), 0.0001);
        v.setX(-2);
        v.setY(10);
        assertEquals(-2, v.getX(), 0.0001);
        assertEquals(10, v.getY(), 0.0001);
    }

    @Test
    void zeroArgumentConstructorWorks() {
        assertEquals("<0.0, 0.0>", new Vector().toString());
    }

    @Test
    void equalsWorks() {
        assertEquals(new Vector(1, 2), new Vector(1, 2));
        assertNotEquals(new Vector(7, 7), new Vector(7, 3));
    }

    @Test
    void addsCorrectly() {
        Vector a = new Vector(1, 2);
        Vector b = new Vector(4, 6);
        assertEquals("<5.0, 8.0>", a.plus(b).toString());
    }

    @Test
    void plusDoesNotModifyOriginalVectors() {
        Vector a = new Vector(1, 2);
        Vector b = new Vector(4, 6);
        a.plus(b);
        assertEquals("<1.0, 2.0>", a.toString());
        assertEquals("<4.0, 6.0>", b.toString());
    }

    @Test
    void subtractsCorrectly() {
        Vector a = new Vector(1, 2);
        Vector b = new Vector(4, 6);
        assertEquals("<-3.0, -4.0>", a.minus(b).toString());
    }

    @Test
    void computesDotProductCorrectly() {
        Vector a = new Vector(1, 2);
        Vector b = new Vector(4, 6);
        assertEquals(16, a.dot(b));
    }

    @Test
    void computesScalarProductCorrectly() {
        Vector a = new Vector(1, 2);
        assertEquals("<3.0, 6.0>", a.times(3).toString());
    }

    @Test
    void computesDistanceCorrectly() {
        Vector a = new Vector(0, 3);
        Vector b = new Vector(4, 0);
        assertEquals(5.0, a.distanceTo(b), 0.0001);
    }

}