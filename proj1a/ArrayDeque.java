/**
 * Structure:
 * The general idea of this ArrayDeque is that add and remove is constant time.
 * By using a circular arraydeque, time limit can be achieved except for the boundary case.
 * 1. construct the arrayDeque without considering the resizing function, containing addFirstLast
 * removeFirstLast. Done
 * 2. Resizing the array, which you can consider the first case of the slide.
 *
 * @param <T>
 */

public class ArrayDeque<T> {
    /**
     * Defining variables and constant.
     */
    private static final int STARTINGSIZE = 8;
    private static int REFACTOR = 2;
    private static double DOWNFACTOR = 4;
    private int size;
    private T[] aDeque;
    // This is to record the index of first and last item.
    private int nextLast;
    private int nextFirst;

    // Correcting the index for the list.

    /**
     * Creates an empty list. Constructor:
     */
    public ArrayDeque() {
        size = 0;
        aDeque = (T[]) new Object[STARTINGSIZE];
        nextLast = STARTINGSIZE / 2;
        nextFirst = nextLast - 1;
    }

    private void resize(int factor) {
        T[] temp = (T[]) new Object[aDeque.length * REFACTOR];
        System.arraycopy(aDeque, 0, temp, 0, nextFirst + 1);
        int secondHalfSize = size - (nextFirst + 1);
        System.arraycopy(aDeque, nextFirst + 1, temp, temp.length - secondHalfSize, secondHalfSize);
        nextFirst = temp.length - secondHalfSize - 1;
        aDeque = temp;
    }

    /**
     * Similar to AList, but it changes the nextFirst index
     */
    public void addFirst(T item) {
        if (size >= aDeque.length) {
            resize(REFACTOR);
        }
        // Resigning the index to nextFirst index.
        if (nextFirst < 0) {
            nextFirst = aDeque.length - 1;
            aDeque[nextFirst] = item;
            nextFirst -= 1;
            size += 1;
        } else {
            aDeque[nextFirst] = item;
            nextFirst -= 1;
            size += 1;
        }
    }

    public void addLast(T item) {
        if (size >= aDeque.length) {
            resize(REFACTOR);
        }
        // Resigning the index to nextFirst index.
        if (nextLast >= aDeque.length) {
            nextLast = 0;
            aDeque[nextLast] = item;
            nextLast += 1;
            size += 1;
        } else {
            aDeque[nextLast] = item;
            nextLast += 1;
            size += 1;
        }
    }

    // Remove private funcion: Copy the aDeque into a new downsized array.
    // Start from the center of the resized array.
    private void sizeDown() {
        //DOWNFACTOR * 2
        int refactor = aDeque.length / REFACTOR;
        T[] temp = (T[]) new Object[refactor];
        int startInd = refactor / 2 - 1;
        System.arraycopy(aDeque, nextFirst + 1, temp, startInd, size);
        nextFirst = startInd - 1;
        nextLast = startInd + size;
        aDeque = temp;
    }

    public T removeFirst() {
        if (size < aDeque.length / DOWNFACTOR) {
            sizeDown();
        }
        if (size == 0) {
            return null;
        }
        T returnItem;
        if (nextFirst >= aDeque.length - 1) {
            nextFirst = 0;
            returnItem = aDeque[nextFirst];
            aDeque[nextFirst] = null;
            size--;
            return returnItem;
        } else {
            returnItem = aDeque[nextFirst + 1];
            aDeque[nextFirst + 1] = null;
            nextFirst++;
            size--;
            return returnItem;
        }
    }

    public T removeLast() {
        if (size < aDeque.length / DOWNFACTOR) {
            sizeDown();
        }
        if (size == 0) {
            return null;
        }
        T returnItem;
        if (nextLast <= 0) {
            nextLast = aDeque.length - 1;
            returnItem = aDeque[nextLast];
            aDeque[nextLast] = null;
            size--;
            return returnItem;
        } else {
            returnItem = aDeque[nextLast - 1];
            aDeque[nextLast - 1] = null;
            nextLast--;
            size--;
            return returnItem;
        }
    }

    public T get(int index) {
        if (index > size - 1) {
            return null;
        }
        int indexForaDeque = nextFirst + index + 1;
        if (indexForaDeque > aDeque.length - 1) {
            indexForaDeque = indexForaDeque - aDeque.length;
        }
        return aDeque[indexForaDeque];
    }

    public void printDeque() {
        for (int i = 0; i < size; i += 1) {
//            System.out.println("This index fucked" + get(i));
            T it = get(i);
            System.out.print(get(i));
            System.out.print(" ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}
