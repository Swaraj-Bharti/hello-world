package com.test.practice.list;

import java.util.Objects;

public class Node<T> {
    T data;
    Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return Objects.toString(data);
    }
}
