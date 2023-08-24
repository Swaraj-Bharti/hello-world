package com.test.practice.mymap;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Dictionary<K, V> implements Map<K, V> {

    public static final int DEFAULT_CAPACITY = 16;
    private Tuple<K, V>[] buckets = (Tuple<K, V>[]) new Tuple[DEFAULT_CAPACITY];

    public Dictionary() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        Tuple<K, V> node = getNode(key);
        return node != null ;
    }

    @Override
    public boolean containsValue(Object value) {
       for(Tuple<K,V> t : buckets){
           while (t!=null){
               if(Objects.equals(t.getValue(),value)){
                   return true;
               }
               t= t.getNext();
           }
       }
       return false;
    }

    @Override
    public V get(Object key) {
        Tuple<K, V> node = getNode(key);
        return node == null ? null : node.getValue();
    }

    private Tuple<K,V> getNode(Object key) {
        Tuple<K,V> t = null;
        // calculate hash
        int hash = calcHash(key);
        //
        int index = hash & buckets.length-1;
        Tuple<K, V> tuple = buckets[index];
        if (Objects.nonNull(tuple)) {
            // find the matching key
            Tuple<K, V> curr = tuple;
            while (curr != null) {
                K currKey = curr.getKey();
                if (curr.hash == hash && Objects.equals(currKey, key))
                {
                    t=curr;
                    break;
                }
                curr = curr.getNext();
            }
        }
        return t;
    }

    private int calcHash(Object key) {
        int hash;
        if (Objects.nonNull(key)) {
            hash = key.hashCode() ;
            hash = hash ^ hash >>>16;
        } else {
            hash = 0;
        }
        return hash;
    }

    @Override
    public V put(K key, V value) {
        V prevValue =null;
        int hash = calcHash(key);

        int index = hash & buckets.length-1;
        Tuple<K, V> tuple = buckets[index];
        if (tuple == null) { // bucket is empty
            buckets[index] = new Tuple<>(hash, key, value, null);
            return prevValue;
        } else {
            // bucket has elements
            // key already exists ,then replace value

            Tuple<K,V> curr = tuple;
           while( curr != null ) {
               K currKey = curr.getKey();
               // key exist
               if (curr.hash == hash && (Objects.equals(currKey, key))) {
                   prevValue = curr.getValue();
                   curr.setValue(value);
                   break;
               }

               if( curr.getNext() == null ){
                   // you have reached end of linked-list
                   curr.next = new Tuple<>(hash, key, value, null);
                   prevValue =null;
                   break;
               }
               curr = curr.getNext();
           }
            return prevValue;
        }
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for(Map.Entry<? extends K, ? extends V> e : m.entrySet()){
            K key = e.getKey();
            V value = e.getValue();
            put(key,value);
        }

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return new AbstractSet<K>() {
            @Override
            public Iterator<K> iterator() {
                return new Iterator<K>() {

                    @Override
                    public boolean hasNext() {
                        return false;
                    }

                    @Override
                    public K next() {
                        return null;
                    }
                };
            }

            @Override
            public int size() {
                return 0;
            }
        };
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        return Map.super.getOrDefault(key, defaultValue);
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {
        Map.super.forEach(action);
    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        Map.super.replaceAll(function);
    }

    @Override
    public V putIfAbsent(K key, V value) {
        return Map.super.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return Map.super.remove(key, value);
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return Map.super.replace(key, oldValue, newValue);
    }

    @Override
    public V replace(K key, V value) {
        return Map.super.replace(key, value);
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return Map.super.computeIfAbsent(key, mappingFunction);
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return Map.super.computeIfPresent(key, remappingFunction);
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return Map.super.compute(key, remappingFunction);
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return Map.super.merge(key, value, remappingFunction);
    }
}
