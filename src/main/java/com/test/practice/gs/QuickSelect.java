package com.test.practice.gs;

import java.util.ArrayList;
import java.util.Scanner;

public class QuickSelect {
    public static void main(String[] args) {
        int[] array = {-1,1,0,-4,-5,2,-6};
        for (int i = 0; i < array.length; i++) {
            System.out.println( (i+1) +"-min element of array: "+quickSelect(array, i));
        }

    }

    private static int quickSelect(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        if(k>=array.length){
            throw new ArrayIndexOutOfBoundsException(" k must be less than array.length");
        }
        for(;;) {
            int pivotIndex = partition(array, left, right);
            if(k == pivotIndex) {
                return array[k];
            } else if(k < pivotIndex) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
    }

    // partition the array using array[right] as a pivot
    // returns the pivot's final index
    private static int partition(int[] array, int left, int right) {
        int pivotValue = array[right];
        int swapIdx = left;
        for (int i = left; i < right; i++) {
            int element = array[i];
            if (element < pivotValue) {
                swap(array, i, swapIdx++);
            }
        }
            swap(array, swapIdx, right);
        return swapIdx;
    }

    private static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

}
