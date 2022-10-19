/**
 * In this project, we will follow the instruction of proj1a to reconstruct the
 * Double queue with circular sentinel topology that introduced in lecture 2.3.
 * Deque (usually pronounced like “deck”) is an irregular acronym of double-ended queue.
 * Double-ended queues are sequence containers with dynamic sizes that can be expanded or
 * contracted on both ends (either its front or its back).
 */

/**
 * Invariants:
 * Sentinel reference always points to sentinel node.
 * Sentinel node points to the first node and last node by prev and next.
 * The size always indicates the number of nodes in this linkedlist.
 *
 * @param <T>
 */
public class LinkedListDeque<T> {
    private class ItemNode {
        private ItemNode prev;
        private T item;
        private ItemNode next;

        // This is a method for initialization.
        public ItemNode(T i, ItemNode pv, ItemNode nt) {
            item = i;
            prev = pv;
            next = nt;
        }

        public ItemNode(T i) {
            item = i;
        }
    }

    private int size;
    private ItemNode sentinel;

    /**
     * Create an empty LinkedListDeque
     */
    public LinkedListDeque() {
        size = 0;
        // Initialize sentinel.
        sentinel = new ItemNode(null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /**
     * Use the inspiration of youtube tips
     *
     * @source https://www.youtube.com/watch?v=JNroRiEG7U4
     */
//    public LinkedListDeque(LinkedListDeque other) {
//        size = 0;
//        // Initialize sentinel.
//        sentinel = other.sentinel;
//        sentinel.next = sentinel;
//        sentinel.prev = sentinel;
//
//        for (int i = 0; i < other.size(); i += 1) {
//            addLast((T) other.get(i));
//        }
//    }

    // senti >< , < first > senti.
    // senti >< , < first > senti , < second > senti
    public void addFirst(T item) {
        ItemNode firstNode = new ItemNode(item, sentinel, null);
        // Case 1 when size = 0
        if (size == 0) {
            firstNode.next = sentinel;
            sentinel.next = firstNode;
            sentinel.prev = firstNode;
        } else {
            // Case 2 when size > 0
            firstNode.next = sentinel.next;
            sentinel.next.prev = firstNode;
            sentinel.next = firstNode;
        }
        size++;
    }

    // last -><- senti
    // last -><- newlast -><- senti
    public void addLast(T item) {
        ItemNode lastNode = new ItemNode(item, null, sentinel);
        // Case 1 when size = 0
        if (size == 0) {
            lastNode.prev = sentinel;
            sentinel.next = lastNode;
            sentinel.prev = lastNode;
        } else {
            // Case 2 when size > 0
            lastNode.prev = sentinel.prev;
            sentinel.prev.next = lastNode;
            sentinel.prev = lastNode;
        }
        size++;
    }

    /**
     * Prints the items in the deque from first to last,
     * separated by a space. Once all the items have been printed,
     * print out a new line
     */
    public void printDeque() {
        ItemNode temp = sentinel;
        temp = temp.next;
        while (temp != sentinel) {
            System.out.print(temp.item);
            System.out.print(" ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null
     */
    // senti -> <- 1 -> <- 2
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T itemReturn = (T) sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;

        size--;
        return itemReturn;
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns
     */
    //  n-1 -> <- n -> <- senti
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T itemReturn = (T) sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;

        size--;
        return itemReturn;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /**
     * Gets the item at the given index,
     * where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null.
     * Must not alter the deque!
     */
    public T get(int index) {
        if (size == 0 || index >= size) {
            return null;
        }
        ItemNode temp = sentinel.next;
        while (index > 0) {
            temp = temp.next;
            index--;
            if (temp.item.equals(sentinel.item)) {
                return null;
            }
        }
        return temp.item;
    }

    /**
     * Same functionality as get method but with recursive loop
     */
    public T getRecursive(int index) {
        if (size == 0 || index >= size) {
            return null;
        }
        ItemNode temp = sentinel.next;
        return getRecursive(index, temp);
    }

    private T getRecursive(int index, ItemNode temp) {
        if (index == 0) {
            return temp.item;
        } else {
            return (T) getRecursive(--index, temp.next);
        }

    }


}
