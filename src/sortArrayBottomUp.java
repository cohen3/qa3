import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class sortArrayBottomUp {
    /**
     *          +-------------+
     *          |  sortArray  |
     *          +-------------+
     *            /         \
     *       +------+   +---------+
     *       | size |   | copyArr |
     *       +------+   +---------+
     *                         \
     *                      +------+
     *                      | size |
     *                      +------+
     */

    private class FixedProgram extends Program{
        @Override
        public int[] copyArr(int[] arr){
            if (arr == null) return null;
            int[] res = new int[size(arr)];
            if (size(arr) >= 0) System.arraycopy(arr, 0, res, 0, size(arr));
            return res;
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
    public void testSortArr(){
        int[] arr = new int[]{4,3,2,1};
        assertArrayEquals(new int[]{1,2,3,4}, p.sortArray(arr));
    }

    @Test
    public void testSortArrayNull(){
        assertNull(p.sortArray(null));
    }

    @Test
    public void testSortArrayEmpty(){
        assertArrayEquals(new int[]{}, p.sortArray(new int[]{}));
    }
}
