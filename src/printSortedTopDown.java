import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.*;

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
     *                                  \
     *                               +------+
     *                               | size |
     *                               +------+
     *     top down:
     *     1) printSorted
     *     2) printArr, sortArray
     *     3) size
     *     4) copyArr
     */

    private class StubProgram extends Program{
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

        // this method was copies as is 'sortArray'
        public int[] sortArrayTest(int[] arr){
            if (arr == null) return null;
            int[] res = copyArr(arr);
            for(int i=0; i<size(arr); i++)
                for (int j=0; j<size(arr)-i-1; j++)
                    if (res[j]>res[j+1]) {
                        int temp = res[j];
                        res[j] = res[j+1];
                        res[j+1] = temp;
                    }
            return res;
        }

        // this method was copies as is 'copyArr'
        public int[] copyArrTest(int[] arr) {
            if (arr == null) return null;
            int[] res = new int[size(arr)];
            for(int i=0; i<size(arr); i++)
                res[i] = arr[0];
            return res;
        }

        // Stub method for size
        public int size(int[] arr) {
            return 4;
        }

        // Stub method for sortArr
        public int[] sortArray(int[] arr){
            int[] arr2 = copyArr(arr);
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
        public int[] copyArr(int[] arr) {
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
        assertEquals("1 5 3 4\r\n1 3 4 5\r\n1 5 3 4\r\n", outContent.toString());
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
        new Program().printArr(arr);
        assertEquals("1 2 3 4\r\n", outContent.toString());
    }

    @Test
    public void testSortArray(){
        int[] arr = new int[]{1,3,4,2};
        assertArrayEquals(new int[]{1,2,3,4}, p.sortArrayTest(arr));
    }

    // testing 3

    @Test
    public void testCopyArr(){
        int[] arr = new int[]{1,2,3,4};
        assertArrayEquals(new int[]{1,2,3,4}, p.copyArrTest(arr));
    }

    @Test
    public void testCopyArrNull(){
        assertNull(p.copyArrTest(null));
    }

    // testing 4

    @Test
    public void testSize(){
        assertEquals(4, new Program().size(new int[]{1,2,3,4}));
    }
}
