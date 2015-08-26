package slpinterpreter;

import slpinterpreter.grammar.Stm;
import slpinterpreter.test.TestPrograms;

/**
 * Driver.
 *
 * @author richardburns
 */

public class Driver {

    public static void main(String[] args) {
        Stm probToRun = TestPrograms.prog0;

        System.out.println("Maxargs: ");
        System.out.println(MaxArgs.maxargs(probToRun));

        System.out.println("Interpreted Result:");
        Interpreter.interp(probToRun);
    }

}
