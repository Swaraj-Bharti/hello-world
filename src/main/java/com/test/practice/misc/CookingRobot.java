package com.test.practice.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CookingRobot {

    public static final String BREAD = "bread";
    public static final String HAM = "ham";
    public static final String CHEESE = "cheese";

    public static void main(String[] args) {
        // 0-> true -> has bread
        // 1-> true -> has cheese
        // 2-> true - has ham
        List<String > logs = new ArrayList<>();
        logs.addAll(Arrays.asList(BREAD,BREAD,BREAD,HAM, CHEESE, HAM,HAM, CHEESE,CHEESE,BREAD,BREAD,HAM,HAM,HAM,CHEESE,CHEESE));

       // boolean[] canCook = {false,false,false};
        int[] itemsStore = {0,0,0};
        int[] capacityRequired = new int[3];
        for(String s : logs){
            if(BREAD.equals(s)){
                if(hasCheese(itemsStore) && hasHam(itemsStore)){
                    System.out.println("Made a burger");
                    updateCheese(itemsStore);
                    updateHam(itemsStore);
                }else {
                    itemsStore[0]++;
                    if(capacityRequired[0]< itemsStore[0]){
                        capacityRequired[0]=itemsStore[0];
                    }
                }
                continue;
            }
            if(CHEESE.equals(s)){
                if(hasBread(itemsStore) && hasHam(itemsStore)){
                    System.out.println("Made a burger");
                    updateBread(itemsStore);
                    updateHam(itemsStore);
                }else {
                    itemsStore[1]++;
                    if(capacityRequired[1]< itemsStore[1]){
                        capacityRequired[1]=itemsStore[1];
                    }
                }
              continue;
            }
            if(HAM.equals(s)){
                if(hasCheese(itemsStore) && hasBread(itemsStore)){
                    System.out.println("Made a burger");
                    updateCheese(itemsStore);
                    updateBread(itemsStore);
                }else {
                    itemsStore[2]++;
                    if(capacityRequired[2]< itemsStore[2]){
                        capacityRequired[2]=itemsStore[2];
                    }
                }
            }
        }

        System.out.println("itemsStore = " + Arrays.toString(itemsStore));
        System.out.println("capacityRequired = " + Arrays.toString(capacityRequired));

    }

    private static void updateStore(int[] itemsStore, int x) {
        itemsStore[x]--;
    }

    private static void updateBread(int[] itemsStore) {
        updateStore(itemsStore,0);
    }
    private static void updateCheese(int[] itemsStore) {
        updateStore(itemsStore,1);
    }
    private static void updateHam(int[] itemsStore) {
        updateStore(itemsStore,2);
    }
    private static boolean hasItem(int[] itemsStore, int x){
        return itemsStore[x]>0  ;
    }

    private static boolean hasBread(int[] itemsStore){
        return hasItem(itemsStore,0 ) ;
    }

    private static boolean hasCheese(int[] itemsStore){
        return hasItem(itemsStore,1 ) ;
    }
    private static boolean hasHam(int[] itemsStore){
        return hasItem(itemsStore,2 ) ;
    }

}
