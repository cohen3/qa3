import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class printSortedTopDown {
    /**
     *            +-------------+
     *            | printSorted |
     *            +-------------+
     *              /         \
     *       +----------+  +-----------+
     *       | printArr |  | sortArray |
     *      +-----------+  +-----------+
     *                      /        \
     *                  +------+  +---------+
     *                  | size |  | copyArr |
     *                  +------+  +---------+
     *     top down:
     *     1) printSorted
     *     2) printArr, sortArray
     *     3) copyArr, size
     */

    // for print tests
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setup(){
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}
