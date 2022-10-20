import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestArrayDequeGold {
    private final static int NUMBERTEST = 100;

    @Test
    public void testArrayDeq() {
        StudentArrayDeque<Integer> stdQue = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solu = new ArrayDequeSolution<>();
        ArrayDequeSolution<String> funcCalled = new ArrayDequeSolution<>();

        for (int i = 0; i < NUMBERTEST; i += 1) {
            double prob = StdRandom.uniform();
            if (prob <= 0.25 && solu.size() > 0 && stdQue.size() > 0) {
                // removeLa
                Integer rmStu = stdQue.removeLast();
                Integer rmSol = solu.removeLast();
                funcCalled.addLast("removeLast()");
                String mes = getErrorMegs(funcCalled);
                assertEquals(mes, rmSol, rmStu);
            } else if (prob <= 0.5 && solu.size() > 0 && stdQue.size() > 0) {
                // rmFirst
                Integer rmStu = stdQue.removeFirst();
                Integer rmSol = solu.removeFirst();
                funcCalled.addLast("removeFirst()");

                String mes = getErrorMegs(funcCalled);
                assertEquals(mes, rmSol, rmStu);
            } else if (prob <= 0.75) {
                // addF
                int addOne = StdRandom.uniform(10);
                stdQue.addFirst(addOne);
                solu.addFirst(addOne);
                funcCalled.addLast("addFirst(" + addOne + ")");
            } else {
                // addL
                int addTw = StdRandom.uniform(10);
                stdQue.addLast(addTw);
                solu.addLast(addTw);
                funcCalled.addLast("addLast(" + addTw + ")");
            }
        }
    }

    private String getErrorMegs(ArrayDequeSolution<String> functs) {
        String er1 = functs.removeLast();
        String er2 = functs.removeLast();
        String er3 = functs.removeLast();
        return "\n" + er3 + "\n" + er2 + "\n" + er1;
    }

}
