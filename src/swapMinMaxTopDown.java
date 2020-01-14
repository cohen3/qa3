import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class swapMinMaxTopDown {
    private class StubProgram extends Program{
        @Override
        public int[] copyArr(int[] arr) {
            return new int[]{2, 3, 1};
        }

        @Override
        public int maxValueIndex(int[] arr) {
            return 1;
        }

        @Override
        public int minValueIndex(int[] arr) {
            return 2;
        }
    }

    private class StubProgram2 extends Program{
        @Override
        public int[] copyArr(int[] arr) {
            return new int[]{2, 3, 1, 2};
        }

        @Override
        public int maxValueIndex(int[] arr) {
            return 1;
        }

        @Override
        public int minValueIndex(int[] arr) {
            return 2;
        }
    }

    private class StubProgramWithInvalidMinInd extends Program{
        @Override
        public int[] copyArr(int[] arr) {
            return new int[]{2, 3, 1};
        }

        @Override
        public int maxValueIndex(int[] arr) {
            return 1;
        }

        @Override
        public int minValueIndex(int[] arr) {
            return -1;
        }
    }

    private class StubProgramWithInvalidMaxInd extends Program{
        @Override
        public int[] copyArr(int[] arr) {
            return new int[]{2, 3, 1};
        }

        @Override
        public int maxValueIndex(int[] arr) {
            return -1;
        }

        @Override
        public int minValueIndex(int[] arr) {
            return 2;
        }
    }

    @Test
    public void testSwap(){
        StubProgram stubProgram = new StubProgram();
        assertArrayEquals(new int[]{2, 1, 3}, stubProgram.swapMinMax(new int[]{2, 3, 1}));
    }

    @Test
    public void testSwap2(){
        StubProgram stubProgram = new StubProgram();
        assertArrayEquals(new int[]{2, 1, 3, 2}, stubProgram.swapMinMax(new int[]{2, 3, 1, 2}));
    }

    @Test
    public void testSwapWithInvalidMinInd(){
        StubProgramWithInvalidMinInd stubProgramWithInvalidMinInd = new StubProgramWithInvalidMinInd();
        assertNull(stubProgramWithInvalidMinInd.swapMinMax(new int[]{2, 3, 1}));
    }

    @Test
    public void testSwapWithInvalidMaxInd(){
        StubProgramWithInvalidMaxInd stubProgramWithInvalidMaxInd = new StubProgramWithInvalidMaxInd();
        assertNull(stubProgramWithInvalidMaxInd.swapMinMax(new int[]{2, 3, 1}));
    }
}
