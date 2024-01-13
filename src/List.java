public interface List<T> extends Iterable<T> {

    /** Adds item to the end of this list. */
    public void add(T item);

    /** Removes all elements from this list. */
    public void clear();

    /** Returns true if item equals some element in this list. */
    public boolean contains(T item);

    /**
     * Returns the element at position i in this list. It is assumed that i is at least 0 and less than the size of
     * this list.
     */
    public T get(int i);

    /**
     * Returns the index of the first element of this list that equals item. If there is no such element, returns -1.
     */
    public int indexOf(T item);

    /**
     * Removes the ith element from this list. It is assumed that i is at least 0 and less than the size of this list.
     */
    public void removeAt(int i);

    /**
     * Replaces the ith element of this list with item. It is assumed that i is at least 0 and less than the size of
     * this list.
     */
    public void set(int i, T item);

    /** Returns the number of elements in this list. */
    public int size();

}