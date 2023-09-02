package com.test.practice.list;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * All these types of plate
 * You invited your family for the greatest of all dinners, and everyone enjoyed it.
 *
 * You are now doing the washing-up. Your cousin is cleaning some plates and then giving them to you. You put them in your giant pile of various plates.
 *
 * The pile is arranged so that every plate of the same type is grouped. There is no specific order between the plate groups.
 *
 * Your cousin gives you one or two plates at a time. When there are two plates, and when they belong to two different groups, it’s always two neighboring groups. Your cousin never gives you plates from unknown groups. But the two plates are not necessarily in the same order as in the pile.
 *
 * This washing-up has to be finished fast. So, each time your cousin gives you some plates, you want to insert them in the pile in only one action.
 *
 * The pile can be very high (thousands of plates, you have a big family!), so browsing through the whole stack at each insertion can be too long.
 *
 * Keep in mind that the pile changes while you add plates to it!
 *
 * Example
 * Let’s say you begin with this pile of plates:
 *
 * flower-decorated plate
 * light green plate
 * light green plate
 * big blue plate
 * big blue plate
 * The “flower-decorated plate” is at the index 0.
 *
 * Your cousin gives you two “light green plates”. They can be inserted at indexes 1, 2, or 3. When multiple indexes are allowed, you must answer the lowest one. You must also answer a boolean to tell if the two plates must be reversed before insertion.
 *
 * Then, your cousin gives you a “big blue plate” and a “light green plate”. They must be inserted at the transition between the two groups. It was previously at index 3, but because of the previous insertion, the correct index is now 5. The boolean must be True, because the group of light green plates is before the group of big blue plates.
 *
 * Happy washing-up!
 */
public class MyPlatesPiles {
    // map of group start and end
    Plate<MyPlate> pileOfPlates = null;
    Map<Integer, Plate<MyPlate>> groupIndex = new HashMap<>();

    void addToPile(Plate<MyPlate> plate){
        // is existing group
        if(plate !=null) {
            Plate<MyPlate> platePointer = groupIndex.get(plate.myPlate.groupId);
            if (platePointer !=null){
                linkThePlates(plate, platePointer);
            }else {
                if(plate.myPlate.groupId == 0){
                    if(pileOfPlates !=null) {
                        plate.next = groupIndex.get(pileOfPlates.myPlate.groupId);
                    }
                    pileOfPlates = plate;
                    groupIndex.put(plate.myPlate.groupId,plate);
                }else {
                    int prevGroup = plate.myPlate.groupId - 1;
                    while (prevGroup >= 0 && groupIndex.get(prevGroup) == null) {
                        prevGroup--;
                    }
                    Plate<MyPlate> plateX = groupIndex.get(prevGroup);
                    linkThePlates(plate,plateX);
                    if(pileOfPlates ==null){
                        pileOfPlates = plate;
                    }
                }
            }
        }
    }

    private void linkThePlates(Plate<MyPlate> plate, Plate<MyPlate> platePointer) {
        if(plate.next !=null){
            plate.next.next = platePointer !=null ? platePointer.next : platePointer;
        }else{
            plate.next = platePointer !=null ? platePointer.next : platePointer;;
        }
        if(platePointer !=null) {
            platePointer.next = plate;
        }
        groupIndex.put(plate.myPlate.groupId, plate);
    }

    void addToPile(Plate<MyPlate> plate1, Plate<MyPlate> plate2){
         if(plate1 !=null && plate2 !=null){
             if(plate1.myPlate.groupId < plate2.myPlate.groupId){
                 plate1.next=plate2;
                 addToPile(plate1);
             }else{
                 plate2.next = plate1;
                 addToPile(plate2);
             }
         }
    }

    MyPlate getNthValue(int n) {
        if (n > 0) {
            Plate<MyPlate> node = pileOfPlates;
            int count = 0;
            while (node != null) {
                if (n == ++count) break;
                node = node.next;
            }
            return n == count ? node.myPlate : null;
        }

        return null;
    }
}


class Plate<T> {
    T myPlate;
    Plate<T> next;

    public Plate(T myPlate) {
        this.myPlate = myPlate;
    }
    @Override
    public String toString() {
        return Objects.toString(myPlate);
    }
}

class MyPlate {
    int id;
    int groupId;

    public MyPlate(int id, int groupId) {
        this.id = id;
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPlate myPlate = (MyPlate) o;
        return id == myPlate.id && groupId == myPlate.groupId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupId);
    }

    @Override
    public String toString() {
        return "MyPlate{" +
                "id=" + id +
                ", groupId=" + groupId +
                '}';
    }
}