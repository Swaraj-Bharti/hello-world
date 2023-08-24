package com.test.practice.mymap;

public interface ITuple<K,V>{
    K getKey();
    V getValue();
    ITuple<K,V> getNext();

    V setValue(V value);
}
