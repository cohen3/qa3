import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class equalArraysTopDown {
    private class StubProgram extends Program{
        @Override
        public int size(int[] arr) {
            return 2;
        }
    }

    @Test
    public void testEqualArrays(){
        StubProgram stubProgramSize1 = new StubProgram();
        assertTrue(stubProgramSize1.equalArrays(new int[]{1, 2}, new int[]{1, 2}));
    }

    @Test
    public void testNonEqualArrays(){
        StubProgram stubProgramSize1 = new StubProgram();
        assertFalse(stubProgramSize1.equalArrays(new int[]{3, 3}, new int[]{1, 2}));
    }

    @Test
    public void testNonEqualArraysSecondIndex(){
        StubProgram stubProgramSize1 = new StubProgram();
        assertFalse(stubProgramSize1.equalArrays(new int[]{1, 3}, new int[]{1, 2}));
    }
}
