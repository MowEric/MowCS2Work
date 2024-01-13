import java.util.Iterator;
import java.util.Objects;

public class ArrayList<E> implements List<E> {

    private E[] items = (E[]) new Object[1];
    private int size = 0;

    @Override
    public void add(E item) {
        if (size >= items.length) resize(2*items.length);
        assert size < items.length;
        items[size++] = item;
    }

    @Override
    public boolean contains(E item) {
        if (size == 0) return false;
        for (int i = 0; i < size; ++i) {
            if (items[i] == item) return true;
        }
        return false;
    }

    public void set(){

    }

    private void resize(int capacity) {
        E[] temp = (E[])new Object[capacity];
        for (int i = 0; i < size; ++i) {
            temp[i] = items[i];
        }
        items = temp;
    }

    @Override
    public void clear() {
        items = (E[]) new Object[1];
        size = 0;
    }

    @Override
    public E get(int i) {
        return items[i];
    }

    @Override
    public int indexOf(E item) {
        for (int i = 0; i < size; ++i) {
            if (items[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void removeAt(int i) {
        for (int c = i; c < size - 1; c++) {
            items[c] = items[c+1];
        }
        items[size - 1] = null;
        --size;
    }

    @Override
    public void set(int i, E item) {
        items[i] = item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        String s = "[";
        for (int i = 0; i < size-1; ++i) {
            s += items[i] + ", ";
        }
        return (s + items[size - 1] + "]");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayList<?> that = (ArrayList<?>)o;
        if (this.size != that.size) return false;
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(items[i], that.items[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public E next() {
//            E val = items[current];
//            current++;
//            return val;
            return items[current++];
        }
    }
}