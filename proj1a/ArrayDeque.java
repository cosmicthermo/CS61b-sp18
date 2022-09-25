/**
 * Invariants:
 *
 * @param <Item>
 */


public class ArrayDeque<Item> {
    private static final int STARTINGSIZE = 8;
    private static int REFACTOR = 2;
    private int size;
    private Item[] aDeque;

    /**
     * Creates an empty list. Constructor:
     */
    public ArrayDeque() {
        size = 0;
        aDeque = (Item[]) new Object[STARTINGSIZE];
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        System.arraycopy(aDeque, 0, temp, 0, size);
        aDeque = temp;
    }

    private void helperResize() {
        if (size == aDeque.length) {
            resize(aDeque.length * REFACTOR);
        }
    }

    /**
     * The methodolgy is the same as AList, which add to the size number of list and delete the size-1 number.
     */
    public void addFirst(Item item) {
        // defensive code
        helperResize();
        if (size == 0) {
            aDeque[size] = item;
            size++;
        } else {
            Item[] tempDeque = (Item[]) new Object[aDeque.length];
            tempDeque[0] = item;
            System.arraycopy(aDeque, 0, tempDeque, 1, size);
            size++;
        }
    }

    public void addLast(Item item) {
        // defensive code
        helperResize();
        aDeque[size] = item;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i += 1) {
            System.out.print(aDeque[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public Item removeFirst() {
        Item removeItem = aDeque[0];
        for (int i = 1; i < size; i += 1) {
            aDeque[i - 1] = aDeque[i];
        }
        aDeque[size - 1] = null;
        size--;
        return removeItem;
    }

    public Item removeLast() {
        Item removeItem = aDeque[size - 1];
        aDeque[size - 1] = null;
        size--;
        return removeItem;
    }


    public Item get(int index) {
        return null;
    }

    public static void main(String[] args) {
        ArrayDeque testAd1 = new ArrayDeque();
        testAd1.addFirst(9);
    }
}
