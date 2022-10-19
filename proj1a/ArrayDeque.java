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
    private int size;
    private T[] conceptArray;
    private int dequeLength;
    private int last;
    private int first;

    /**
     * Creates an empty list. Constructor:
     */
    public ArrayDeque() {
        size = 0;
        dequeLength = 4;
        int start = dequeLength / 2;
        conceptArray = (T[]) new Object[dequeLength];
        last = start;
        first = start - 1;
    }

    private int minusOne(int index) {
        if (index == 0) {
            index = dequeLength - 1;
        } else {
            index--;
        }
        return index;
    }

    private int plusOne(int index, int length) {
        index++;
        index %= length;
        return index;
    }

    /**
     * Similar to AList, but it changes the first index
     */
    public void addFirst(T item) {
        // TODO: grow funcion
        if (size == dequeLength) {
            grow();
        }
        conceptArray[first] = item;
        first = minusOne(first);
        size++;
    }

    public void addLast(T item) {
        // TODO: grow func
        if (size == dequeLength) {
            grow();
        }
        conceptArray[last] = item;
        last = plusOne(last, dequeLength);
        size++;
    }


    public T removeFirst() {
        // TODO: shrink func
        if (size >= 16 && dequeLength / size == 4) {
            shrink();
        }
        first = plusOne(first, dequeLength);
        T returnItem = conceptArray[first];
        conceptArray[first] = null;
        size--;
        return returnItem;
    }

    public T removeLast() {
        // TODO: shrink func
        if (dequeLength >= 16 && dequeLength / size == 4) {
            shrink();
        }
        last = minusOne(last);
        T retItem = conceptArray[last];
        conceptArray[last] = null;
        size--;
        return retItem;
    }

    // Ensure get function runs constant time.
    public T get(int index) {
        if (index > size) {
            return null;
        }
        int indexForaDeque = first + index + 1;
        if (indexForaDeque > dequeLength - 1) {
            indexForaDeque = indexForaDeque - dequeLength;
        }
        return conceptArray[indexForaDeque];
    }

    /**
     * Second stage for Scaling up and down (resizing) procedure.
     */
    private void grow() {
        T[] newArray = (T[]) new Object[dequeLength * 2];
        int pt1 = first;
        int pt2 = dequeLength;
        int i = size;
        while (i-- != 0) {
            pt1 = plusOne(pt1, dequeLength);
            newArray[pt2] = conceptArray[pt1];
            pt2 = plusOne(pt2, newArray.length);
        }
        last = pt2;
        first = minusOne(dequeLength);
        dequeLength *= 2;
        conceptArray = newArray;
    }

    private void shrink() {
        int nwLength = dequeLength / 2;
        T[] newArray = (T[]) new Object[nwLength];
        int pt1 = first;
        int pt2 = nwLength / 2;
        int i = size;
        while (i-- != 0) {
            pt1 = plusOne(pt1, dequeLength);
            newArray[pt2] = conceptArray[pt1];
            pt2 = plusOne(pt2, nwLength);
        }
        last = pt2;
        first = minusOne(nwLength / 2);
        dequeLength = nwLength;
        conceptArray = newArray;
    }

    public void printDeque() {
        for (int i = 0; i < size; i += 1) {
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
