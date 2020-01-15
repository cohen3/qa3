import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class mergeTopDown {
    private class StubProgram1 extends Program{
        @Override
        public int[] sortArray(int[] arr) {
            return new int[]{1, 2, 3};
        }
    }

    private class StubProgram2 extends Program{
        @Override
        public int[] sortArray(int[] arr) {
            return new int[]{1, 2, 3, 4, 5, 6};
        }
    }

    @Test
    public void testMergeWithFirstArrayNull(){
        StubProgram1 stubProgram1 = new StubProgram1();
        assertArrayEquals(new int[]{1, 2, 3}, stubProgram1.merge(null, new int[]{1, 3, 2}));
    }

    @Test
    public void testMergeWithSecondArrayNull(){
        StubProgram1 stubProgram1 = new StubProgram1();
        assertArrayEquals(new int[]{1, 2, 3}, stubProgram1.merge(new int[]{1, 3, 2}, null));
    }

    @Test
    public void testMergeWithoutDuplicateNumbers(){
        StubProgram2 stubProgram2 = new StubProgram2();
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, stubProgram2.merge(new int[]{3, 5, 1}, new int[]{4, 6, 2}));
    }

}
