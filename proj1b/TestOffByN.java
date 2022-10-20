import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByN {
    static CharacterComparator offByThr = new OffByN(3);

    @Test
    public void TestOBT() {
        assertTrue(offByThr.equalChars('a', 'd'));
        assertTrue(offByThr.equalChars('d', 'a'));
        assertFalse(offByThr.equalChars('d', 'f'));
    }
}
