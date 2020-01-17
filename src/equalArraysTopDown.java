import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class equalArraysTopDown {
    /**
     *         +-------------+
     *         | equalArrays |
     *         +-------------+
     *               |
     *           +------+
     *           | size |
     *           +------+
     */

    private class StubProgram extends Program{
        @Override
        public int size(int[] arr) {
            return 3;
        }
    }

    @Test
    public void testEqualArrays(){
        StubProgram stubProgramSize1 = new StubProgram();
        assertTrue(stubProgramSize1.equalArrays(new int[]{1,2,3}, new int[]{1,2,3}));
    }

    @Test
    public void testNonEqualArrays(){
        StubProgram stubProgramSize1 = new StubProgram();
        assertFalse(stubProgramSize1.equalArrays(new int[]{1,4,3}, new int[]{1,2,3}));
    }
}
