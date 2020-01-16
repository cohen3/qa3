import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class copyArrBottomUp {
    @Test
    public void testcopyArr(){
        Program p = new Program();
        assertArrayEquals(new int[]{1, 2}, p.copyArr(new int[]{1, 2}));
    }

    @Test
    public void testInputNull(){
        Program p = new Program();
        assertNull(p.copyArr(null));
    }
}
