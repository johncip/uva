class Util {

    /**
     * Insertion sort for integer array.
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = i; j > 0 && arr[j] <  arr[j - 1]; j -= 1)
                swap(arr, j, j - 1);
    }
    
    /**
     * Insertion sort for Comparable array.
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

    /**
     * Returns the nth Fibonacci number.
     */
    public static long fib(int n) {
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        long[] fibs = new long[n + 1];
        fibs[1] = 1;

        for (int i = 2; i < fibs.length; i++)
            fibs[i] = fibs[i - 1] + fibs[i - 2];

        return fibs[n];
    }

    /**
     * Writes a grid to stdout.
     */
    static void say(long[][] arr) {
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++)
                System.out.print(String.format("%6d", arr[r][c]));
            System.out.println();
        }
    }

    /**
     * Writes a grid to stdout with given spacing. Prints a dot in place of the
     * "background" value.
     */
    static void say(int[][] arr, int n, int background) {
        String fmt = "%" + n + "d";
        String blank = "%" + n + "s";

        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                int v = arr[r][c];
                if (v == background)
                    System.out.format(blank, ".");
                else
                    System.out.format(fmt, arr[r][c]);
            }
            System.out.println();
        }
    }

    /**
     * Returns an integer array of n Fibonacci numbers.
     */
    static int[] fibs2(int n) {
        if (n > 46)
            throw new IllegalArgumentException();

        int[] fibs = new int[n];
        fibs[1] = 1;

        for (int i = 2; i < fibs.length; i++)
            fibs[i] = fibs[i - 1] + (fibs[i - 2]);

        return fibs;
    }

    /*
     * Binary searches a sorted array of integers. If the key is found, returns
     * its index, or -1 if key is not in the array.
     */
    static int binSearch(int key, int[] arr) {
        int lo = 0;
        int hi = arr.length;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] < key)
                lo = mid + 1;
            else if (arr[mid] > key)
                hi = mid - 1;
            else
                return mid;
        }

        return -1;
    }
    
    /**
     * Returns a sorted copy of the array.
     */
    public static int[] sortedCopy(int[] arr) {
        int[] sorted = new int[arr.length];
        System.arraycopy(arr, 0, sorted, 0, arr.length);
        sort(sorted);
        return sorted;
    }
}
