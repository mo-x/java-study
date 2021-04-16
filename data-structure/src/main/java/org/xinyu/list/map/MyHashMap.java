package org.xinyu.list.map;

/**
 * HashMap 简单实现
 *
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K, V> {

    private class Entry<K, V> {
        int hash;
        K key;
        V value;
        Entry<K, V> next;

        Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private static final int DEFAULT_CAPACITY = 1 << 4;

    private Entry[] table;

    private int capacity;

    private int size;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        } else {
            table = new Entry[capacity];
            size = 0;
            this.capacity = capacity;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(K key) {
        double tmp = key.hashCode() * (Math.pow(5, 0.5) - 1) / 2;
        double digit = tmp - Math.floor(tmp);
        return (int) Math.floor(digit * capacity);
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        int hash = hash(key);
        Entry<K, V> nEntry = new Entry<>(hash, key, value, null);
        Entry<K, V> entry = table[hash];
        while (entry != null) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }
        nEntry.next = table[hash];
        table[hash] = nEntry;
        size++;
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        int hash = hash(key);
        Entry<K, V> entry = table[hash];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>();
        map.put("1", "11");
        map.put("1", "22");
        map.put("3", "33");
        System.out.println(map.get("3"));
    }

}
