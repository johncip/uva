import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestModAttempt extends ModAttempt {

    @Test
    public void justMe() {

//        String p = "4357186184021382204544";
//        assertEquals(1234, guessRoot(p, 7, 10));
//        assertEquals(1234, modRoot(382204544, 7, 10000000));
        
        assertEquals(1000, modRoot(1000000000, 3, 10));
        
    }

    // @Test
    public void testModRoot() {
        // root(4, 2) == 2
        assertEquals(2, modRoot(4, 2, 10));

        // root(1042, 2) == 32
        assertEquals(2, modRoot(1024, 2, 10));
        assertEquals(32, modRoot(1024, 2, 10000));

        // root(379503424, 3) == 724
        assertEquals(724, modRoot(379503424, 3, 1000000000));
        assertEquals(724, modRoot(379503424, 3, 100000000));
        assertEquals(724, modRoot(379503424, 3, 10000000));
        assertEquals(724, modRoot(379503424, 3, 1000000));
        assertEquals(724, modRoot(379503424, 3, 100000));
        assertEquals(724, modRoot(379503424, 3, 10000));
    }

    // @Test
    public void testGuessRoot() {
        assertEquals(1, guessRoot("1", 1, 6));
        assertEquals(2, guessRoot("2", 1, 6));

        assertEquals(4, guessRoot("16", 2, 2));
        assertEquals(4, guessRoot("16", 2, 9));

        assertEquals(3, guessRoot("27", 3, 2));
        assertEquals(3, guessRoot("27", 3, 9));

        String p = "379503424";
        for (int i = 4; i < 10; i++)
            assertEquals(724, guessRoot(p, 3, i));

        p = "4357186184021382204544";
        assertEquals(1234, guessRoot(p, 7, 6));
        assertEquals(1234, guessRoot(p, 7, 6));
        assertEquals(1234, guessRoot(p, 7, 6));
    }

    // @Test
    public void testModPow() {
        assertEquals(6, modPow(2, 4, 10));
        assertEquals(16, modPow(2, 4, 100));

        assertEquals(4, modPow(2, 10, 10));
        assertEquals(24, modPow(2, 10, 100));
        assertEquals(24, modPow(2, 10, 1000));
        assertEquals(1024, modPow(2, 10, 10000));
        assertEquals(1024, modPow(2, 10, 1000000000));
    }

    // @Test
    public void testModPow1() {
        assertEquals(1, modPow(1, 1, 10));
        assertEquals(2, modPow(2, 1, 10));
    }

}
