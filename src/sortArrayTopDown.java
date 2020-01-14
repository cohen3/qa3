import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class sortArrayTopDown {
    private class StubProgramSortedArray extends Program{
        @Override
        public int[] copyArr(int[] arr) {
            return new int[]{1, 2, 3};
        }

        @Override
        public int size(int[] arr) {
            return 3;
        }
    }

    private class StubProgramNonSortedArray extends Program{
        @Override
        public int[] copyArr(int[] arr) {
            return new int[]{4, 2, 8};
        }

        @Override
        public int size(int[] arr) {
            return 3;
        }
    }

    @Test
    public void testSortSortedArray(){
        StubProgramSortedArray stubProgramSortedArray = new StubProgramSortedArray();
        assertArrayEquals(new int[]{1, 2, 3}, stubProgramSortedArray.sortArray(new int[]{1, 2, 3}));
    }

    @Test
    public void testSortNonSortedArray(){
        StubProgramNonSortedArray stubProgramNonSortedArray = new StubProgramNonSortedArray();
        assertArrayEquals(new int[]{2, 4, 8}, stubProgramNonSortedArray.sortArray(new int[]{4, 2, 8}));
    }
}
