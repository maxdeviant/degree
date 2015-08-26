package slpinterpreter.test;

import slpinterpreter.grammar.*;

/**
 * Straight Line Programs used for testing.
 *
 * @author richardburns
 */
public class TestPrograms {

    public static Stm prog0 = new CompoundStm(
            new AssignStm(
                    "a",
                    new OpExp(
                            new NumExp(5),
                            OpExp.Plus,
                            new NumExp(3)
                    )
            ),
            new CompoundStm(
                    new AssignStm(
                            "b",
                            new EseqExp(
                                    new PrintStm(
                                            new PairExpList(
                                                    new IdExp("a"),
                                                    new LastExpList(
                                                            new OpExp(
                                                                    new IdExp("a"),
                                                                    OpExp.Minus,
                                                                    new NumExp(1)
                                                            )
                                                    )
                                            )
                                    ),
                                    new OpExp(
                                            new NumExp(10),
                                            OpExp.Times,
                                            new IdExp("a")
                                    )
                            )
                    ),
                    new PrintStm(
                            new LastExpList(
                                    new IdExp("b")
                            )
                    )
            )
    );

    public static Stm prog1 = new AssignStm(
            "a",
            new NumExp(10)
    );

    public static Stm prog2 = new PrintStm(
            new LastExpList(
                    new NumExp(5)
            )
    );

    public static Stm prog3 = new CompoundStm(
            new AssignStm(
                    "a",
                    new OpExp(
                            new NumExp(5),
                            OpExp.Plus,
                            new NumExp(3)
                    )
            ),
            new PrintStm(
                    new LastExpList(
                            new IdExp("a")
                    )
            )
    );

    public static Stm prog4 = new AssignStm(
            "b",
            new EseqExp(
                    new PrintStm(
                            new PairExpList(
                                    new NumExp(10),
                                    new PairExpList(
                                            new NumExp(9),
                                            new PairExpList(
                                                    new NumExp(8),
                                                    new LastExpList(
                                                            new EseqExp(
                                                                    new AssignStm(
                                                                            "c",
                                                                            new EseqExp(
                                                                                    new PrintStm(
                                                                                            new PairExpList(
                                                                                                    new NumExp(11),
                                                                                                    new PairExpList(
                                                                                                            new NumExp(10),
                                                                                                            new PairExpList(
                                                                                                                    new NumExp(9),
                                                                                                                    new PairExpList(
                                                                                                                            new NumExp(8),
                                                                                                                            new LastExpList(
                                                                                                                                    new NumExp(7)
                                                                                                                            )
                                                                                                                    )
                                                                                                            )
                                                                                                    )
                                                                                            )
                                                                                    ),
                                                                                    new NumExp(6)
                                                                            )
                                                                    ),
                                                                    new NumExp(5)
                                                            )
                                                    )
                                            )
                                    )
                            )
                    ),
                    new NumExp(3)
            )
    );

}
