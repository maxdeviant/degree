package tree;

import java.util.*;

import set.SetAdapter;
import util.Mutable;

public class SearchTreeMap<K, V> extends map.NavMapAdapter<K, V> {
	private class Node {
		K key;
		V value;
		Node left, right;

		Node(K key, V value, Node left, Node right) {
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	private Node root = null;
	private int size = 0;
	private Comparator<? super K> cmp = null;

	public SearchTreeMap(Comparator<? super K> cmp) {
		this.cmp = cmp;
	}

	public SearchTreeMap() {
	}

	private int myCompare(K lhs, K rhs) {
		if (cmp == null) {
			return ((Comparable) lhs).compareTo(rhs);
		} else {
			return cmp.compare(lhs, rhs);
		}
	}

	@Override
	public java.util.Comparator<? super K> comparator() {
		return cmp;
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

	private Node put(Node n, K key, V value, Mutable<Boolean> found,
			Mutable<V> oldvalue) {
		if (n == null) {
			oldvalue.set(null);
			found.set(false);
			return new Node(key, value, null, null);
		}
		int comp = myCompare(key, n.key);
		if (comp < 0) {
			n.left = put(n.left, key, value, found, oldvalue);
			return n;
		}
		if (comp > 0) {
			n.right = put(n.right, key, value, found, oldvalue);
			return n;
		}
		oldvalue.set(n.value);
		n.value = value;
		found.set(true);
		return n;
	}

	@Override
	public V put(K key, V value) {

		Mutable<Boolean> found = new Mutable<Boolean>();
		Mutable<V> oldvalue = new Mutable<V>();

		root = put(root, key, value, found, oldvalue);

		if (!found.get()) {
			++size;
		}
		return oldvalue.get();
	}

	@Override
	public V get(Object obj) {
		K key = (K) obj;
		return get(key, root);
	}

	private V get(K key, Node n) {
		if (n == null) {
			return null;
		}
		int comp = myCompare(key, n.key);
		if (comp < 0) {
			return get(key, n.left);
		}
		if (comp > 0) {
			return get(key, n.right);
		}
		return n.value;
	}

	@Override
	public boolean containsKey(Object obj) {
		K key = (K) obj;
		Node n = root;
		while (n != null) {
			int comp = myCompare(key, n.key);
			if (comp == 0) {
				return true;
			}
			if (comp < 0) {
				n = n.left;
			} else {
				n = n.right;
			}
		}
		return false;
	}

	private int entryArray(Object[] arr, int index, Node n) {
		if (n == null) {
			return index;
		} else {
			index = entryArray(arr, index, n.left);
			arr[index++] = new AbstractMap.SimpleEntry(n.key, n.value);
			return entryArray(arr, index, n.right);
		}
	}

	public class EntrySet extends SetAdapter {
		Object[] arr;

		EntrySet(Object[] arr) {
			this.arr = arr;
		}

		@Override
		public Iterator<Map.Entry<K, V>> iterator() {
			return new Iterator<Map.Entry<K, V>>() {
				int i = 0;

				@Override
				public boolean hasNext() {
					return i < arr.length;
				}

				@Override
				public Map.Entry<K, V> next() {
					return (Map.Entry<K, V>) arr[i++];
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException("Not supported.");
				}
			};
		}
	}

	@Override
	public String toString() {
		Object[] arr = new Object[size];
		entryArray(arr, 0, root);
		return java.util.Arrays.toString(arr);
	}

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Object[] arr = new Object[size];
		entryArray(arr, 0, root);
		return new EntrySet(arr);
	}

	@Override
	public Collection<V> values() {
		Collection<V> vals = new LinkedList<V>();
		addToValues(root, vals);
		return vals;
	}

	private void addToValues(Node n, Collection<V> vals) {
		if (n == null) {
			return;
		}
		vals.add(n.value);
		addToValues(n.left, vals);
		addToValues(n.right, vals);
	}

	@Override
	public Set<K> keySet() {
		Set kset = new TreeSet<K>();
		addToKeySet(root, kset);
		return kset;
	}

	private void addToKeySet(Node n, Set<K> kset) {
		if (n == null) {
			return;
		}
		kset.add(n.key);
		addToKeySet(n.left, kset);
		addToKeySet(n.right, kset);
	}

	private String indentString = "   ";

	public void setIndentString(String indentString) {
		this.indentString = indentString;
	}

	public void reverseInorderOutput() {
		reverseInorderOutput(root, 0);
	}

	private void reverseInorderOutput(Node n, int level) {
		if (n != null) {
			reverseInorderOutput(n.right, level + 1);

			System.out.println(repeat(indentString, level) + n.key + "="
					+ n.value);
			reverseInorderOutput(n.left, level + 1);
		}
	}

	private static String repeat(String str, int times) {
		return new String(new char[times]).replace("\0", str);
	}

	// added by Marshall Bowers

	@Override
	public V remove(Object obj) {
		// If the tree is empty, return null
		if (isEmpty()) {
			return null;
		}

		// Create two Mutable objects to hold the found and oldValue variables
		Mutable<Boolean> found = new Mutable<Boolean>(false);
		Mutable<V> oldV = new Mutable<V>();

		// Set the root Node to the result of calling the remove method on root
		root = remove(root, (K) obj, oldV, found);

		// If the key was found in the tree, decrement the size
		if (found.get()) {
			--size;
		}

		// Return the oldValue, which corresponds to the key passed in
		return oldV.get();
	}

	// Create a new RNG to 'flip a coin' to prevent skewing of the tree
	private Random flipACoin = new Random();

	// remove helper function
	private Node remove(Node n, K key, Mutable<V> value, Mutable<Boolean> found) {
		// If the current node is null, return null
		if (n == null) {
			return null;
		}

		// Compare the argument key with the key of the current node
		int cmp = myCompare(key, n.key);

		// If the argument comes before the current node
		if (cmp < 0) {
			// Set the LHS to the result of calling the remove method on the
			// LHS, then return
			n.left = remove(n.left, key, value, found);
			return n;
		}

		// If the argument comes after the current node
		if (cmp > 0) {
			// Set the LHS to the result of calling the remove method on the
			// LHS, then return
			n.right = remove(n.right, key, value, found);
			return n;
		}

		// If the argument equals the current node

		// Denote that we have found the matching node and store the value
		found.set(true);
		value.set(n.value);

		// If the LHS is null, return the RHS
		if (n.left == null) {
			return n.right;
		}

		// If the RHS is null, return the LHS
		if (n.right == null) {
			return n.left;
		}

		// Create two Mutable objects to hold the key and value variables
		Mutable<K> saveK = new Mutable<K>();
		Mutable<V> saveV = new Mutable<V>();

		// Get a new random value to eliminate possible skewing
		boolean chooseMin = (flipACoin.nextInt(2) == 1);

		if (chooseMin) {
			// Set the RHS to the result of calling
			// the removeMin method on the RHS
			n.right = removeMin(n.right, saveK, saveV);
		} else {
			// Set the LHS to the result of calling
			// the removeMin method on the LHS
			n.left = removeMax(n.left, saveK, saveV);
		}

		// Set the key and value of the current node to the values stored in
		// their respective Mutable objects
		n.key = saveK.get();
		n.value = saveV.get();

		// Return the current node
		return n;
	}

	// Remove the right-most node in a subset of the tree, starting at Node n
	private Node removeMax(Node n, Mutable<K> saveK, Mutable<V> saveV) {
		// Once the right-most node (max) has been reached
		if (n.right == null) {
			// Save the key and value of the current node
			saveK.set(n.key);
			saveV.set(n.value);

			// Return the LHS
			return n.left;
		} else {
			// Set the RHS to the result of calling removeMax on the RHS,
			// then return
			n.right = removeMax(n.right, saveK, saveV);
			return n;
		}
	}

	// Remove the left-most node in a subset of the tree, starting at Node n
	private Node removeMin(Node n, Mutable<K> saveK, Mutable<V> saveV) {
		// Once the left-most node (min) has been reached
		if (n.left == null) {
			// Save the key and value of the current node
			saveK.set(n.key);
			saveV.set(n.value);

			// Return the RHS
			return n.right;
		} else {
			// Set the LHS to the result of calling removeMax on the LHS,
			// then return
			n.left = removeMin(n.left, saveK, saveV);
			return n;
		}
	}
}