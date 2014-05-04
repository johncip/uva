import static org.junit.Assert.*;

import org.junit.Test;

public class PerfectionTest extends Main {

    static int[] abundant = { 12, 18, 20, 24, 30, 36, 40, 42, 48, 54, 56, 60,
            66, 70, 72, 78, 80, 84, 88, 90, 96, 100, 102, 104, 108, 112, 114,
            120, 126, 132, 138, 140, 144, 150, 156, 160, 162, 168, 174, 176,
            180, 186, 192, 196, 198, 200, 204, 208, 210, 216, 220, 222, 224,
            228, 234, 240, 246, 252, 258, 260, 264, 270 };

    static int[] deficient = { 1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 13, 14, 15, 16,
            17, 19, 21, 22, 23, 25, 26, 27, 29, 31, 32, 33, 34, 35, 37, 38, 39,
            41, 43, 44, 45, 46, 47, 49, 50, 51, 52, 53, 55, 57, 58, 59, 61, 62,
            63, 64, 65, 67, 68, 69, 71, 73, 74, 75, 76, 77, 79, 81, 82, 83, 85,
            86 };

    static int[] perfect = { 6, 28, 496, 8128 };

    @Test
    public void testAbundant() {
        for (int a : abundant)
            assertSame(Is.ABUNDANT, type(a));
    }

    @Test
    public void testOne() {
        assertSame(Is.DEFICIENT, type(1));
    }

    @Test
    public void testDeficient() {
        for (int d : deficient)
            assertSame(Is.DEFICIENT, type(d));
    }

    @Test
    public void testFortyFour() {
        assertSame(Is.DEFICIENT, type(44));
    }

    @Test
    public void testPerfect() {
        for (int p : perfect)
            assertSame(Is.PERFECT, type(p));
    }

}
