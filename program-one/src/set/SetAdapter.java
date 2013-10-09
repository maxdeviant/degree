package set;

import java.util.*;
import java.io.Serializable;

public class SetAdapter<E> implements Cloneable, Set<E>, Serializable {

	// Iterable
	@Override
	public Iterator<E> iterator() {
		throw new UnsupportedOperationException("iterator");
	}

	// Collection
	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException("remove");
	}

	@Override
	public boolean add(E e) {
		throw new UnsupportedOperationException("add");
	}

	@Override
	public int size() {
		throw new UnsupportedOperationException("size");
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException("addAll");
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException("removeAll");
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException("retainAll");
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException("containsAll");
	}

	@Override
	public boolean contains(Object o) {
		throw new UnsupportedOperationException("contains");
	}

	@Override
	public boolean isEmpty() {
		throw new UnsupportedOperationException("isEmpty");
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException("clear");
	}

	@Override
	public <E> E[] toArray(E[] a) {
		throw new UnsupportedOperationException("toArray(E[])");
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException("toArray()");
	}
}