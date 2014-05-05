import static org.junit.Assert.*;

import org.junit.Test;


public class PalindromesTest extends Main {

    @Test
    public void testMirrorable() {
        assertTrue(mirrorable("EE"));
        assertTrue(mirrorable("ATOYOTA"));
        assertTrue(mirrorable("2A3MEAS"));
        assertFalse(mirrorable("4"));
        assertFalse(mirrorable("B"));
    }
    
    @Test
    public void testMirrored() {
        assertEquals("ATOYOTA", mirror("ATOYOTA"));
        assertEquals("2A3MEAS", mirror("2A3MEAS"));
        assertEquals("2", mirror("S"));
        assertEquals("Z", mirror("5"));
    }
    
    @Test
    public void testPalindrome() {
        assertTrue(isPalindrome("ISAPALINILAPASI"));
    }
    
    @Test
    public void testIsMirror() {
        assertTrue(isMirrored("2A3MEAS"));
        assertTrue(isMirrored("ATOYOTA"));
    }

}
