import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class equalArraysBottomUp {
    /**
     *         +-------------+
     *         | equalArrays |
     *         +-------------+
     *               |
     *           +------+
     *           | size |
     *           +------+
     */

    @Test
    public void testEqualArraysTrue(){
        assertTrue(new Program().equalArrays(new int[]{1,2,3}, new int[]{1,2,3}));
    }

    @Test
    public void testEqualArraysFalse(){
        assertFalse(new Program().equalArrays(new int[]{1,4,3}, new int[]{1,2,3}));
    }

    @Test
    public void testEqualArraysOneNull(){
        assertFalse(new Program().equalArrays(null, new int[]{1,2,3}));
    }

    @Test
    public void testEqualArraysTwoNull(){
        assertFalse(new Program().equalArrays( new int[]{1,2,3}, null));
    }

    @Test
    public void testEqualArraysBothNull(){
        assertTrue(new Program().equalArrays(null, null));
    }
}
