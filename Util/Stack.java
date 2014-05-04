/**
 * A fixed-capacity array-backed stack implementation.
 */
class Stack<T> {

    private T[] data;
    private int n; // first free slot

    /**
     * Creates a new stack with the given max capacity.
     */
    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the top of the stack.
     */
    public void push(T x) {
        data[n++] = x;
    }

    /**
     * Returns and removes the top element.
     */
    public T pop() {
        return data[--n];
    }

    /**
     * Returns the top element without removing.
     */
    public T peek() {
        assert !isEmpty();
        return data[n - 1];
    }

    /**
     * Returns true if x is on the stack somewhere.
     */
    public boolean contains(int x) {
        for (int i = 0; i < n; i++) {
            if (data[i].equals(x))
                return true;
        }
        return false;
    }

    /**
     * Returns true if there are no elements on the stack.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the number of elements currently on the stack.
     */
    public int size() {
        return n;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Note: returns elements LIFO.
        for (int i = 0; i < n; i++) {
            sb.append(data[i]);
            sb.append(' ');
        }

        // no trailing blank spaces allowed
        return sb.toString().trim();
    }

    /**
     * Resets the stack to being empty.
     */
    public void reset() {
        while (!isEmpty())
            pop();
    }
}