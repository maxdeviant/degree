(* Marshall Bowers *)
(* Dr Richard Wyatt *)
(* 9 December 2014 *)
(* test.sml *)

Control.Print.printDepth := 200;
Control.Print.printLength := 200;
Control.MC.matchNonExhaustiveWarn := false;

datatype X = A | B | C | D | E | F | G | H;

use "traversals.sml";

val t1 =  tree(1,
            tree(2, tree(3, empty, empty), tree(4, empty, empty)),
            tree(5, tree(6, empty, empty), tree(7, empty, empty)));

val t2 =  tree(A,
            tree(B, tree(D, empty, empty), tree(E, empty, empty)),
            tree(C, tree(F, empty, empty), tree(G, empty, empty)));

val t3 =  tree(1.22, tree(2.33, empty, empty), tree(3.44, empty, empty));

val t4 =  tree("A",
            tree("B",
                tree("C", tree("E", empty, empty), empty),
                tree("D",
                    tree("F", empty, empty),
                    tree("G", tree("H", empty, empty), empty))),
            tree("I",
                tree("J", empty, tree("K",
                    tree("L", empty, empty),
                    tree("M", empty, empty))),
                empty));

preOrder t1;
inOrder t1;
postOrder t1;

preOrder t2;
inOrder t2;
postOrder t2;

preOrder t3;
inOrder t3;
postOrder t3;

preOrder t4;
inOrder t4;
postOrder t4;
displayTree(t1, printInt);
