import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class minValueIndexBottomUp {

    private Program program;

    @Before
    public void setup(){
        program = new Program();
    }

    @After
    public void teardown(){
        program = null;
    }

    @Test
    public void testMinValueIndFirst(){
        assertEquals(0, program.minValueIndex(new int[]{1, 3, 2}));
    }

    @Test
    public void testMinValueIndMiddle(){
        assertEquals(1, program.minValueIndex(new int[]{2, 0, 3}));
    }

    @Test
    public void testMinValueIndLast(){
        assertEquals(2, program.minValueIndex(new int[]{3, 2, 1}));
    }

    @Test
    public void testMinValueIndWithEmptyArray(){
        assertEquals(-1, program.minValueIndex(new int[]{}));
    }
}
