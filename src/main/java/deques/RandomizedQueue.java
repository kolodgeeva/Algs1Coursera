package main.java.deques;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 *
 * @param <Item>
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    /**
     * Queue n.
     */
    private int n;

    /**
     * Items.
     */
    private Item[] items = (Item[]) new Object[1];

    /**
     * Construct an empty randomized queue.
     */
    public RandomizedQueue() {

    }

    /**
     * Is the queue empty?
     * @return is empty
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Return the number of items on the queue.
     * @return n
     */
    public int size() {
        return n;
    }

    /**
     * Add the item.
     * @param item item
     */
    public void enqueue(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException();
        }
        if (n == items.length) {
            resize(2 * items.length);
        }
        items[n++] = item;
    }

    /**
     * Resize array.
     * @param max size
     */
    private void resize(final int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < n; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    /**
     * Remove and return items random item.
     * @return item
     */
    public Item dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        int i = StdRandom.uniform(n);
        Item ret = items[i];
        items[i] = items[--n];
        items[n] = null;
        if (items.length / 4 > n) {
            resize(items.length / 2);
        }
        return ret;
    }

    /**
     * Return (but do not remove) items random item.
     * @return item
     */
    public Item sample() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
        return items[StdRandom.uniform(n)];
    }

    /**
     * Return an independent iterator over items in random order.
     * @return iterator
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /**
     * ListIterator.
     */
    private class ListIterator implements Iterator<Item> {

        /**
         * Current index.
         */
        private int current = 0;

        /**
         * Shuffled Indexes.
         */
        private int[] shuffledIndexes = new int[n];

        /**
         * Is has next.
         * @return hasNext
         */
        public boolean hasNext() {
            if (current == 0) {
                for (int i = 0; i < n; i++) {
                    shuffledIndexes[i] = i;
                }
                StdRandom.shuffle(shuffledIndexes);
            }
            return current < n;
        }

        /**
         * Get next.
         * @return next
         */
        public Item next() {
            if (current == 0) {
                for (int i = 0; i < n; i++) {
                    shuffledIndexes[i] = i;
                }
                StdRandom.shuffle(shuffledIndexes);
            }
            if (current >= n || size() == 0) {
                throw new java.util.NoSuchElementException();
            }
            return items[shuffledIndexes[current++]];
        }

        /**
         * Remove.
         */
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    /**
     * Testing.
     * @param args args
     */
    public static void main(String[] args) {

        /* RandomizedQueue<Integer> integers = new RandomizedQueue<>();

        integers.enqueue(1);
        integers.enqueue(2);
        integers.enqueue(3);
        integers.enqueue(4);
        integers.enqueue(5);

        for (Integer integer: integers) {
            StdOut.println("first iterator " + integer);

            for (Integer integer1: integers) {
                StdOut.println("second iterator " + integer1);
            }
        }

        integers.dequeue();
        integers.dequeue();

        for (Integer integer: integers) {
            StdOut.println(integer);
        }

        StdOut.println(integers.sample());
        StdOut.println(integers.sample());
        StdOut.println(integers.sample());
        StdOut.println(integers.sample());
        */

    }
}
