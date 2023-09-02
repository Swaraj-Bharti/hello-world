package com.test.practice.gs;

import java.util.*;

public class WeddingAndHats {
    public static void main(String[] args) {
        ArrayList<List<String>> weddingAndAttendeesList = new ArrayList<>();

        weddingAndAttendeesList.add(Arrays.asList("a", "b","c")); //H0
        weddingAndAttendeesList.add(Arrays.asList("a", "d","e"));  //H1
        weddingAndAttendeesList.add(Arrays.asList("x", "y","z")); //H0
        weddingAndAttendeesList.add(Arrays.asList("d", "f","g")); //H0
        weddingAndAttendeesList.add(Arrays.asList("w", "x","g")); //H1
        weddingAndAttendeesList.add(Arrays.asList("p", "q","w")); //H0
        weddingAndAttendeesList.add(Arrays.asList("p", "x","e")); //H0
        hatsForWedding(weddingAndAttendeesList);

    }

    private static void hatsForWedding(ArrayList<List<String>> weddingAndAttendeesList) {
        Map<Integer,ArrayList<List<String>>> hats = new HashMap<>();

        //attend first wedding
        // update list of guest who has seen the hat.
        int currentHat = 0;
        ArrayList<List<String>> newHatGuests = new ArrayList<>();
        newHatGuests.add(weddingAndAttendeesList.get(0));
        hats.put(currentHat, newHatGuests);

        for(int i = 1; i< weddingAndAttendeesList.size(); i++) {
            boolean hatFound = false;
            for(Map.Entry<Integer,ArrayList<List<String>>> e : hats.entrySet()) {
                // is this has seen by current guest at previous wedding
                if (!hasAnyoneSeenThisHatBefore(e.getValue(), weddingAndAttendeesList.get(i))){
                    // not seen , then reuse this hat
                    e.getValue().add(weddingAndAttendeesList.get(i));
                    hatFound =true;
                    break;
                }
            }
            if(!hatFound){
                // all previous hats are seen by current wedding guest , take a new hat
                // attend the weeding
                // update list of guest who has seen the new hat.
                ArrayList<List<String>> newWedding = new ArrayList<>();
                newWedding.add(weddingAndAttendeesList.get(i));
                hats.put(++currentHat,newWedding);
            }

        }

        System.out.println(hats);
    }

    private static boolean hasAnyoneSeenThisHatBefore(ArrayList<List<String>> guestsWhoHaveSeen, List<String> currentWeddingGuests) {
        // search previous wedding guest list, has anyone form current wedding attend

        for(int j=0; j < guestsWhoHaveSeen.size() ; j ++){
            List<String> previousWedding = guestsWhoHaveSeen.get(j);
            boolean isDisjoint =  Collections.disjoint(previousWedding,currentWeddingGuests);
            if(!isDisjoint){
                return true;
            }
        }
        return false;
    }

}
