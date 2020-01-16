import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

public class sumMinMaxBottomUp {

    private class FixedProgram extends Program{

        @Override
        public int minValue(int[] arr){
            return arr[minValueIndex(arr)];
        }

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
    public void testSumMinMax(){
        int[] arr = new int[]{0,1,2,5};
        assertEquals(5, p.sumMinMax(arr));
    }
}
