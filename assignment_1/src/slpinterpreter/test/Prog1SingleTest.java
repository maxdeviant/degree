package slpinterpreter.test;

import java.io.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import slpinterpreter.grammar.Stm;
import org.junit.Test;

/**
 *
 * @author richardburns
 */
public class Prog1SingleTest {

    static Stm probToRun = slpinterpreter.test.TestPrograms.prog1;
    
    /*
    @Test
    public void evaluatesMaxArgs() {
        try {
            int maxargs = MaxArgs.maxargs(probToRun);
            assertEquals(0, maxargs);
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
            assertEquals("",
                    os.toString());
        } catch (Exception e) {
            fail(e.toString());
        }
        
        // restore normal System.output operation
        System.setOut(originalOut);
    }
    */
}
