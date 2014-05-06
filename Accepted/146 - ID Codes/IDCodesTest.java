import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IDCodesTest extends Main {

    @Test
    public void testReverse() {
        assertEquals("", reverse("", 0));
        assertEquals("a", reverse("a", 0));
        assertEquals("ab", reverse("ba", 0));
        assertEquals("abc", reverse("cba", 0));
        assertEquals("Abc", reverse("Acb", 1));
    }

    @Test
    public void testNext1() {
        assertEquals("", next1(""));
        assertEquals("ba", next1("ab"));
        
        assertEquals("acb", next1("abc"));
        assertEquals("bac", next1("acb"));
        assertEquals("cab", next1("bca"));
        assertEquals("cba", next1("cab"));
        assertEquals("cba", next1("cba"));

        assertEquals("babb", next1("abbb"));
        assertEquals("baac", next1("acba"));
        assertEquals("caab", next1("bcaa"));
        assertEquals("bacd", next1("adcb"));
        
        assertEquals("cbbaa", next1("cbbaa"));

        assertEquals("abaacb", next1("abaabc"));
        assertEquals("ababac", next1("abaacb"));
        
    }
    
    @Test
    public void test() {
        assertFalse(next(""));
        assertFalse(next("a"));
        assertTrue(next("ab"));
        assertFalse(next("ba"));
    }

    /**
     * Convenience method for testing reverse.
     */
    String reverse(String s, int lo) {
        char[] cs = s.toCharArray();
        reverse(cs, lo);
        return new String(cs);
    }

    /**
     * Convenience method for testing next's side effects.
     */
    String next1(String s) {
        char[] cs = s.toCharArray();
        next(cs);
        return new String(cs);
    }

    /**
     * Convenience method for testing next's return value.
     */
    boolean next(String s) {
        char[] cs = s.toCharArray();
        return next(cs);
    }

}
