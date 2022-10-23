package synthesizer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the ArrayRingBuffer class.
 *
 * @author Josh Hug
 */

public class TestArrayRingBuffer {

    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<Integer>(3);
        assertTrue(arb.isEmpty());

        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        for (Integer a : arb) {
            System.out.print(a + " ");
        }
        assertTrue(arb.isFull());
        assertEquals((Object) 1, arb.dequeue());
        arb.dequeue();
        arb.dequeue();
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(4);
        for (Integer a : arb) {
            System.out.println(a);
        }
        assertFalse(arb.isEmpty());
        assertEquals((Object) 1, arb.peek());
    }

    /**
     * Calls tests for ArrayRingBuffer.
     */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
}
