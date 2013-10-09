package set;

import java.util.*;

@SuppressWarnings("serial")
public class NavSetAdapter<E> extends SetAdapter<E> implements NavigableSet<E> {
	// SortedSet interface

	@Override
	public Comparator<? super E> comparator() {
		throw new UnsupportedOperationException("comparator");
	}

	@Override
	public E first() {
		throw new UnsupportedOperationException("first");
	}

	@Override
	public E last() {
		throw new UnsupportedOperationException("last");
	}

	@Override
	public SortedSet<E> headSet(E toElement) {
		throw new UnsupportedOperationException("headSet(E)");
	}

	@Override
	public SortedSet<E> subSet(E fromElement, E toElement) {
		throw new UnsupportedOperationException("subSet(E,E)");
	}

	@Override
	public SortedSet<E> tailSet(E fromElement) {
		throw new UnsupportedOperationException("tailSet(E)");
	}

	// NavigableSet interface

	@Override
	public E higher(E e) {
		throw new UnsupportedOperationException("higher");
	}

	@Override
	public E lower(E e) {
		throw new UnsupportedOperationException("lower");
	}

	@Override
	public E pollFirst() {
		throw new UnsupportedOperationException("pollFirst");
	}

	@Override
	public E pollLast() {
		throw new UnsupportedOperationException("pollLast");
	}

	@Override
	public E ceiling(E e) {
		throw new UnsupportedOperationException("ceiling");
	}

	@Override
	public E floor(E e) {
		throw new UnsupportedOperationException("floor");
	}

	@Override
	public Iterator<E> descendingIterator() {
		throw new UnsupportedOperationException("descendingIterator");
	}

	@Override
	public NavigableSet<E> descendingSet() {
		throw new UnsupportedOperationException("descendingSet");
	}

	@Override
	public NavigableSet<E> headSet(E toElement, boolean inclusive) {
		throw new UnsupportedOperationException("headSet(E,boolean)");
	}

	@Override
	public NavigableSet<E> subSet(E fromElement, boolean fromInclusive,
			E toElement, boolean toInclusive) {
		throw new UnsupportedOperationException("subSet(E,boolean,E,boolean)");
	}

	@Override
	public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
		throw new UnsupportedOperationException("tailSet");
	}
}