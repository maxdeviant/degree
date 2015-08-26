package slpinterpreter.test;

import java.io.*;
import slpinterpreter.grammar.Stm;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author richardburns
 */
public class Prog0SingleTest {

    static Stm probToRun = slpinterpreter.test.TestPrograms.prog0;
    
    /*
    @Test
    public void evaluatesMaxArgs() {
        try {
            // choose between using a FUNCTIONAL or OBJECT-ORIENTED design
            int maxargs = MaxArgs.maxargs(probToRun);   // FUNCTIONAL call
            int maxargs = probToRun.maxargs();          // OBJECT-ORIENTED call
            
            assertEquals(2, maxargs);
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
            
            // choose between using a FUNCTIONAL or OBJECT-ORIENTED design
            Interpreter.interp(probToRun);   // FUNCTIONAL call
            probToRun.interp();              // OBJECT-ORIENTED call
            
            assertEquals(
                    "8 7"+separator+
                    "80"+separator,
                    os.toString());
        } catch (Exception e) {
            fail(e.toString());
        }
        
        // restore normal System.output operation
        System.setOut(originalOut);
    }
    */
}
