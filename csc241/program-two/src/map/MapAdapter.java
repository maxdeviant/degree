package map;

import java.util.*;
import java.io.Serializable;

@SuppressWarnings("serial")
public class MapAdapter<K, V> implements Map<K, V>, Cloneable, Serializable {

	// Map interface

	@Override
	public V get(Object key) {
		throw new UnsupportedOperationException("get");
	}

	@Override
	public V put(K key, V value) {
		throw new UnsupportedOperationException("put");
	}

	@Override
	public V remove(Object key) {
		throw new UnsupportedOperationException("remove");
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException("clear");
	}

	@Override
	public boolean containsKey(Object key) {
		throw new UnsupportedOperationException("containsKey");
	}

	@Override
	public boolean containsValue(Object value) {
		throw new UnsupportedOperationException("containsValue");
	}

	@Override
	public boolean isEmpty() {
		throw new UnsupportedOperationException("isEmpty");
	}

	@Override
	public int size() {
		throw new UnsupportedOperationException("size");
	}

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		throw new UnsupportedOperationException("entrySet");
	}

	@Override
	public Set<K> keySet() {
		throw new UnsupportedOperationException("keySet");
	}

	@Override
	public Collection<V> values() {
		throw new UnsupportedOperationException("values");
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		throw new UnsupportedOperationException("putAll");
	}
}