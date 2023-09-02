package com.test.practice.misc;

import java.util.Comparator;

public class NumberOperations<N extends Number> implements INumberOperations<N>{
    @SafeVarargs
    @Override
    public final Integer binarySearch(N targetNumber, Comparator<N> comparator, N... numbers) {
        int low = 0;
        int high = numbers.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high ) / 2;
            N i = numbers[mid];
            int compare = comparator.compare(i, targetNumber);
            if (compare ==0) {
                return mid;
            }
            if (compare < 0) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return -1;
    }
}
