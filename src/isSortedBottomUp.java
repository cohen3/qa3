import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class isSortedBottomUp {
    /**
     *                 +----------+
     *                 | isSorted |
     *                 +----------+
     *                 /         \
     *        +-----------+  +-------------+
     *        | sortArray |  | equalArrays |
     *        +-----------+  +-------------+
     *        /         \                 \
     *    +------+  +---------+        +------+
     *    | size |  | copyArr |        | size |
     *    +------+  +---------+        +------+
     *                      \
     *                   +------+
     *                   | size |
     *                   +------+
     */

    private class FixedProgram extends Program{

        @Override
        public int[] copyArr(int[] arr) {
            if (arr == null) return null;
            int[] res = new int[size(arr)];
            if (size(arr) >= 0) System.arraycopy(arr, 0, res, 0, size(arr));
            return res;
        }

        @Override
        public boolean equalArrays(int[] arr1, int[] arr2) {
            return Arrays.equals(arr1, arr2);
        }
    }

    private Program p;

    @Before
    public void setup(){
        p = new FixedProgram();
    }

    @After
    public void teardown(){
        p = null;
    }

    @Test
    public void testIsSortedTrue(){
        assertTrue(p.isSorted(new int[]{1,2,3,4}));
    }

    @Test
    public void testIsSortedFalse(){
        assertFalse(p.isSorted(new int[]{1,2,0,4}));
    }

    @Test
    public void testIsSortedNull(){
        assertTrue(p.isSorted(null));
    }
}
