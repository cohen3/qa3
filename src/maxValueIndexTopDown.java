import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class maxValueIndexTopDown {
    private class StubProgram extends Program{
        @Override
        public int size(int[] arr) {
            return 2;
        }
    }

    private class StubProgramZeroSizeArray extends Program{
        @Override
        public int size(int[] arr) {
            return 0;
        }
    }

    @Test
    public void testMaxValueIndFirst(){
        StubProgram stubProgram = new StubProgram();
        assertEquals(0, stubProgram.maxValueIndex(new int[]{3, 2, 1}));
    }

    @Test
    public void testMaxValueIndMiddle(){
        StubProgram stubProgram = new StubProgram();
        assertEquals(1, stubProgram.maxValueIndex(new int[]{1, 3, 2}));
    }

    @Test
    public void testMaxValueIndLast(){
        StubProgram stubProgram = new StubProgram();
        assertEquals(2, stubProgram.maxValueIndex(new int[]{1, 2, 3}));
    }

    @Test
    public void testMaxValueIndWithEmptyArray(){
        StubProgramZeroSizeArray stubProgramZeroSizeArray = new StubProgramZeroSizeArray();
        assertEquals(-1, stubProgramZeroSizeArray.maxValueIndex(new int[]{}));
    }
}
