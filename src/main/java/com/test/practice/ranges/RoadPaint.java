package com.test.practice.ranges;


public class RoadPaint {
    public static void main(String[] args) {
        Integer[] log = {1, 7, 1, 7, 1, 11, 1, 7, 12, 20};
        RangeFunction<Integer> integerRange = new RangeFunction<>(Integer::compare, log);

        System.out.println("ranges = " + integerRange.mergeOverlappingRanges());

        Double[] log2 = {1.1, 7.2, 1.3, 7.5, 8.0, 11.5, 1.2, 7.0, 12.5, 17.8};
        RangeFunction<Double> doubleRange = new RangeFunction<>(Double::compare,log2);

        System.out.println("ranges = " + doubleRange.mergeOverlappingRanges());
    }
}



