import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class mergeBottomUp {
    /**
     *            +-------+
     *            | merge |
     *            +-------+
     *               |
     *          +-----------+
     *          | sortArray |
     *          +-----------+
     *           /        \
     *      +------+   +---------+
     *      | size |   | copyArr |
     *      +------+   +---------+
     *                       \
     *                    +------+
     *                    | size |
     *                    +------+
     */

    private class FixProgram extends Program{
        @Override
        public int[] copyArr(int[] arr) {
            if (arr == null) return null;
            int[] res = new int[size(arr)];
            if (size(arr) >= 0) System.arraycopy(arr, 0, res, 0, size(arr));
            return res;
        }
    }

    private Program p;

    @Before
    public void setup(){
        p = new FixProgram();
    }

    @After
    public void teardownn(){
        p = null;
    }

    @Test
    public void testMerge(){
        int[] arr1 = new int[]{2,0};
        int[] arr2 = new int[]{3,1};
        assertArrayEquals(new int[]{0,1,2,3}, p.merge(arr1, arr2));
    }

    @Test
    public void testMergeOneNull(){
        int[] arr1 = null;
        int[] arr2 = new int[]{2,0};
        assertArrayEquals(new int[]{0,2}, p.merge(arr1, arr2));
    }

    @Test
    public void testMergeTwoNull(){
        int[] arr1 = new int[]{2,0};
        int[] arr2 = null;
        assertArrayEquals(new int[]{0,2}, p.merge(arr1, arr2));
    }

    @Test
    public void testMergeBothNull(){
        int[] arr1 = null;
        int[] arr2 = null;
        assertArrayEquals(null, p.merge(arr1, arr2));
    }
}
