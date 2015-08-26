package slpinterpreter;

import slpinterpreter.grammar.Exp;
import slpinterpreter.grammar.Stm;

/**
 * @author Marshall Bowers
 */
public class Interpreter {

    private class Table {

        String id;
        int value;
        Table tail;

        public Table(String id, int value, Table table) {
            this.id = id;
            this.value = value;
            this.tail = table;
        }

    }

    private class IntAndTable {

        int i;
        Table table;

        public IntAndTable(int i, Table table) {
            this.i = i;
            this.table = table;
        }

    }

    public static void interp(Stm stm) {


    }

    private static Table interpStm(Stm stm, Table table) {
        return null;
    }

    private static IntAndTable interpExp(Exp exp, Table table) {
        return null;
    }

}
