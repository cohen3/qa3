import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class minValueBottomUp {
    /**
     *         +----------+
     *         | minValue |
     *         +----------+
     *              |
     *       +-------------- +
     *       | minValueIndex |
     *       +---------------+
     */

    private class FixedProgram extends Program{

        @Override
        public int minValueIndex(int[] arr) {
            if(arr == null || arr.length < 1) return -1;
            int critical = arr[0];
            int index = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] < critical){
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
    public void testMinValue(){
        assertEquals(0, p.minValue(new int[]{1,2,3,0,9,7,5}));
    }
}
