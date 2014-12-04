(* Marshall Bowers *)
(* Dr Richard Wyatt *)
(* 9 December 2014 *)
(* traversals.sml *)

datatype 'a BinaryTree = empty | tree of 'a * 'a BinaryTree * 'a BinaryTree ;

(* Perform a pre-order binary tree traversal *)
fun preOrder (tree(root, empty, empty)) = [root]
| preOrder (tree(root, empty, right)) = root :: preOrder right
| preOrder (tree(root, left, empty)) = root :: preOrder left
| preOrder (tree(root, left, right)) = [root] @ preOrder left @ preOrder right;

(* Perform an in-order binary tree traversal *)
fun inOrder (tree(root, empty, empty)) = [root]
| inOrder (tree(root, empty, right)) = root :: inOrder right
| inOrder (tree(root, left, empty)) = inOrder left @ [root]
| inOrder (tree(root, left, right)) = inOrder left @ [root] @ inOrder right;

(* Perform a post-order binary tree traversal *)
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

(* Display a binary tree, t, using the given function, printf *)
fun displayTree (t, printf) =
    let
        (* Create whitespace based on indentation level, n *)
        fun indent n = if n = 0 then "" else "  " ^ (indent (n - 1));

        (* Display a root node at the given indentation level *)
        fun displayNode (root, n) = (
            print(indent n);
            printf root;
            print("\n")
        );

        (* Display a placeholder for an empty node at the given indentation level *)
        fun displayEmptyNode n = print(indent(n + 1) ^ "-\n");

        fun helper (tree(root, empty, empty), printf, n) = displayNode (root, n)
        (* If the left tree is empty *)
        | helper (tree(root, empty, right), printf, n) = (
            displayNode (root, n);
            displayEmptyNode n;
            helper(right, printf, (n + 1))
        ) (* If the right tree is empty *)
        | helper (tree(root, left, empty), printf, n) = (
            displayNode (root, n);
            helper(left, printf, (n + 1));
            displayEmptyNode n
        ) (* If neither tree is empty *)
        | helper (tree(root, left, right), printf, n) = (
            displayNode (root, n);
            helper(left, printf, (n + 1));
            helper(right, printf, (n + 1))
        );
    in
        helper(t, printf, 0)
    end;
