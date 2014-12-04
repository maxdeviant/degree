(* Marshall Bowers *)
(* Dr Richard Wyatt *)
(* 9 December 2014 *)
(* traversals.sml *)

use "traversals.sml";

val t1 =  tree(1,
            tree(2, tree(3, empty, empty), tree(4, empty, empty)),
            tree(5, tree(6, empty, empty), tree(7, empty, empty)));

preOrder t1;
inOrder t1;
postOrder t1;
