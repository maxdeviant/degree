(* Marshall Bowers *)
(* Dr Richard Wyatt *)
(* 9 December 2014 *)
(* traversals.sml *)

datatype 'a BinaryTree = empty | tree of 'a * 'a BinaryTree * 'a BinaryTree ;

fun preOrder (tree(root, empty, empty)) = [root]
| preOrder (tree(root, empty, right)) = root :: preOrder right
| preOrder (tree(root, left, empty)) = root :: preOrder left
| preOrder (tree(root, left, right)) = [root] @ preOrder left @ preOrder right;

fun inOrder (tree(root, empty, empty)) = [root]
| inOrder (tree(root, empty, right)) = root :: inOrder right
| inOrder (tree(root, left, empty)) = inOrder left @ [root]
| inOrder (tree(root, left, right)) = inOrder left @ [root] @ inOrder right;

fun postOrder (tree(root, empty, empty)) = [root]
| postOrder (tree(root, empty, right)) = postOrder right @ [root]
| postOrder (tree(root, left, empty)) = postOrder left @ [root]
| postOrder (tree(root, left, right)) = postOrder left @ postOrder right @ [root];

(* Print Functions *)

fun printInt n = print(Int.toString n);

fun printReal n = print(Real.toString n);

fun printX A = print "A"
| printX B = print "B"
| printX C = print "C"
| printX D = print "D"
| printX E = print "E"
| printX F = print "F"
| printX G = print "G"
| printX H = print "H";

fun displayTree (t, printf) =
    let
        fun indent n = if n = 0 then "" else "  " ^ (indent (n - 1));

        fun helper (tree(root, right, left), printf, n) = (
            print(indent n);
            printf root;
            print("\n");
            if right = empty then print(indent(n + 1) ^ "-\n") else helper(right, printf, (n + 1));
            if left = empty then print(indent(n + 1) ^ "-\n") else helper(left, printf, (n + 1))
        );
    in
        helper(t, printf, 0)
    end;
