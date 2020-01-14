import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class copyArrTopDown {
    private class StubProgram extends Program{
        @Override
        public int size(int[] arr) {
            return 2;
        }
    }

    @Test
    public void test(){
        StubProgram stubProgram = new StubProgram();
        assertArrayEquals(new int[]{1, 2}, stubProgram.copyArr(new int[]{1, 2}));
    }

    @Test
    public void testInputNull(){
        StubProgram stubProgram = new StubProgram();
        assertNull(stubProgram.copyArr(null));
    }
}
