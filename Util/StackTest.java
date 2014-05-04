import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
    Stack<Integer> st;

    @Before
    public void setUp() throws Exception {
        st = new Stack<Integer>(10);
    }

    @Test
    public void testPush() {
        st.push(1);
        st.push(2);
        assertTrue(st.contains(1));
        assertTrue(st.contains(2));
    }

    @Test
    public void testPop() {
        st.push(1);
        st.push(2);
        assertEquals(Integer.valueOf(2), st.pop());
        assertEquals(Integer.valueOf(1), st.pop());
        assertFalse(st.contains(1));
        assertFalse(st.contains(2));
    }

    @Test
    public void testPushTen() {
        for (int i = 0; i < 10; i++)
            st.push(i);

        assertEquals(Integer.valueOf(9), st.pop());
    }

    @Test
    public void testPeek() {
        st.push(1);
        assertEquals(Integer.valueOf(1), st.peek());
    }

    @Test
    public void testIsEmpty() {
        Stack<Integer> st = new Stack<Integer>(1);
        assertTrue(st.isEmpty());
        st.push(1);
        assertFalse(st.isEmpty());
        st.pop();
        assertTrue(st.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, st.size());
        st.push(1);
        assertEquals(1, st.size());
        st.pop();
        assertEquals(0, st.size());
    }

    @Test
    public void testContains() {
        st.push(11);
        st.push(-1);
        st.push(2);
        st.push(0);

        assertTrue(st.contains(2));
        assertTrue(st.contains(0));
        assertTrue(st.contains(11));
        assertTrue(st.contains(-1));

        assertFalse(st.contains(4));
    }

    @Test
    public void testToString() {
        st.push(1);
        st.push(3);
        st.push(7);
        assertEquals("1 3 7", st.toString());
    }

}
