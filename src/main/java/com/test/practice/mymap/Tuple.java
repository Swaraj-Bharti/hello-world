package com.test.practice.mymap;

public class Tuple<K,V> implements ITuple {
    final int hash;
    final private K key;
    private V value;
    Tuple<K, V> next;

    public Tuple(int hash, K key, V value, Tuple<K, V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public Tuple<K,V> getNext() {
        return next;
    }

    @Override
    public V setValue(Object value) {
        V temp = this.value;
        this.value = (V) value;
        return temp ;
    }
}
