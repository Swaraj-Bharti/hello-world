package com.test.practice.misc;

import java.util.Comparator;

public interface INumberOperations<N extends Number> {
    Integer binarySearch(N targetNumber, Comparator<N> comparator, N... numbers);
}
