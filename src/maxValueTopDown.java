import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class maxValueTopDown {
    private class StubProgram extends Program{
        @Override
        public int maxValueIndex(int[] arr) {
            return 1;
        }
    }

    @Test
    public void test(){
        StubProgram stubProgram = new StubProgram();
        assertEquals(3, stubProgram.maxValue(new int[]{1, 3, 2}));
    }
}
