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
            CompoundStm compoundStm = (CompoundStm) stm;

            return interpStm(compoundStm.stm2, interpStm(compoundStm.stm1, table));
        }

        if (stm instanceof AssignStm) {
            AssignStm assignStm = (AssignStm) stm;
            IntAndTable intAndTable = interpExp(assignStm.exp, table);

            return new Table(assignStm.id, intAndTable.i, intAndTable.table);
        }

        return print(((PrintStm) stm).exps, table);
    }

    private static IntAndTable interpExp(Exp exp, Table table) {
        if (exp instanceof IdExp) {
            IdExp idExp = (IdExp) exp;

            return new IntAndTable(lookup(table, idExp.id), table);
        }

        if (exp instanceof NumExp) {
            NumExp numExp = (NumExp) exp;

            return new IntAndTable(numExp.num, table);
        }

        if (exp instanceof EseqExp) {
            EseqExp eseqExp = (EseqExp) exp;

            return interpExp(eseqExp.exp, interpStm(eseqExp.stm, table));
        }

        OpExp opExp = (OpExp) exp;

        IntAndTable lhsIntAndTable = interpExp(opExp.left, table);
        IntAndTable rhsIntAndTable = interpExp(opExp.right, lhsIntAndTable.table);

        int result = 0;

        switch (opExp.oper) {
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
            PairExpList pairExpList = (PairExpList) expList;

            return print(pairExpList, table);
        }

        LastExpList lastExpList = (LastExpList) expList;

        return print(lastExpList, table);
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
            System.out.print(intAndTable.i + " ");
        }

        return intAndTable.table;
    }

}
