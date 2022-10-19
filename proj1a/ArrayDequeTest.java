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
    public void testAddDelFirstGet() {
        ArrayDeque<Integer> testAd1 = new ArrayDeque<>();
        testAd1.addFirst(100);
        testAd1.addFirst(200);
        testAd1.addFirst(300);
        assertEquals((Integer) 200, testAd1.get(0));
        assertEquals((Integer) 300, testAd1.get(4));

        // Delete
        int remove1 = testAd1.removeFirst();
        int remove2 = testAd1.removeFirst();
        assertEquals(300, remove1);
        assertEquals(200, remove2);
    }

    @Test
    public void testAddLastGet() {
        ArrayDeque<Integer> testAd1 = new ArrayDeque<>();
        testAd1.addLast(100);
        testAd1.addLast(200);
        testAd1.addLast(300);
        testAd1.addLast(400);
        assertEquals((Integer) 400, testAd1.get(0)); //400
        assertEquals((Integer) 300, testAd1.get(4));

        // Delete
        int remove1 = testAd1.removeLast();
        int remove2 = testAd1.removeLast();
        assertEquals(400, remove1);
        assertEquals(300, remove2);
    }

    @Test
    public void testMegaArray() {
        ArrayDeque<Integer> testAd1 = new ArrayDeque<>();
        testAd1.addLast(100);
        testAd1.addLast(200);
        testAd1.addLast(300);
        testAd1.addLast(400);
        testAd1.addLast(500);
        testAd1.addLast(600);
        assertEquals((Integer) 400, testAd1.get(0)); //400
        assertEquals((Integer) 300, testAd1.get(9));
    }

    public static void main(String[] args) {
        System.out.println("Running Array Deque tests.\n");
        jh61b.junit.TestRunner.runTests("all", ArrayDequeTest.class);
    }
}
