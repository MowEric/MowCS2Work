import java.util.Iterator;

public class LinkedList<E> implements List<E>{

    class Node {
        E val;
        Node next;

        Node (E val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node first;

    public LinkedList() {
        first = null;
    }
    //edit this
    @Override
    public String toString() {
        if (first == null) {
            return "[]";
        }
        else {
            String s = "[";
            Node n = first;
            while (n != null) {
                s += n.val;
                if (n.next != null) {
                    s += ", ";
                }
                n = n.next;
            }
            s += "]";
            return s;
        }
    }

    @Override
    public void add(E item) {
        Node n = new Node(item);
        //add if/else that will do something when the list is initially empty, and something else if the list has at least one element
        if (first == null) {
            first = n;
        } else {
            assert first != null;
            Node tail = first;
            while (tail.next != null) {
                tail = tail.next;
            }
            assert tail != null && tail.next == null;
            tail.next = n;
        }
    }

    public boolean contains(E item) {
        Node current = first;
        while (current != null) {
            if (current.val.equals(item)) {
                return true;
            }
            current = current.next;
        }
        assert current == null;
        return false;
    }

    @Override
    public E get(int i) {
        Node n = first;
        while(i > 0) {
            n = n.next;
            i--;
        }
        return n.val;
    }

    @Override
    public void removeAt(int i) {
        if (i == 0) {
            first = first.next;
        }
        else {
            Node one = first;
            Node two = first.next;
            for (int c = 1; c != i; c++) {
                one = one.next;
                two = two.next;
            }
            one.next = two.next;
        }
    }

    @Override
    public void set(int i, E item) {

    }

    @Override
    public int size() {
        Node n = first;
        int c = 0;
        while (n != null) {
            c++;
            n = n.next;
        }
        return c;
    }

    @Override
    public void clear() {
        first.val = null;
        first.next = null;
    }

    @Override
    public int indexOf(E item) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedList that = (LinkedList) o;
        Node thisNode = this.first;
        Node thatNode = that.first;
        while (thisNode != null && thatNode != null) {
            if (!thisNode.val.equals(thatNode.val)) {
                return false;
            }
            thisNode = thisNode.next;
            thatNode = thatNode.next;
        }
        if (thisNode == thatNode) return true;
        else return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return !(current == null);
        }

        @Override
        public E next() {
            E item = current.val;
            current = current.next;
            return item;
        }
    }

}
