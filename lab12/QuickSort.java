import edu.princeton.cs.algs4.Queue;

public class QuickSort {
    /**
     * Returns a new queue that contains the given queues catenated together.
     * <p>
     * The items in q2 will be catenated after all of the items in q1.
     */
    private static <Item extends Comparable> Queue<Item> catenate(Queue<Item> q1, Queue<Item> q2) {
        Queue<Item> catenated = new Queue<Item>();
        for (Item item : q1) {
            catenated.enqueue(item);
        }
        for (Item item : q2) {
            catenated.enqueue(item);
        }
        return catenated;
    }

    /**
     * Returns a random item from the given queue.
     */
    private static <Item extends Comparable> Item getRandomItem(Queue<Item> items) {
        int pivotIndex = (int) (Math.random() * items.size());
        Item pivot = null;
        // Walk through the queue to find the item at the given index.
        for (Item item : items) {
            if (pivotIndex == 0) {
                pivot = item;
                break;
            }
            pivotIndex--;
        }
        return pivot;
    }

    /**
     * Partitions the given unsorted queue by pivoting on the given item.
     *
     * @param unsorted A Queue of unsorted items
     * @param pivot    The item to pivot on
     * @param less     An empty Queue. When the function completes, this queue will contain
     *                 all of the items in unsorted that are less than the given pivot.
     * @param equal    An empty Queue. When the function completes, this queue will contain
     *                 all of the items in unsorted that are equal to the given pivot.
     * @param greater  An empty Queue. When the function completes, this queue will contain
     *                 all of the items in unsorted that are greater than the given pivot.
     */
    private static <Item extends Comparable> void partition(
            Queue<Item> unsorted, Item pivot,
            Queue<Item> less, Queue<Item> equal, Queue<Item> greater) {
        while (!unsorted.isEmpty()) {
            Item pk = unsorted.dequeue();
            int comparison = pk.compareTo(pivot);
            if (comparison < 0) less.enqueue(pk);
            else if (comparison == 0) equal.enqueue(pk);
            else greater.enqueue(pk);
        }
    }

    /**
     * Returns a Queue that contains the given items sorted from least to greatest.
     */
    public static <Item extends Comparable> Queue<Item> quickSort(
            Queue<Item> items) {
        if (items.size() <= 1) {
            return items;
        }
        // Make a deep copy of the original to avoid in-place change.
        Queue<Item> copyItem = new Queue<Item>();
        for (Item i : items) {
            copyItem.enqueue(i);
        }
        Queue<Item> less = new Queue<>();
        Queue<Item> equal = new Queue<>();
        Queue<Item> greater = new Queue<>();
        partition(copyItem, getRandomItem(copyItem), less, equal, greater);
        Queue<Item> firstHalf = catenate(quickSort(less), equal);
        return catenate(firstHalf, quickSort(greater));
    }


    public static void main(String[] args) {
        Queue<String> students = new Queue<>();
        students.enqueue("Alice");
        students.enqueue("Vanessa");
        students.enqueue("Ethan");
        System.out.println(students);
        for (int i = 0; i < 5; i++) {
            System.out.print("--");
        }
        System.out.println();
        Queue<String> ret = quickSort(students);
        System.out.println(ret);

        Queue<Integer> numb = new Queue<Integer>();
        for (int i = 10; i > 0; i -= 2) {
            numb.enqueue(i);
        }
        System.out.println(numb);
        for (int i = 0; i < 5; i++) {
            System.out.print("--");
        }
        System.out.println();
        Queue<Integer> ret2 = quickSort(numb);
        System.out.println(ret2);
    }
}
