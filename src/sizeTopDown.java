import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class sizeTopDown {
    @Test
    public void testSize(){
        Program program = new Program();
        assertEquals(2, program.size(new int[2]));
    }
}
