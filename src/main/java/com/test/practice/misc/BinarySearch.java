package com.test.practice.misc;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 9, 11, 16, 19);
        int i ;
        i= binarySearch(list, 16);
        if (i == 6) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

         i = binarySearch(list, 1);
        if (i == 0) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        i = binarySearch(list, 9);
        if (i == 4) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
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
