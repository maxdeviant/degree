(* Marshall Bowers *)
(* Dr Richard Wyatt *)
(* 9 December 2014 *)
(* traversals.sml *)

datatype 'a BinaryTree = empty | tree of 'a * 'a BinaryTree * 'a BinaryTree ;

fun preOrder (tree(root, left, right)) = root;

fun inOrder nil = nil;

fun postOrder nil = nil;

fun displayTree nil = nil;
