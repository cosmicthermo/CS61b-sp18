import java.math.*;

/** 
 * Create two planets and test the pairwise forces between them
 * 
 */

public class TestPlanet {

	/** 
	 *  test TestPlanet
	 */
	public static void main(String[] args) {
		checkTestPlanet();
	}

	/**
     *  Checks whether or not two Doubles are equal and prints the result.
     *
     *  @param  expected    Expected double
     *  @param  actual      Double received
     *  @param  label       Label for the 'test' case
     *  @param  eps         Tolerance for the double comparison.
     */
    private static void checkEquals(double actual, double expected, String label, double eps) {
    	if (Math.abs(actual - expected) <= eps * Math.abs(Math.max(actual, expected))) {
    		System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
    	} else {
    		System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
    	}
    }
	/** 
	 *  test TestPlanet and check pairwise forces between
	 */
	private static void checkTestPlanet() {
		System.out.println("Checking two created planet and their corresponding forces.");

		Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p2 = new Planet(2.0, 1.0, 3.0, 4.0, 4e11, "jupiter.gif");



        checkEquals(p1.calcForceExertedByX(p2), 133.4, "CheckTwoPairwiseForcesExBy", 0.01);
        checkEquals(p2.calcForceExertedByX(p1), -133.4, "CheckTwoPairwiseForcesExBy", 0.01);
	}
}