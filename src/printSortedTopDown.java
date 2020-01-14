import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class printSortedTopDown {
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
     *     top down:
     *     1) printSorted
     *     2) printArr, sortArray
     *     3) copyArr, size
     */

    private class StubProgram{
        /**
         * This class's goal is to check the sortArray method as a standalone module.
         */

        // this method was copies as is 'printSorted'
        public void printSorted(int[] arr) {
            if (arr==null)
                System.out.println("No array");
            printArr(arr);
            arr = sortArray(arr);
            printArr(sortArray(arr));
            printArr(arr);
        }
        // Stub method for size
        private int size(int[] arr) {
            return arr.length;
        }

        // Stub method for sortArr
        public int[] sortArray(int[] arr){
            int[] arr2 = copyArrStub(arr);
            Arrays.sort(arr2);
            return arr2;
        }

        // Stub method for printArr
        public void printArr(int[] arr){
            String prefix = "";
            for(int i : arr) {
                System.out.print(prefix + i);
                prefix = " ";
            }
            System.out.println();
        }

        // Stub method for copyArr
        public int[] copyArrStub(int[] arr) {
            if (arr == null) return null;
            int[] res = new int[size(arr)];
            if (size(arr) >= 0) System.arraycopy(arr, 0, res, 0, size(arr));
            return res;
        }
    }
    private StubProgram p;

    // for print tests
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setup(){
        p = new StubProgram();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        p = null;
    }

    // testing 1

    @Test
    public void testPrintSorted(){
        int[] arr = {1,5,3,4};
        p.printSorted(arr);
        assertEquals("1 5 3 4\n1 3 4 5\n1 5 3 4", outContent.toString());
    }

    @Test
    public void testPrintSortedNull(){
        boolean exception = false;
        try {
            p.printSorted(null);
            assertEquals("No array\n", outContent.toString());
        }catch(Exception e){
            exception = true;
        }
        assertFalse(exception);
    }

    // testing 2

    @Test
    public void testPrintArr(){
        int[] arr = {1,2,3,4};
        Program.printArr(arr);
        assertEquals("1 2 3 4\n", outContent.toString());
    }
}
