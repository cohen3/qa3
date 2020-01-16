import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class sizeBottomUp {
    @Test
    public void testSize(){
        Program program = new Program();
        assertEquals(2, program.size(new int[2]));
    }

    @Test
    public void testEmptyArray(){
        Program program = new Program();
        assertEquals(0, program.size(new int[]{}));
    }

    @Test
    public void testNullArray(){
        Program program = new Program();
        assertEquals(-1, program.size(null));
    }
}
