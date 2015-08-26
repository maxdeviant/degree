package slpinterpreter.test;

import slpinterpreter.grammar.Stm;

/**
 * @author richardburns
 */
public class Prog4SingleTest {

    static Stm probToRun = slpinterpreter.test.TestPrograms.prog4;

    /*
    @Test
    public void evaluatesMaxArgs() {
        try {
            int maxargs = MaxArgs.maxargs(probToRun);
            assertEquals(5, maxargs);
        } catch (Exception e) {
            fail(e.toString());
        }
    }
    */

    /*
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
            assertEquals(
                    "10 9 8 11 10 9 8 7"+separator+
                    "5"+separator,
                    os.toString());
        } catch (Exception e) {
            fail(e.toString());
        }

        // restore normal System.output operation
        System.setOut(originalOut);
    }
    */
}
