import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class swapMinMaxBottomUp {
    /**
     *
     *                   +------------------+
     *                   |    swapMinMax    |
     *                   +------------------+
     *                  /        |           \
     *      +---------+  +---------------+   +----------+
     *      | copyArr |  | minValueIndex |   | maxValue |
     *      +---------+  +---------------+   +----------+
     *        /                                     \
     *    +------+                            +---------------+
     *    | size |                            | maxValueIndex |
     *    +------+                            +---------------+
     *                                                   \
     *                                                 +------+
     *                                                 | size |
     *                                                 +------+
     *    buttom up:
     *    1) size, minValueIndex
     *    2) copyArr, maxValueIndex
     *    3) maxValue
     *    4) swapMinMax
     */

    private class FixedProgram extends Program{

        @Override
        public int minValueIndex(int[] arr) {
            return findIndex(false, arr);
        }

        @Override
        public int maxValueIndex(int[] arr) {
            return findIndex(true, arr);
        }

        private int findIndex(boolean max, int[] arr){
            if(arr == null || arr.length < 1) return -1;
            int critical = arr[0];
            int index = 0;
            for(int i = 0; i < arr.length; i++){
                if(max && arr[i] > critical){
                    critical = arr[i];
                    index = i;
                }
                if(!max && arr[i] < critical){
                    critical = arr[i];
                    index = i;
                }
            }
            return index;
        }

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
        p = new FixedProgram();
    }

    @After
    public void teardown(){
        p = null;
    }

    @Test
    public void testswapMinMax(){
        int[] arr = new int[]{1,0,3,50,2};
        assertArrayEquals(new int[]{1,50,3,0,2}, p.swapMinMax(arr));
    }

    @Test
    public void testswapMinMaxNull(){
        assertArrayEquals(null, p.swapMinMax(null));
    }


//    // testing 1
//
//    @Test
//    public void testSize(){
//        assertEquals(4, p.size(new int[]{1,2,3,4}));
//    }
//
//    @Test
//    public void testMinValueIndex(){
//        int[] arr = new int[]{1,2,3,0};
//        assertEquals(3, p.minValueIndex(arr));
//    }
//
//    @Test
//    public void testMinValueIndexNull(){
//        assertEquals(-1, p.minValueIndex(null));
//    }
//
//    @Test
//    public void testminValueIndexEmpty(){
//        boolean failed = false;
//        try {
//            assertEquals(-1, p.minValueIndex(new int[]{}));
//        }catch(Exception e){failed = true;}
//        assertFalse(failed);
//    }
//
//    // testing 2
//
//    @Test
//    public void testCopyArr(){
//        assertArrayEquals(new int[]{1,2,3,4}, p.copyArr(new int[]{1,2,3,4}));
//    }
//
//    @Test
//    public void testmaxValueIndex(){
//        int[] arr = new int[]{1,4,2,3};
//        assertEquals(1, p.maxValueIndex(arr));
//    }
//
//    @Test
//    public void testmaxValueIndexNull(){
//        boolean failed = false;
//        try {
//            assertEquals(-1, p.maxValueIndex(null));
//        }catch(Exception e){failed = true;}
//        assertFalse(failed);
//    }
//
//    @Test
//    public void testmaxValueIndexEmpty(){
//        assertEquals(-1, p.maxValueIndex(new int[]{}));
//    }
//
//    // testing 3
//
//    @Test
//    public void testmaxValue(){
//
//    }
}
