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
            int lhsMax = maxargs(((CompoundStm) stm).stm1);
            int rhsMax = maxargs(((CompoundStm) stm).stm2);

            return Math.max(lhsMax, rhsMax);
        }

        if (stm instanceof AssignStm) {
            return maxargs(((AssignStm) stm).exp);
        }

        int length = length(((PrintStm) stm).exps);
        int max = maxargs(((PrintStm) stm).exps);

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
            int stmMax = maxargs(((EseqExp) exp).stm);
            int expMax = maxargs(((EseqExp) exp).exp);

            return Math.max(stmMax, expMax);
        }

        if (exp instanceof OpExp) {
            int lhsMax = maxargs(((OpExp) exp).left);
            int rhsMax = maxargs(((OpExp) exp).right);

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
            int headMax = maxargs(((PairExpList) expList).head);
            int tailMax = maxargs(((PairExpList) expList).tail);

            return Math.max(headMax, tailMax);
        }

        return maxargs(((LastExpList) expList).head);
    }

    /**
     * Returns the length of a given expression list.
     *
     * @param expList The expression list to get the length of.
     * @return The length of the expression list.
     */
    private static int length(ExpList expList) {
        if (expList instanceof PairExpList) {
            return 1 + length(((PairExpList) expList).tail);
        }

        return 1;
    }

}
