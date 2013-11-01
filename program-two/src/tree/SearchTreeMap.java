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

	// private String indentString = "   ";
	private String indentString = "\t";

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
		return remove(root, (K) obj, null);

		// return root.value;
	}

	private V remove(Node p, K key, K parent) {
		if (p == null) {
			return null;
		}

		Node currNode = p;

		int cmp = myCompare(p.key, key);
		System.out.println("p: " + p.key + ", k: " + key + ", cmp: " + cmp);

		System.out.println("parent of current node:" + currNode.key + " is "
				+ parent);
		// p < key
		if (cmp < 0) {
			currNode = currNode.right;
			// remove(p.right, key);
		}
		if (cmp > 0) {
			currNode = currNode.left;
			// remove(p.left, key);
		}
		if (cmp == 0) {
			System.out.println("found!");
			System.out.println("p.value: " + p.value);
			// USE PARENT VALUE HERE TO DO MAGIC REMOVAL STUFF
			return p.value;
		}
		return remove(currNode, key, p.key);
	}

	private Node removeMin(Node n) {
		if (n.left == null) {
			return n.left;
		} else {
			n.left = removeMax(n.left);
			return n;
		}
	}

	private Node removeMax(Node n) {
		if (n.right == null) {
			return n.left;
		} else {
			n.right = removeMax(n.right);
			return n;
		}
	}
}