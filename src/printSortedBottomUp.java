import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class printSortedBottomUp {
    /**
     *            +-------------+
     *            | printSorted |
     *            +-------------+
     *              /         \
     *       +----------+  +-----------+
     *       | printArr |  | sortArray |
     *       +----------+  +-----------+
     *                      /        \
     *                  +------+  +---------+
     *                  | size |  | copyArr |
     *                  +------+  +---------+
     *                                  \
     *                               +------+
     *                               | size |
     *                               +------+
     *     top down:
     *     1) size, printArr
     *     2) copyArr
     *     3) sortArray
     *     4) printSorted
     */

    private class FixedProgram extends Program{
        // fix for printArr
        @Override
        public void printArr(int[] arr) {
            String prefix = "";
            for(int i : arr) {
                System.out.print(prefix + i);
                prefix = " ";
            }
            System.out.println();
        }

        // fix for copyArr
        @Override
        public int[] copyArr(int[] arr) {
            if (arr == null) return null;
            int[] res = new int[size(arr)];
            if (size(arr) >= 0) System.arraycopy(arr, 0, res, 0, size(arr));
            return res;
        }
    }

    // for print tests
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    Program program;

    @Before
    public void setup(){
        program = new Program();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    // testing 4

    @Test
    public void testPrintSorted() {
        program = new FixedProgram();
        int[] original = new int[]{1,4,2,3};
        program.printSorted(original);
        assertEquals("1 4 2 3\r\n1 2 3 4\r\n1 4 2 3\r\n", outContent.toString());
    }

    @Test
    public void testPrintSortedNull(){
        boolean exception = false;
        try {
            new FixedProgram().printSorted(null);
            assertEquals("No array\n", outContent.toString());
        }catch(Exception e){
            exception = true;
        }
        assertFalse(exception);
    }
}
