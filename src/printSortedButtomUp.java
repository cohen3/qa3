import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class printSortedButtomUp {
    /**
     *            +-------------+
     *            | printSorted |
     *            +-------------+
     *              /         \
     *       +----------+  +-----------+
     *       | printArr |  | sortArray |
     *      +-----------+  +-----------+
     *                      /        \
     *                  +------+  +---------+
     *                  | size |  | copyArr |
     *                  +------+  +---------+
     *     top down:
     *     1) copyArr, printArr, size
     *     2) sortArray
     *     3) printSorted
     */

    // for print tests
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setup(){
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testPrintArr() {
        Program.printArr(new int[]{1,4,6,9});
        assertEquals("1 4 6 9\n", outContent.toString());
    }

    @Test
    public void testCopyArr(){
        int[] original = {1,2,3,4};
        int[] arr = Program.copyArr(original);
        assertArrayEquals(original, arr);
    }

    @Test
    public void testSize(){
        assertEquals(4, Program.size(new int[]{1,2,3,4}));
        assertEquals(0, Program.size(new int[]{}));
    }
}
