package map;

import java.util.*;

@SuppressWarnings("serial")
public class NavMapAdapter<K, V> extends MapAdapter<K, V> implements
		NavigableMap<K, V> {
	// SortedMap interface

	@Override
	public Comparator<? super K> comparator() {
		throw new UnsupportedOperationException("comparator");
	}

	@Override
	public K firstKey() {
		throw new UnsupportedOperationException("firstKey");
	}

	@Override
	public K lastKey() {
		throw new UnsupportedOperationException("lastKey");
	}

	@Override
	public SortedMap<K, V> headMap(K toKey) {
		throw new UnsupportedOperationException("headMap");
	}

	@Override
	public SortedMap<K, V> subMap(K fromKey, K toKey) {
		throw new UnsupportedOperationException("subMap");
	}

	@Override
	public SortedMap<K, V> tailMap(K fromKey) {
		throw new UnsupportedOperationException("tailMap");
	}

	// NavigableMap interface

	@Override
	public K ceilingKey(K key) {
		throw new UnsupportedOperationException("ceilingKey");
	}

	@Override
	public K floorKey(K key) {
		throw new UnsupportedOperationException("floorKey");
	}

	@Override
	public K higherKey(K key) {
		throw new UnsupportedOperationException("higherKey");
	}

	@Override
	public K lowerKey(K key) {
		throw new UnsupportedOperationException("lowerKey");
	}

	@Override
	public Map.Entry<K, V> firstEntry() {
		throw new UnsupportedOperationException("firstEntry");
	}

	@Override
	public Map.Entry<K, V> lastEntry() {
		throw new UnsupportedOperationException("lastEntry");
	}

	@Override
	public Map.Entry<K, V> higherEntry(K key) {
		throw new UnsupportedOperationException("higherEntry");
	}

	@Override
	public Map.Entry<K, V> lowerEntry(K key) {
		throw new UnsupportedOperationException("lowerEntry");
	}

	@Override
	public Map.Entry<K, V> ceilingEntry(K key) {
		throw new UnsupportedOperationException("ceilingEntry");
	}

	@Override
	public Map.Entry<K, V> floorEntry(K key) {
		throw new UnsupportedOperationException("floorEntry");
	}

	@Override
	public NavigableSet<K> descendingKeySet() {
		throw new UnsupportedOperationException("descendingKeySet");
	}

	@Override
	public NavigableMap<K, V> descendingMap() {
		throw new UnsupportedOperationException("descendingKeyMap");
	}

	@Override
	public Map.Entry<K, V> pollFirstEntry() {
		throw new UnsupportedOperationException("pollFirstEntry");
	}

	@Override
	public Map.Entry<K, V> pollLastEntry() {
		throw new UnsupportedOperationException("pollLastENtry");
	}

	@Override
	public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
		throw new UnsupportedOperationException("headMap-Navigable");
	}

	@Override
	public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
		throw new UnsupportedOperationException("tailMap-Navigable");
	}

	@Override
	public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey,
			boolean toInclusive) {
		throw new UnsupportedOperationException("subMap-Navigable");
	}

	@Override
	public NavigableSet<K> navigableKeySet() {
		throw new UnsupportedOperationException("navigableSet");
	}
}