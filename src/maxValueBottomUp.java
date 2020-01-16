import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class maxValueBottomUp {
    /**
     *         +----------+
     *         | maxValue |
     *         +----------+
     *              |
     *       +---------------+
     *       | maxValueIndex |
     *       +---------------+
     *              |
     *          +------+
     *          | size |
     *          +------+
     */

    private class FixedProgram extends Program{

        @Override
        public int maxValueIndex(int[] arr) {
            if(arr == null || arr.length < 1) return -1;
            int critical = arr[0];
            int index = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] > critical){
                    critical = arr[i];
                    index = i;
                }
            }
            return index;
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
    public void testMaxValue(){
        assertEquals(5, p.maxValue(new int[]{1,5,4,3}));
    }
}
