import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * White box tests for block world simulation.
 */
public class TestBlockWorld extends BlockWorld {
    
    public TestBlockWorld() {
        super(10);
    }
    
    @Test
    public void testInitialState() {
        for (int i = 0; i < N; i++) {
            assertFalse(stacks[i].isEmpty());
            assertEquals(stacks[i].size(), 1);
            assertEquals(stacks[i].peek(), i);
        }
    }

    @Test
    public void testReturnUntil() {
        Stack[] ss = stacks;
        Stack dest = ss[9];

        dest.push(ss[0].pop());
        dest.push(ss[1].pop());
        assertEquals(dest.size(), 3);
        assertEquals(dest.peek(), 1);
        returnOver(dest, 9);
        testInitialState();
    }

    @Test
    public void testReturnBlock() {
        Stack[] ss = stacks;
        Stack dest = ss[9];

        dest.push(ss[0].pop());
        returnBlock(dest.pop());
        testInitialState();
    }

    @Test
    public void testState() {
        Stack[] ss = stacks;
        Stack dest = ss[9];

        dest.push(ss[0].pop());
        dest.push(ss[1].pop());
        String expected = "0:\n1:\n2: 2\n3: 3\n4: 4\n5: 5\n6: 6\n7: 7\n8: 8\n9: 9 0 1\n";
        assertEquals(expected, toString());
    }

    @Test
    public void testIntStackWith() {
        Stack[] ss = stacks;
        Stack dest = ss[9];

        dest.push(ss[0].pop());
        dest.push(ss[1].pop());

        assertEquals(dest, stackWith(0));
        assertEquals(dest, stackWith(1));
        assertEquals(dest, stackWith(9));
        assertEquals(ss[2], stackWith(2));

        try {
            stackWith(10);
            fail();
        } catch (AssertionError e) {
            ;
        }
    }

    public void testMove() {
        Stack[] ss = stacks;
        Stack src = ss[0];
        Stack dest = ss[1];

        move(0, 1, true);

        assertTrue(src.isEmpty());
        assertEquals(2, dest.size());
        assertEquals(0, dest.peek());
    }

}
