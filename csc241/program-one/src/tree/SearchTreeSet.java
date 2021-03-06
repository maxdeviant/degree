package tree;

import java.util.*;

import util.Mutable;

public class SearchTreeSet<E> extends set.NavSetAdapter<E> {
	private class Node {
		E data;
		Node left, right;

		Node(E data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private Node root = null;
	private int size = 0;
	private Comparator<? super E> cmp = null;

	public SearchTreeSet(Comparator<? super E> cmp) {
		this.cmp = cmp;
	}

	public SearchTreeSet() {
	}

	private int myCompare(E lhs, E rhs) {
		if (cmp == null) {
			return ((Comparable) lhs).compareTo(rhs);
		} else {
			return cmp.compare(lhs, rhs);
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		root = null;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public java.util.Comparator<? super E> comparator() {
		return cmp;
	}

	private boolean contains(Node n, E elt) {
		if (n == null) {
			return false;
		}
		int comp = myCompare(elt, n.data);
		if (comp < 0) {
			return contains(n.left, elt);
		} else if (comp > 0) {
			return contains(n.right, elt);
		} else {
			return true;
		}
	}

	@Override
	public boolean contains(Object obj) {
		E elt = (E) obj;
		return contains(root, elt);
	}

	private Node add(Node n, E elt, Mutable<Boolean> found) {
		if (n == null) {
			found.set(false);
			return new Node(elt, null, null);
		}
		int comp = myCompare(elt, n.data);
		if (comp < 0) {
			n.left = add(n.left, elt, found);
			return n;
		} else if (comp > 0) {
			n.right = add(n.right, elt, found);
			return n;
		} else {
			found.set(true);
			return n;
		}
	}

	@Override
	public boolean add(E elt) {
		Mutable<Boolean> found = new Mutable<Boolean>();
		root = add(root, elt, found);
		if (!found.get()) {
			++size;
		}
		return !found.get();
	}

	private Node removeMin(Node n, Mutable<E> save) {
		if (n.left == null) {
			save.set(n.data);
			return n.right;
		} else {
			n.left = removeMin(n.left, save);
			return n;
		}
	}

	private Node removeMax(Node n, Mutable<E> save) {
		if (n.right == null) {
			save.set(n.data);
			return n.left;
		} else {
			n.right = removeMax(n.right, save);
			return n;
		}
	}

	// used to randomly choose findMin/findMax in remove operations
	private Random flipACoin = new Random();

	private Node remove(Node n, E elt, Mutable<Boolean> found) {
		if (n == null) {
			found.set(false);
			return null;
		}
		int comp = myCompare(elt, n.data);
		if (comp < 0) {
			n.left = remove(n.left, elt, found);
			return n;
		}
		if (comp > 0) {
			n.right = remove(n.right, elt, found);
			return n;
		}
		found.set(true);
		if (n.left == null) {
			return n.right;
		}
		if (n.right == null) {
			return n.left;
		}
		Mutable<E> save = new Mutable<E>();
		boolean choose_min = (flipACoin.nextInt(2) == 1);
		if (choose_min) {
			n.right = removeMin(n.right, save);
		} else {
			n.left = removeMax(n.left, save);
		}
		n.data = save.get();
		return n;
	}

	@Override
	public boolean remove(Object obj) {
		if (isEmpty()) {
			return false;
		}
		E elt = (E) obj;
		Mutable<Boolean> found = new Mutable<Boolean>();
		root = remove(root, elt, found);
		if (found.get()) {
			--size;
		}
		return found.get();
	}

	// structure-revealing operations
	private String indentString = "   ";

	public void setIndentString(String indentString) {
		this.indentString = indentString;
	}

	public void inorderOutput() {
		inorderOutput(root, 0);
	}

	public void reverseInorderOutput() {
		reverseInorderOutput(root, 0);
	}

	public void preorderOutput() {
		preorderOutput(root, 0);
	}

	public void postorderOutput() {
		postorderOutput(root, 0);
	}

	private String repeat(String s, int times) {
		String output = "";
		for (int i = 0; i < times; ++i) {
			output += s;
		}
		return output;
	}

	private void inorderOutput(Node n, int level) {
		if (n != null) {
			inorderOutput(n.left, level + 1);
			System.out.println(repeat(indentString, level) + n.data);
			inorderOutput(n.right, level + 1);
		}
	}

	private void reverseInorderOutput(Node n, int level) {
		if (n != null) {
			reverseInorderOutput(n.right, level + 1);
			System.out.println(repeat(indentString, level) + n.data);
			reverseInorderOutput(n.left, level + 1);
		}
	}

	private void preorderOutput(Node n, int level) {
		if (n != null) {
			System.out.println(repeat(indentString, level) + n.data);
			preorderOutput(n.left, level + 1);
			preorderOutput(n.right, level + 1);
		}
	}

	private void postorderOutput(Node n, int level) {
		if (n != null) {
			postorderOutput(n.left, level + 1);
			postorderOutput(n.right, level + 1);
			System.out.println(repeat(indentString, level) + n.data);
		}
	}

	// toArray is basically an inorder traversal.
	// The incoming index marks the last position in the array before
	// execution, and the return value marks the last position in
	// the array after execution.
	private int toArray(Object[] arr, int index, Node n) {
		if (n == null) {
			return index;
		} else {
			index = toArray(arr, index, n.left);
			arr[index++] = n.data;
			return toArray(arr, index, n.right);
		}
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Comparable[size]; // new Object[size] causes problems!
		toArray(arr, 0, root);
		return arr;
	}

	@Override
	public String toString() {
		return java.util.Arrays.toString(toArray());
	}

	@Override
	public Iterator<E> iterator() {
		return Arrays.asList((E[]) toArray()).listIterator();
	}

	// added by Marshall Bowers

	@Override
	public E first() {
		// Return null if the set is empty
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		// Set the current node to root
		Node currNode = root;

		// While the left hand side of the current node is not null
		while (currNode.left != null) {
			// Set the current node equal to the left node
			currNode = currNode.left;
		}

		// Return the value of the current node
		return currNode.data;
	}

	@Override
	public E last() {
		// Return null if the set is empty
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		// Set the current node to root
		Node currNode = root;

		// While the right hand side of the current node is not null
		while (currNode.right != null) {
			// Set the current node equal to the right node
			currNode = currNode.right;
		}

		// Return the value of the current node
		return currNode.data;
	}

	@Override
	public E pollFirst() {
		// Return null if the set is empty
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		// Set the current node to root
		Node currNode = root;

		// While the left hand side of the current node is not null
		while (currNode.left != null) {
			// Set the current node equal to the left node
			currNode = currNode.left;
		}

		// Remove the current node from the set
		remove(currNode.data);

		// Return the value of the current node
		return currNode.data;
	}

	@Override
	public SortedSet<E> headSet(E before) {
		// Create a new SortedSet
		SortedSet<E> set = new SearchTreeSet<E>();

		// Return the empty set if the tree is empty
		if (isEmpty()) {
			return set;
		}

		// Compare the argument with the first node in the tree
		int cmp = myCompare(before, first());

		// If the first node is smaller than the argument
		if (cmp > 0) {
			// Call the helper function
			headSet(root, before, set);
		}

		// Else: no nodes smaller than the argument
		// Return the empty set
		return set;
	}

	// headSet helper function
	private void headSet(Node n, E before, SortedSet<E> set) {
		// Compare the argument with the current node
		int cmp = myCompare(before, n.data);

		// If the current node is smaller than the argument
		if (cmp > 0) {
			// Add the current node to the set
			set.add(n.data);

			// Check if the right hand side exists
			if (n.right != null) {
				// Recall the helper function on the right node
				headSet(n.right, before, set);
			}
		}

		// Check if the left hand side exists
		if (n.left != null) {
			// Recall the helper function on the left node
			headSet(n.left, before, set);
		}
	}

	@Override
	public E floor(E elt) {
		// Create a new node equal to the result of floor
		Node n = floor(root, elt);

		// If the result was null, return null
		if (n == null) {
			return null;
		} else {
			// Otherwise, return the data value of the current node
			return n.data;
		}
	}

	// floor helper function
	private Node floor(Node n, E elt) {
		// Return null if the current node is null
		if (n == null) {
			return null;
		}

		// Compare argument and the value of the node
		int cmp = myCompare(elt, n.data);

		// If the current node is less than the argument
		if (cmp < 0) {
			// Recall floor on the left hand side
			return floor(n.left, elt);
		} else if (cmp == 0) {
			// If the current node is the same as the argument
			// Return the current node
			return n;
		}

		// If the current node is greater than the argument
		// Create a new node equal to the largest element on the right
		Node r = floor(n.right, elt);

		// Return this node if it is not null
		if (r != null) {
			return r;
		} else {
			// Return the current node
			return n;
		}
	}
}