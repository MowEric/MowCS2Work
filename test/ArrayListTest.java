import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    private List<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<Integer>();
    }

    @Test
    void isInitiallyEmpty() {
        assertEquals("[]", list.toString());
    }

    @Test
    void adds() {
        list.add(5);
        list.add(2);
        list.add(8);
        assertEquals("[5, 2, 8]", list.toString());
    }

    @Test
    void clears() {
        list.add(5);
        list.add(2);
        list.add(8);
        list.clear();
        assertEquals("[]", list.toString());
    }

    @Test
    void containsFindsFirstItem() {
        list.add(5);
        list.add(2);
        list.add(8);
        assertTrue(list.contains(5));
    }

    @Test
    void containsFindsLastItem() {
        list.add(5);
        list.add(2);
        list.add(8);
        assertTrue(list.contains(8));
    }

    @Test
    void containsFindsIntermediateItem() {
        list.add(5);
        list.add(2);
        list.add(8);
        assertTrue(list.contains(2));
    }

    @Test
    void containsDoesNotFindAbsentItem() {
        list.add(5);
        list.add(2);
        list.add(8);
        assertFalse(list.contains(4));
    }

    @Test
    void gets() {
        list.add(5);
        list.add(2);
        list.add(8);
        assertEquals(8, list.get(2));
    }

    @Test
    void findsIndexOfFirstItem() {
        list.add(5);
        list.add(2);
        list.add(8);
        assertEquals(0, list.indexOf(5));
    }
    @Test
    void findsIndexOfLastItem() {
        list.add(5);
        list.add(2);
        list.add(8);
        assertEquals(2, list.indexOf(8));
    }
    @Test
    void findsIndexOfIntermediateItem() {
        list.add(5);
        list.add(2);
        list.add(8);
        assertEquals(1, list.indexOf(2));
    }
    @Test
    void doesNotFindIndexOfAbsentItem() {
        list.add(5);
        list.add(2);
        list.add(8);
        assertEquals(-1, list.indexOf(4));
    }

    @Test
    void findsFirstIndexOfRepeatedItem() {
        list.add(5);
        list.add(2);
        list.add(7);
        list.add(2);
        list.add(8);
        assertEquals(1, list.indexOf(2));
    }

    @Test
    void removesFirstItem() {
        list.add(5);
        list.add(2);
        list.add(8);
        list.removeAt(0);
        assertEquals("[2, 8]", list.toString());
    }

    @Test
    void removesLastItem() {
        list.add(5);
        list.add(2);
        list.add(8);
        list.removeAt(2);
        assertEquals("[5, 2]", list.toString());
    }

    @Test
    void removesIntermediateItem() {
        list.add(5);
        list.add(2);
        list.add(8);
        list.removeAt(1);
        assertEquals("[5, 8]", list.toString());
    }

    @Test
    void sets() {
        list.add(5);
        list.add(2);
        list.add(8);
        list.set(2, 7);
        assertEquals("[5, 2, 7]", list.toString());
    }

    @Test
    void findsSize() {
        list.add(5);
        list.add(2);
        list.add(8);
        assertEquals(3, list.size());
    }

    @Test
    void equalsWorks() {
        list.add(5);
        list.add(2);
        list.add(8);
        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(2);
        assertNotEquals(list, list2);
        list2.add(8);
        assertEquals(list, list2);
    }

    @Test
    void equalsWorksAfterDeletion() {
        list.add(5);
        list.add(2);
        list.add(8);
        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(2);
        list2.add(8);
        list2.add(9);
        list2.removeAt(3);
        assertEquals(list, list2);
    }

    @Test
    void isIterable() {
        list.add(5);
        list.add(2);
        list.add(8);
        int sum = 0;
        for (Integer n : list) {
            sum += n;
        }
        assertEquals(15, sum);
    }

    @Test
    void isGeneric() {
        List<String> list = new ArrayList<String>();
        list.add("eggs");
        list.add("bread");
        list.add("tea");
        assertEquals("[eggs, bread, tea]", list.toString());
    }

}