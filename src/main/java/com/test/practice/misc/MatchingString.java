package com.test.practice.misc;

import java.util.ArrayList;
import java.util.Scanner;

public class MatchingString {
    public static void main(String[] args) {
        findStringContainsRefChars();
    }

    private static void findStringContainsRefChars() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the n: ");
        int n = sc.nextInt();
        String[] strs = new String[n];
        String[] refStrs = {"1","2","3"};
        boolean hasRefs = false;
        ArrayList<String> out = new ArrayList<>();
        for(int i =0 ; i<n ;i++){
            hasRefs = true;
            System.out.print("Enter String: ");
            strs[i] = sc.next();
            for(int j = 0; j<refStrs.length; j++){
                hasRefs = hasRefs && strs[i].contains(refStrs[j]);
            }
            if(hasRefs){
                out.add(strs[i]);
            }
        }
        System.out.println("out = " + out);
    }
}
