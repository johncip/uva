/**
 * A world containing multiple slots for stacking boxes.
 */

class BlockWorld {
    
    Stack<Integer>[] stacks;
    Stack<Integer> tmp;
    int N;

    /**
     * Sets up the stacks.
     */
    @SuppressWarnings("unchecked")
    public BlockWorld(int n) {
        N = n;
        assert N > 0;

        stacks = new Stack[N];
        for (int i = 0; i < N; i++) {
            stacks[i] = new Stack<Integer>(N);
            stacks[i].push(i);
        }

        tmp = new Stack<Integer>(N);
        assert tmp.isEmpty();
    }

    /**
     * Returns the state of the block world.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // no space after colon for empty stacks
        for (int i = 0; i < N; i++) {
            sb.append(i);
            sb.append(':');
            if (!stacks[i].isEmpty()) {
                sb.append(" ");
                sb.append(stacks[i]);
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    // ------------------------------------------------------------------------
    // Commands
    // ------------------------------------------------------------------------

    /**
     * move a onto/over b
     * 
     * Puts a over b. Blocks over a are returned first. If "onto", blocks over b
     * are also returned first.
     */
    void move(int a, int b, boolean onto) {
        Stack<Integer> src = stackWith(a);
        Stack<Integer> dest = stackWith(b);

        if (src == dest)
            return;

        returnOver(src, a);
        if (onto)
            returnOver(dest, b);

        dest.push(src.pop());
    }

    /**
     * pile a onto/over b
     * 
     * Puts a, and blocks over a, onto block b. If "onto", blocks over b are
     * returned first.
     */
    void pile(int a, int b, boolean onto) {
        Stack<Integer> src = stackWith(a);
        Stack<Integer> dest = stackWith(b);

        if (src == dest)
            return;

        if (onto)
            returnOver(dest, b);

        assert tmp.isEmpty();
        int popped = -1;

        do {
            popped = src.pop();
            tmp.push(popped);
        } while (popped != a);

        while (!tmp.isEmpty()) {
            dest.push(tmp.pop());
        }
    }

    // ------------------------------------------------------------------------
    // Helpers
    // ------------------------------------------------------------------------

    /**
     * Returns the stack containing x.
     */
    Stack<Integer> stackWith(int x) {
        assert x < N;
        assert x >= 0;

        // x is now guaranteed to be in one of the stacks

        for (Stack<Integer> s : stacks)
            if (s.contains(x))
                return s;

        assert false;
        return null;
    }

    /**
     * Returns blocks sitting on block x (if any) to their homes.
     */
    void returnOver(Stack<Integer> stack, int x) {
        assert (stack.contains(x));

        while (true)
            if (stack.peek() == x)
                break;
            else
                returnBlock(stack.pop());

        assert stack.peek() == x;
    }

    /**
     * Pushes block x onto stack x.
     */
    void returnBlock(int x) {
        assert stacks[x].isEmpty();

        stacks[x].push(x);

        assert stacks[x].contains(x);
    }
}