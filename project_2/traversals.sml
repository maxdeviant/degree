(* Marshall Bowers *)
(* Dr Richard Wyatt *)
(* 9 December 2014 *)
(* traversals.sml *)

datatype 'a Tree = empty | bTree of 'a * 'a Tree * 'a Tree ;

fun preOrder nil = nil;

fun inOrder nil = nil;

fun postOrder nil = nil;

fun displayTree nil = nil;
