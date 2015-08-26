package slpinterpreter;

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

    public static void interp(Stm stm) {


    }

}
