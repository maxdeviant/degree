package slpinterpreter;

import slpinterpreter.grammar.*;

/**
 * @author Marshall Bowers
 */
public class MaxArgs {

    /**
     * Counts the maximum number of arguments for any `print` statement within any subexpression of the given statement.
     *
     * @param stm The statement to count the maximum number of arguments in.
     * @return The maximum number of arguments.
     */
    public static int maxargs(Stm stm) {
        if (stm instanceof CompoundStm) {
            CompoundStm compoundStm = (CompoundStm) stm;

            int lhsMax = maxargs(compoundStm.stm1);
            int rhsMax = maxargs(compoundStm.stm2);

            return Math.max(lhsMax, rhsMax);
        }

        if (stm instanceof AssignStm) {
            AssignStm assignStm = (AssignStm) stm;

            return maxargs(assignStm.exp);
        }

        PrintStm printStm = (PrintStm) stm;

        int length = length(printStm.exps);
        int max = maxargs(printStm.exps);

        return Math.max(length, max);
    }

    /**
     * Counts the maximum number of arguments for any `print` statement within any subexpression of the given expression.
     *
     * @param exp The expression to count the maximum number of arguments in.
     * @return The maximum number of arguments.
     */
    private static int maxargs(Exp exp) {
        if (exp instanceof EseqExp) {
            EseqExp eseqExp = (EseqExp) exp;

            int stmMax = maxargs(eseqExp.stm);
            int expMax = maxargs(eseqExp.exp);

            return Math.max(stmMax, expMax);
        }

        if (exp instanceof OpExp) {
            OpExp opExp = (OpExp) exp;

            int lhsMax = maxargs(opExp.left);
            int rhsMax = maxargs(opExp.right);

            return Math.max(lhsMax, rhsMax);
        }

        return 0;
    }

    /**
     * Counts the maximum number of arguments for any `print` statement within any subexpression of the given expression list.
     *
     * @param expList The expression list to count the maximum number of arguments in.
     * @return The maximum number of arguments.
     */
    private static int maxargs(ExpList expList) {
        if (expList instanceof PairExpList) {
            PairExpList pairExpList = (PairExpList) expList;

            int headMax = maxargs(pairExpList.head);
            int tailMax = maxargs(pairExpList.tail);

            return Math.max(headMax, tailMax);
        }

        LastExpList lastExpList = (LastExpList) expList;

        return maxargs(lastExpList.head);
    }

    /**
     * Returns the length of a given expression list.
     *
     * @param expList The expression list to get the length of.
     * @return The length of the expression list.
     */
    private static int length(ExpList expList) {
        if (expList instanceof PairExpList) {
            PairExpList pairExpList = (PairExpList) expList;

            return 1 + length(pairExpList.tail);
        }

        return 1;
    }

}
