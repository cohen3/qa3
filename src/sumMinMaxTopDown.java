import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class sumMinMaxTopDown {
    private class StubProgram extends Program{
        @Override
        public int maxValue(int[] arr) {
            return 3;
        }

        @Override
        public int minValue(int[] arr) {
            return 1;
        }
    }

    @Test
    public void test(){
        StubProgram stubProgram = new StubProgram();
        assertEquals(4, stubProgram.sumMinMax(new int[]{2, 1, 3}));
    }
}
