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

    public static Stm bowersProg1 = new CompoundStm(
            new AssignStm(
                    "a",
                    new OpExp(
                            new NumExp(2),
                            OpExp.Times,
                            new NumExp(2)
                    )
            ),
            new CompoundStm(
                    new AssignStm(
                            "b",
                            new OpExp(
                                    new NumExp(4),
                                    OpExp.Times,
                                    new NumExp(4)
                            )
                    ),
                    new CompoundStm(
                            new AssignStm(
                                    "c",
                                    new OpExp(
                                            new NumExp(8),
                                            OpExp.Times,
                                            new NumExp(8)
                                    )
                            ),
                            new CompoundStm(
                                    new PrintStm(
                                            new PairExpList(
                                                    new IdExp("a"),
                                                    new PairExpList(
                                                            new IdExp("b"),
                                                            new LastExpList(
                                                                    new IdExp("c")
                                                            )
                                                    )
                                            )
                                    ),
                                    new CompoundStm(
                                            new PrintStm(
                                                    new LastExpList(
                                                            new IdExp("b")
                                                    )
                                            ),
                                            new PrintStm(
                                                    new LastExpList(
                                                            new IdExp("c")
                                                    )
                                            )
                                    )
                            )
                    )
            )
    );

    public static Stm bowersProg2 = new CompoundStm(
            new CompoundStm(
                    new CompoundStm(
                            new AssignStm(
                                    "a",
                                    new NumExp(1)
                            ),
                            new AssignStm(
                                    "b",
                                    new NumExp(1)
                            )
                    ),
                    new PrintStm(
                            new PairExpList(
                                    new IdExp("a"),
                                    new LastExpList(
                                            new IdExp("b")

                                    )
                            )
                    )
            ),
            new CompoundStm(
                    new CompoundStm(
                            new CompoundStm(
                                    new CompoundStm(
                                            new AssignStm(
                                                    "a",
                                                    new OpExp(
                                                            new IdExp("a"),
                                                            OpExp.Plus,
                                                            new IdExp("b")
                                                    )
                                            ),
                                            new AssignStm(
                                                    "b",
                                                    new OpExp(
                                                            new IdExp("b"),
                                                            OpExp.Plus,
                                                            new IdExp("a")
                                                    )
                                            )
                                    ),
                                    new PrintStm(
                                            new PairExpList(
                                                    new IdExp("a"),
                                                    new LastExpList(
                                                            new IdExp("b")

                                                    )
                                            )
                                    )
                            ),
                            new CompoundStm(
                                    new CompoundStm(
                                            new AssignStm(
                                                    "a",
                                                    new OpExp(
                                                            new IdExp("a"),
                                                            OpExp.Plus,
                                                            new IdExp("b")
                                                    )
                                            ),
                                            new AssignStm(
                                                    "b",
                                                    new OpExp(
                                                            new IdExp("b"),
                                                            OpExp.Plus,
                                                            new IdExp("a")
                                                    )
                                            )
                                    ),
                                    new PrintStm(
                                            new PairExpList(
                                                    new IdExp("a"),
                                                    new LastExpList(
                                                            new IdExp("b")

                                                    )
                                            )
                                    )
                            )
                    ),
                    new CompoundStm(
                            new CompoundStm(
                                    new CompoundStm(
                                            new AssignStm(
                                                    "a",
                                                    new OpExp(
                                                            new IdExp("a"),
                                                            OpExp.Plus,
                                                            new IdExp("b")
                                                    )
                                            ),
                                            new AssignStm(
                                                    "b",
                                                    new OpExp(
                                                            new IdExp("b"),
                                                            OpExp.Plus,
                                                            new IdExp("a")
                                                    )
                                            )
                                    ),
                                    new PrintStm(
                                            new PairExpList(
                                                    new IdExp("a"),
                                                    new LastExpList(
                                                            new IdExp("b")

                                                    )
                                            )
                                    )
                            ),
                            new CompoundStm(
                                    new CompoundStm(
                                            new AssignStm(
                                                    "a",
                                                    new OpExp(
                                                            new IdExp("a"),
                                                            OpExp.Plus,
                                                            new IdExp("b")
                                                    )
                                            ),
                                            new AssignStm(
                                                    "b",
                                                    new OpExp(
                                                            new IdExp("b"),
                                                            OpExp.Plus,
                                                            new IdExp("a")
                                                    )
                                            )
                                    ),
                                    new PrintStm(
                                            new PairExpList(
                                                    new IdExp("a"),
                                                    new LastExpList(
                                                            new IdExp("b")

                                                    )
                                            )
                                    )
                            )
                    )
            )
    );

    public static Stm bowersProg3 = new CompoundStm(
            new CompoundStm(
                    new AssignStm(
                            "a",
                            new NumExp(3)
                    ),
                    new AssignStm(
                            "b",
                            new NumExp(4)
                    )
            ),
            new CompoundStm(
                    new PrintStm(
                            new PairExpList(
                                    new EseqExp(
                                            new AssignStm(
                                                    "a",
                                                    new OpExp(
                                                            new IdExp("a"),
                                                            OpExp.Times,
                                                            new IdExp("a")
                                                    )
                                            ),
                                            new IdExp("a")
                                    ),
                                    new LastExpList(
                                            new EseqExp(
                                                    new AssignStm(
                                                            "b",
                                                            new OpExp(
                                                                    new IdExp("b"),
                                                                    OpExp.Times,
                                                                    new IdExp("b")
                                                            )
                                                    ),
                                                    new IdExp("b")
                                            )
                                    )
                            )
                    ),
                    new PrintStm(
                            new LastExpList(
                                    new OpExp(
                                            new IdExp("a"),
                                            OpExp.Plus,
                                            new IdExp("b")
                                    )
                            )
                    )
            )
    );

    public static Stm bowersProg4 = new PrintStm(
            new PairExpList(
                    new NumExp(0),
                    new PairExpList(
                            new EseqExp(
                                    new CompoundStm(
                                            new CompoundStm(
                                                    new CompoundStm(
                                                            new AssignStm(
                                                                    "New Emergency Services",
                                                                    new NumExp(118)
                                                            ),
                                                            new AssignStm(
                                                                    "The",
                                                                    new NumExp(999)
                                                            )
                                                    ),
                                                    new CompoundStm(
                                                            new AssignStm(
                                                                    "IT",
                                                                    new NumExp(881)
                                                            ),
                                                            new AssignStm(
                                                                    "Crowd",
                                                                    new NumExp(999)
                                                            )
                                                    )
                                            ),
                                            new CompoundStm(
                                                    new CompoundStm(
                                                            new AssignStm(
                                                                    "Series 1",
                                                                    new NumExp(119)
                                                            ),
                                                            new AssignStm(
                                                                    "Episode 2",
                                                                    new NumExp(725)
                                                            )
                                                    ),
                                                    new AssignStm(
                                                            "Calamity Jen",
                                                            new NumExp(3)
                                                    )
                                            )
                                    ),
                                    new IdExp("New Emergency Services")
                            ),
                            new PairExpList(
                                    new IdExp("The"),
                                    new PairExpList(
                                            new IdExp("IT"),
                                            new PairExpList(
                                                    new IdExp("Crowd"),
                                                    new PairExpList(
                                                            new IdExp("Series 1"),
                                                            new PairExpList(
                                                                    new IdExp("Episode 2"),
                                                                    new LastExpList(
                                                                            new IdExp("Calamity Jen")
                                                                    )
                                                            )
                                                    )
                                            )
                                    )
                            )
                    )
            )
    );

    public static Stm bowersProg5 = null;

}
