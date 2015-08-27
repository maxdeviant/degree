package slpinterpreter;

import slpinterpreter.grammar.*;

/**
 * @author Marshall Bowers
 */
public class Interpreter {

    private static class Table {

        String id;
        int value;
        Table tail;

        public Table(String id, int value, Table table) {
            this.id = id;
            this.value = value;
            this.tail = table;
        }

    }

    /**
     * Returns the value for the specified ID in the specified table.
     *
     * @param table The table to lookup the value in.
     * @param id    The ID to lookup the value for.
     * @return The value associated with the specified ID.
     */
    private static int lookup(Table table, String id) {
        if (table.id.equals(id)) {
            return table.value;
        }

        return lookup(table.tail, id);
    }

    private static class IntAndTable {

        int i;
        Table table;

        public IntAndTable(int i, Table table) {
            this.i = i;
            this.table = table;
        }

    }

    /**
     * Interprets a statement and prints the result.
     *
     * @param stm The statement to interpret.
     */
    public static void interp(Stm stm) {
        interpStm(stm, null);
    }

    private static Table interpStm(Stm stm, Table table) {
        if (stm instanceof CompoundStm) {
            return interpStm(((CompoundStm) stm).stm2, interpStm(((CompoundStm) stm).stm1, table));
        }

        if (stm instanceof AssignStm) {
            IntAndTable intTable = interpExp(((AssignStm) stm).exp, table);

            return new Table(((AssignStm) stm).id, intTable.i, intTable.table);
        }

        return print(((PrintStm) stm).exps, table);
    }

    private static IntAndTable interpExp(Exp exp, Table table) {
        if (exp instanceof IdExp) {
            return new IntAndTable(lookup(table, ((IdExp) exp).id), table);
        }

        if (exp instanceof NumExp) {
            return new IntAndTable(((NumExp) exp).num, table);
        }

        if (exp instanceof EseqExp) {
            return interpExp(((EseqExp) exp).exp, interpStm(((EseqExp) exp).stm, table));
        }

        IntAndTable lhsIntAndTable = interpExp(((OpExp) exp).left, table);
        IntAndTable rhsIntAndTable = interpExp(((OpExp) exp).right, lhsIntAndTable.table);

        int result = 0;

        switch (((OpExp) exp).oper) {
            case OpExp.Plus:
                result = lhsIntAndTable.i + rhsIntAndTable.i;
                break;
            case OpExp.Minus:
                result = lhsIntAndTable.i - rhsIntAndTable.i;
                break;
            case OpExp.Times:
                result = lhsIntAndTable.i * rhsIntAndTable.i;
                break;
            case OpExp.Div:
                result = lhsIntAndTable.i / rhsIntAndTable.i;
                break;
        }

        return new IntAndTable(result, rhsIntAndTable.table);
    }

    private static Table print(ExpList expList, Table table) {
        if (expList instanceof PairExpList) {
            return print((PairExpList) expList, table);
        }

        return print((LastExpList) expList, table);
    }

    private static Table print(PairExpList pairExpList, Table table) {
        return print(pairExpList.tail, doPrint(pairExpList.head, table, false));
    }

    private static Table print(LastExpList lastExpList, Table table) {
        return doPrint(lastExpList.head, table, true);
    }

    private static Table doPrint(Exp exp, Table table, boolean newline) {
        IntAndTable intAndTable = interpExp(exp, table);

        if (newline) {
            System.out.println(intAndTable.i);
        } else {
            System.out.println(intAndTable.i + " ");
        }

        return intAndTable.table;
    }

}
