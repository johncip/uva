import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class TestMain extends Main {

    @Test
    public void testRoot() {
        assertEquals(1, root(1, 1));
        assertEquals(2, root(8, 3));
        assertEquals(10, root(1000000, 6));

        assertEquals(4, root(16, 2));
        assertEquals(3, root(27, 3));

        String p = "4357186184021382204544";
        assertEquals(1234, root(p, 7));

    }

    static int root(int p, int n) {
        return binarySearchRoot(BigInteger.valueOf(p), n);
    }

    static int root(String p, int n) {
        return binarySearchRoot(new BigInteger(p), n);
    }

}
