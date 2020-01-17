import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class maxValueIndexBottomUp {
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
    public void testMaxValueIndFirst(){
        assertEquals(0, program.maxValueIndex(new int[]{3, 2, 1}));
    }

    @Test
    public void testMaxValueIndMiddle(){
        assertEquals(1, program.maxValueIndex(new int[]{2, 3, 0}));
    }

    @Test
    public void testMaxValueIndLast(){
        assertEquals(2, program.maxValueIndex(new int[]{2, 1, 3}));
    }

    @Test
    public void testMaxValueIndWithEmptyArray(){
        assertEquals(-1, program.minValueIndex(new int[]{}));
    }
}
