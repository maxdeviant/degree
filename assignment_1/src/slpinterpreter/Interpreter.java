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

    /**
     * Interprets a statement and any child statements or expressions.
     *
     * @param stm   The statement to interpret.
     * @param table The identifier table to use.
     * @return The identifier table after interpreting the statement.
     */
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

        PrintStm printStm = (PrintStm) stm;

        return print(printStm.exps, table);
    }

    /**
     * Interprets an expression and any child expressions.
     *
     * @param exp   The expression to interpret.
     * @param table The identifier table to use.
     * @return The identifier table.
     */
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

        int opResult = evaluateOperation(opExp.oper, lhsIntAndTable.i, rhsIntAndTable.i);

        return new IntAndTable(opResult, rhsIntAndTable.table);
    }

    /**
     * Prints an expression list.
     *
     * @param expList The expression list to print.
     * @param table   The identifier table to use.
     * @return The identifier table.
     */
    private static Table print(ExpList expList, Table table) {
        if (expList instanceof PairExpList) {
            PairExpList pairExpList = (PairExpList) expList;

            return print(pairExpList, table);
        }

        LastExpList lastExpList = (LastExpList) expList;

        return print(lastExpList, table);
    }

    /**
     * Prints a pair expression list.
     *
     * @param pairExpList The pair expression list to print.
     * @param table       The identifier table to use.
     * @return The identifier table.
     */
    private static Table print(PairExpList pairExpList, Table table) {
        return print(pairExpList.tail, print(pairExpList.head, table, false));
    }

    /**
     * Prints the last element in an expression list.
     *
     * @param lastExpList The last element in an expression list to print.
     * @param table       The identifier table to use.
     * @return The identifier table.
     */
    private static Table print(LastExpList lastExpList, Table table) {
        return print(lastExpList.head, table, true);
    }

    /**
     * Prints an expression.
     *
     * @param exp           The expression to print.
     * @param table         The identifier table to use.
     * @param insertNewline Flag indicating whether or not a newline should be inserted after the printed result of the interpreted expression.
     * @return The identifier table after interpreting the expression.
     */
    private static Table print(Exp exp, Table table, boolean insertNewline) {
        IntAndTable intAndTable = interpExp(exp, table);

        System.out.print(intAndTable.i);

        if (insertNewline) {
            System.out.println();
        } else {
            System.out.print(" ");
        }

        return intAndTable.table;
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

    /**
     * Evaluates an arithmetic operation between two integer values.
     *
     * @param operation The integer value representing an arithmetic operation to perform.
     * @param lhs       The integer on the left-hand side of the operator.
     * @param rhs       The interger on the right-hand side of the operator.
     * @return The result of the evaluated operation.
     * @throws IllegalArgumentException Operation must be one of the ones defined in {@link slpinterpreter.grammar.OpExp}.
     */
    private static int evaluateOperation(int operation, int lhs, int rhs) throws IllegalArgumentException {
        switch (operation) {
            case OpExp.Plus:
                return lhs + rhs;
            case OpExp.Minus:
                return lhs - rhs;
            case OpExp.Times:
                return lhs * rhs;
            case OpExp.Div:
                return lhs / rhs;
        }

        throw new IllegalArgumentException("Operation not recognized.");
    }

}
