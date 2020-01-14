import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class isSortedTopDown {
    private class StubProgramWithEqualArrays extends Program{
        @Override
        public int[] sortArray(int[] arr) {
            return new int[]{1, 2, 3};
        }

        @Override
        public boolean equalArrays(int[] arr1, int[] arr2) {
            return true;
        }
    }
    private class StubProgramWithNonEqualArrays extends Program{
        @Override
        public int[] sortArray(int[] arr) {
            return new int[]{1, 4, 3};
        }

        @Override
        public boolean equalArrays(int[] arr1, int[] arr2) {
            return false;
        }
    }

    @Test
    public void testEqualArrays(){
        StubProgramWithEqualArrays stubProgramWithEqualArrays = new StubProgramWithEqualArrays();
        assertTrue(stubProgramWithEqualArrays.isSorted(new int[1]));

        testNonEqualArrays();
    }

    @Test
    private void testNonEqualArrays() {
        StubProgramWithNonEqualArrays stubProgramWithNonEqualArrays = new StubProgramWithNonEqualArrays();
        assertFalse(stubProgramWithNonEqualArrays.isSorted(new int[1]));
    }

}