package com.test.practice.misc;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 9, 11, 16, 19);
        NumberOperations<Integer> numOp= new NumberOperations<>();

        Integer index1 = numOp.binarySearch(16, Integer::compare, 1, 2, 3, 4, 9, 11, 16, 19);
        System.out.println("index1 = " + index1);
        System.out.println("testMe(list,16) = " + testMe(list, 16));
        System.out.println("testMe(list,1) = " + testMe(list, 1));
        System.out.println("testMe(list,9) = " + testMe(list, 9));

    }

    private static String testMe(List<Integer> list, int search) {
        int i= binarySearch(list, search);
        if (list.get(i) == search) {
           return "Pass";
        } else {
           return "Fail";
        }
    }

    private static int binarySearch(List<Integer> list, int search) {
        int low = 0;
        int high = list.size() - 1;
        int mid = 0;

        while (low <= high) {
            mid = (low + high ) / 2;
            Integer i = list.get(mid);
            if (i == search) {
                return mid;
            }

            if (i < search) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return -1;
    }

}
