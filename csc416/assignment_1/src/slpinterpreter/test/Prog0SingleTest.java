package slpinterpreter.test;

import org.junit.Test;
import slpinterpreter.Interpreter;
import slpinterpreter.MaxArgs;
import slpinterpreter.grammar.Stm;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author richardburns
 */
public class Prog0SingleTest {

    static Stm probToRun = slpinterpreter.test.TestPrograms.prog0;

    @Test
    public void evaluatesMaxArgs() {
        try {
            int maxargs = MaxArgs.maxargs(probToRun);   // FUNCTIONAL call

            assertEquals(2, maxargs);
        } catch (Exception e) {
            fail(e.toString());
        }
    }

    @Test
    public void evaluatesInterpreter() {
        // prepare to capture System.output
        PrintStream originalOut = System.out;
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        // perform tests
        try {
            String separator = System.getProperty("line.separator");

            Interpreter.interp(probToRun);

            assertEquals("8 7" + separator + "80" + separator, os.toString());
        } catch (Exception e) {
            fail(e.toString());
        }

        // restore normal System.output operation
        System.setOut(originalOut);
    }

}
