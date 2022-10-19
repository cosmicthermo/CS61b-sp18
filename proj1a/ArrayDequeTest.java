import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayDequeTest {

    @Test
    public void testEmptySize() {
        ArrayDeque<Integer> testAd1 = new ArrayDeque<>();
        assertEquals(true, testAd1.isEmpty());
        assertEquals(0, testAd1.size());
        testAd1.addFirst(100);
        assertEquals(false, testAd1.isEmpty());
        assertEquals(1, testAd1.size());
    }

    @Test
    public void testAddDelWtResize() {
        ArrayDeque<Integer> testAd1 = new ArrayDeque<>();
        assertEquals(true, testAd1.isEmpty());
        testAd1.addFirst(100);
        testAd1.addFirst(200);
        testAd1.addFirst(300);
        testAd1.addFirst(4);
        assertEquals((Integer) 4, testAd1.get(0));
        assertEquals((Integer) 200, testAd1.get(2));

        // Delete
        int remove1 = testAd1.removeFirst();
        assertEquals(4, remove1);
        int remove2 = testAd1.removeLast();
        assertEquals(100, remove2);
        assertEquals(false, testAd1.isEmpty());
        testAd1.removeLast();
        int remove3 = testAd1.removeFirst();
        assertEquals(300, remove3);
        assertEquals(true, testAd1.isEmpty());
        testAd1.addFirst(100);
        testAd1.addLast(200);
        testAd1.addFirst(50);
        testAd1.printDeque();
        assertEquals(false, testAd1.isEmpty());
    }

    @Test
    public void testAddLastGet() {
        ArrayDeque<Integer> testAd1 = new ArrayDeque<>();
        testAd1.addLast(100);
        testAd1.addLast(200);
        testAd1.addLast(300);
        testAd1.addLast(400);
        assertEquals((Integer) 400, testAd1.get(3)); //400
        assertEquals((Integer) 300, testAd1.get(2));

        // Delete
        int remove1 = testAd1.removeLast();
        int remove2 = testAd1.removeLast();
        assertEquals(400, remove1);
        assertEquals(300, remove2);
    }

    @Test
    public void testMegaArray() {
        ArrayDeque<Integer> testAd1 = new ArrayDeque<>();
        testAd1.addFirst(10);
        testAd1.addLast(100);
        testAd1.addLast(200);
        testAd1.addLast(300);
        testAd1.addLast(400);
        testAd1.addLast(500);
        testAd1.addLast(600);
        testAd1.addLast(70);
        testAd1.addFirst(5);
        assertEquals((Integer) 200, testAd1.get(3)); //400
        assertEquals((Integer) 5, testAd1.get(0));
        assertEquals(9, testAd1.size());
        testAd1.printDeque();
        testAd1.removeLast();
        testAd1.removeLast();
        testAd1.removeLast();
        testAd1.removeLast();
        testAd1.removeLast();
        testAd1.removeLast();
        testAd1.removeLast();
        int size = testAd1.size();
        testAd1.printDeque();
    }

    @Test
    public void testRemove() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(0);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.isEmpty();
        deque.removeFirst();
        deque.removeFirst();
//        deque.addFirst(7);
//        deque.removeLast();
//        deque.addFirst(9);
        int remove = deque.removeFirst();
        assertEquals(0, remove);
    }

    public static void main(String[] args) {
        System.out.println("Running Array Deque tests.\n");
        jh61b.junit.TestRunner.runTests("all", ArrayDequeTest.class);
    }
}
