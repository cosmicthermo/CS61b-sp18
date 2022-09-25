import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListGetTest {

    /**
     * Test the get iterative method.
     */
    @Test
    public void testGetMethod() {
        System.out.println("Running get Item test.");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        lld1.addLast(44);
        lld1.addLast(55);
        lld1.addLast(66);
        lld1.addLast(4774);
        lld1.addLast(77);
        lld1.addLast(88);

        int getItemOne = lld1.get(0);
        int getItemTwo = lld1.get(1);
        int getItemThree = lld1.get(2);
//        int getNull = lld1.get(6);
        assertEquals(44, getItemOne);
        assertEquals(55, getItemTwo);
        assertEquals(66, getItemThree);
    }

    @Test
    public void testGetRecursiveMethod() {
        System.out.println("Running get Item test.");

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        lld1.addLast(44);
        lld1.addLast(55);
        lld1.addLast(66);
//        lld1.addLast(4774);
//        lld1.addLast(77);
//        lld1.addLast(88);

        int getItemOne = lld1.getRecursive(0);
        int getItemTwo = lld1.getRecursive(1);
        int getItemThree = lld1.getRecursive(2);
        assertEquals(44, getItemOne);
        assertEquals(55, getItemTwo);
        assertEquals(66, getItemThree);

    }

    @Test
    public void testAddDeleteLast() {
        System.out.println("Running add and delete Item test.");
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        lld1.addLast(44);
        assertEquals(false, lld1.isEmpty());

        int remove_1 = lld1.removeLast();
        assertEquals(44, remove_1);

        lld1.addLast(44);
        lld1.addLast(55);
        lld1.addLast(66);
        lld1.addLast(88);
        assertEquals(false, lld1.isEmpty());


        int remove_2 = lld1.removeLast();
        int remove_3 = lld1.removeLast();
        assertEquals(66, remove_3);
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        jh61b.junit.TestRunner.runTests("all", LinkedListGetTest.class);
    }
}
