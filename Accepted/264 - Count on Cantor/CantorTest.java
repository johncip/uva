import static org.junit.Assert.*;

import org.junit.Test;


public class CantorTest extends Main {

    @Test
    public void testDiagonal() {
        assertEquals(1, diagonal(1));
        
        assertEquals(2, diagonal(2));
        assertEquals(2, diagonal(3));
        
        assertEquals(3, diagonal(4));
        assertEquals(3, diagonal(6));
        
        assertEquals(4, diagonal(7));
        assertEquals(4, diagonal(10));
        
        assertEquals(5, diagonal(11));
        assertEquals(5, diagonal(15));
    }
    
    @Test
    public void testDistance() {
        assertEquals(0, distance(1)); // 0 + 1
        assertEquals(0, distance(2)); // 1 + 1
        assertEquals(0, distance(4)); // 3 + 1
        assertEquals(0, distance(7)); // etc
        assertEquals(0, distance(11));
        
        assertEquals(2, distance(6));
        assertEquals(2, distance(13));
    }

}
