import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMainOutput {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private final PrintStream previousOut = System.out;
    private final PrintStream previousErr = System.err;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void checkMainOutput() {
        String[] arguments = {"a", "b"};
        Main.main(arguments);
        String expected = "Hey GeekSI, you should hire me ;)";

        assertEquals(expected, outContent.toString().trim());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(previousOut);
        System.setErr(previousErr);
    }
}
