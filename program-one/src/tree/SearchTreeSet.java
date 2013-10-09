package tree;

import java.util.SortedSet;

@SuppressWarnings("serial")
public class SearchTreeSet<E> extends set.NavSetAdapter<E> {

	public void reverseInorderOutput() {
		// TODO Auto-generated method stub

	}

	// added by Marshall
	@Override
	public E first() {
		return null;
	}

	@Override
	public E last() {
		return null;
	}

	@Override
	public E pollFirst() {
		return null;
	}

	@Override
	public SortedSet<E> headSet(E before) {
		SortedSet<E> set = new SearchTreeSet<E>();
		headSet(root, before, set);
		return set;
	}

	private void headSet(Node n, E before, SortedSet<E> set) {
	}

	@Override
	public E floor(E elt) {
		return null;
	}
}
