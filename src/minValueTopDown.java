import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class minValueTopDown {
    private class StubProgram extends Program{
        @Override
        public int minValueIndex(int[] arr) {
            return 0;
        }
    }

    @Test
    public void test(){
        StubProgram stubProgram = new StubProgram();
        assertEquals(1, stubProgram.minValue(new int[]{1, 3, 2}));
    }
}
