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
    public void testAddFirstGet() {
        ArrayDeque<Integer> testAd1 = new ArrayDeque<>();
        testAd1.addFirst(100);
        testAd1.addFirst(200);
        testAd1.addFirst(300);
//        assertEquals(100, testAd1.get(0));
    }

//    @Test
//    public void testAddLastGet() {
//        ArrayDeque<Integer> testAd1 = new ArrayDeque<>();
//        testAd1.addFirst(100);
//        testAd1.addFirst(3);
//        testAd1.addFirst(4);
//        testAd1.addFirst(5);
//        testAd1.addFirst(6);
//        testAd1.addFirst(200);
//        testAd1.addLast(300);
//        int temp1 = testAd1.removeFirst();
//        int temp2 = testAd1.removeLast();
//        assertEquals(temp1, 200);
//        assertEquals(temp2, 300);
////        assertEquals(6, testAd1.get(0));
////        assertEquals(100, testAd1.get(testAd1.size() - 1));
//    }

    public static void main(String[] args) {
        System.out.println("Running Array Deque tests.\n");
        jh61b.junit.TestRunner.runTests("all", ArrayDequeTest.class);
    }
}
