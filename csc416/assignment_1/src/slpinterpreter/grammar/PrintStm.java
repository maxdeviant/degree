package slpinterpreter.grammar;

/**
 * Print Statement
 */
public class PrintStm extends Stm {

    public ExpList exps;

    public PrintStm(ExpList e) {
        exps = e;
    }

}
