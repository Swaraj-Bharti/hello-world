package com.test.practice.ranges;


import java.util.Comparator;

public record Range<N extends Number>(N start, N end) {
    @Override
    public String toString() {
        return "[" + start + ", "+ end + ']';
    }
}
