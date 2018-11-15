package main.java.deques;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Deque.
 * @param <Item> item
 */
public class Deque<Item> implements Iterable<Item> {

    /**
     * First item.
     */
    private Node<Item> first;

    /**
     * Last item.
     */
    private Node<Item> last;

    /**
     * Size.
     */
    private int size;

    /**
     * Node.
     * @param <Item> item
     */
    private class Node<Item> {

        /**
         * Node item.
         */
        public Item item;

        /**
         * Prev and next item.
         */
        public Node<Item> prev;
        public Node<Item> next;

        /**
         * Create item.
         * @param i item
         */
        public Node(final Item i) {
            if (i == null) {
                throw new NullPointerException();
            }
            this.item = i;
        }

        /**
         * Link new next value.
         * @param newNext new next
         */
        public void linkNext(Node<Item> newNext) {
            this.next = newNext;
            newNext.prev = this;
        }


    }

    /**
     * Construct an empty deque.
     */
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Is the deque empty?
     * @return isEmpty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return the number of items on the deque.
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * Add the item to the front.
     * @param item item
     */
    public void addFirst(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<>(item);
        if (oldFirst != null) {
            first.linkNext(oldFirst);
        } else {
            last = first;
        }
        size++;
    }

    /**
     * Add the item to the end.
     * @param item item
     */
    public void addLast(Item item) {
        Node<Item> oldLast = last;
        last = new Node<>(item);
        if (oldLast != null) {
            oldLast.linkNext(last);
        } else {
            first = last;
        }
        size++;
    }

    /**
     * Remove and return the item from the front.
     * @return first
     */
    public Item removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node<Item> oldFirst = first;
        first = first.next;
        oldFirst.next = null;
        if (first != null) {
            first.prev = null;
            size--;
            return first.item;
        }
        return null;
    }

    /**
     * Remove and return the item from the end.
     * @return last
     */
    public Item removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node<Item> oldLast = last;
        last = last.prev;
        oldLast.prev = null;
        if (last != null) {
            last.next = null;
            size--;
            return last.item;
        }
        return null;
    }

    /**
     * Return an iterator over items in order from front to end.
     * @return iterator
     */
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    /**
     * Iterator
     * @param <Item> item
     */
    private class ListIterator<Item> implements Iterator<Item> {

        /**
         * Current item.
         */
        private Node<Item> current;

        /**
         * Create iterator.
         * @param first first item
         */
        public ListIterator(final Node<Item> first) {
            current = first;
        }

        /**
         * Is has next.
         * @return hasNext
         */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Remove item.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /**
         * Get next item.
         * @return next
         */
        public Item next() {
            if (!hasNext())  {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * Testing.
     * @param args args
     */
    public static void main(final String[] args) {
        /* Deque deque = new Deque();

        deque.addLast(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addFirst(4);

        deque.removeFirst();
        deque.removeLast();

        for (Object i: deque) {
            System.out.println(i);
        }
        */
    }
}
