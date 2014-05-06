class Util {

    /**
     * Insertion sort.
     */
    @SuppressWarnings("rawtypes")
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j -= 1)
                swap(arr, j, j - 1);
    }

    /**
     * Returns true if a < b.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    /**
     * Swaps values at two array indices.
     */
    public static void swap(Object[] A, int i, int j) {
        Object tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    /**
     * Returns the maximum value from an int array.
     */
    public static int max(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++)
            if (max < arr[i])
                max = arr[i];

        return max;
    }

    /**
     * Returns true if a string is a palindrome.
     */
    public static boolean palindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right)
            if (s.charAt(left++) != s.charAt(right--))
                return false;

        return true;
    }

    /**
     * Returns pow(b,p) mod m.
     * 
     * Fallback for when squaring the base might overflow.
     */
    static int modPow2(int b, int p, int m) {
        b = b % m;
        int res = 1;

        for (int i = 0; i < p; i++)
            res = (res * b) % m;

        return res;
    }

    /**
     * Returns pow(b,p) mod m.
     * 
     * Squares base rather than multiplying.
     */
    static int modPow(int b, int p, int m) {
        b = b % m;
        int res = 1;

        while (p > 0) {
            if (p % 2 == 1)
                res = (res * b) % m;
            p /= 2;
            b = b * b % m;
        }
        return res;
    }

    /**
     * Prints the first N elements of an int array.
     */
    static void say(int[] arr, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]);
            sb.append(' ');
        }
        System.out.println(sb);
    }

    /**
     * Insertion sorts array a using the values in b.
     */
    public static void sortUsing(int[] a, int[] b) {
        assert a.length == b.length;

        int[] c = new int[b.length];
        System.arraycopy(b, 0, c, 0, b.length);

        for (int i = 0; i < c.length; i++)
            for (int j = i; j > 0 && c[j] > c[j - 1]; j -= 1) {
                swap(a, j, j - 1);
                swap(c, j, j - 1);
            }
    }

    /**
     * Swaps array values at the given indices.
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
