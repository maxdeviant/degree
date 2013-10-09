package util;

public final class Mutable<E> {
	private E value = null;

	public E get() {
		return value;
	}

	public void set(E value) {
		this.value = value;
	}

	public Mutable() {
	}

	public Mutable(E value) {
		set(value);
	}
}