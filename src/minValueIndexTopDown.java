import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class minValueIndexTopDown {
    @Test
    public void testMinValueIndFirst(){
        Program program = new Program();
        assertEquals(0, program.minValueIndex(new int[]{1, 3, 2}));
    }

    @Test
    public void testMinValueIndMiddle(){
        Program program = new Program();
        assertEquals(1, program.minValueIndex(new int[]{2, 1, 3}));
    }

    @Test
    public void testMinValueIndLast(){
        Program program = new Program();
        assertEquals(2, program.minValueIndex(new int[]{3, 2, 1}));
    }

    @Test
    public void testMinValueIndWithEmptyArray(){
        Program program = new Program();
        assertEquals(-1, program.minValueIndex(new int[]{}));
    }
}
