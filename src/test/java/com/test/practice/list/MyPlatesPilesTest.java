package com.test.practice.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyPlatesPilesTest {

    @Test
    void addToPileOnePlate() {
        MyPlatesPiles pileOfPlates = new MyPlatesPiles();
        MyPlate myPlate1 = new MyPlate(1, 5);
        MyPlate myPlate2 = new MyPlate(1, 0);
        pileOfPlates.addToPile(new Plate<>(myPlate1));
        assertEquals(myPlate1, pileOfPlates.getNthValue(1));

        pileOfPlates.addToPile(new Plate<>(myPlate2));
        assertEquals(myPlate2, pileOfPlates.getNthValue(1));
        assertEquals(myPlate1, pileOfPlates.getNthValue(2));

        MyPlate myPlate3 = new MyPlate(2, 0);
        MyPlate myPlate4 = new MyPlate(2, 5);
        pileOfPlates.addToPile(new Plate<>(myPlate3));
        pileOfPlates.addToPile(new Plate<>(myPlate4));

        assertEquals(myPlate2, pileOfPlates.getNthValue(1));
        assertEquals(myPlate3, pileOfPlates.getNthValue(2));
        assertEquals(myPlate1, pileOfPlates.getNthValue(3));
        assertEquals(myPlate4, pileOfPlates.getNthValue(4));


        MyPlate myPlate5 = new MyPlate(1, 3);
        MyPlate myPlate6 = new MyPlate(1, 6);
        pileOfPlates.addToPile(new Plate<>(myPlate5));
        pileOfPlates.addToPile(new Plate<>(myPlate6));

        assertEquals(myPlate2, pileOfPlates.getNthValue(1));
        assertEquals(myPlate3, pileOfPlates.getNthValue(2));
        assertEquals(myPlate5, pileOfPlates.getNthValue(3));
        assertEquals(myPlate1, pileOfPlates.getNthValue(4));
        assertEquals(myPlate4, pileOfPlates.getNthValue(5));
        assertEquals(myPlate6, pileOfPlates.getNthValue(6));

    }

    @Test
    void testAddToPileTwoPlates() {
        MyPlatesPiles pileOfPlates = new MyPlatesPiles();
        MyPlate myPlate1 = new MyPlate(1, 5);
        MyPlate myPlate2 = new MyPlate(1, 0);
        pileOfPlates.addToPile(new Plate<>(myPlate1));
        assertEquals(myPlate1, pileOfPlates.getNthValue(1));

        pileOfPlates.addToPile(new Plate<>(myPlate2));
        assertEquals(myPlate2, pileOfPlates.getNthValue(1));
        assertEquals(myPlate1, pileOfPlates.getNthValue(2));

        MyPlate myPlate3 = new MyPlate(2, 0);
        MyPlate myPlate4 = new MyPlate(2, 5);
        pileOfPlates.addToPile(new Plate<>(myPlate3),new Plate<>(myPlate4));


        assertEquals(myPlate2, pileOfPlates.getNthValue(1));
        assertEquals(myPlate3, pileOfPlates.getNthValue(2));
        assertEquals(myPlate4, pileOfPlates.getNthValue(3));
        assertEquals(myPlate1, pileOfPlates.getNthValue(4));


        MyPlate myPlate5 = new MyPlate(1, 4);
        MyPlate myPlate6 = new MyPlate(1, 5);

        pileOfPlates.addToPile(new Plate<>(myPlate5),new Plate<>(myPlate6));

        assertEquals(myPlate2, pileOfPlates.getNthValue(1));
        assertEquals(myPlate3, pileOfPlates.getNthValue(2));
        assertEquals(myPlate5, pileOfPlates.getNthValue(3));
        assertEquals(myPlate6, pileOfPlates.getNthValue(4));
        assertEquals(myPlate4, pileOfPlates.getNthValue(5));
        assertEquals(myPlate1, pileOfPlates.getNthValue(6));

        MyPlate myPlate7 = new MyPlate(2, 4);
        MyPlate myPlate8 = new MyPlate(1, 3);

        pileOfPlates.addToPile(new Plate<>(myPlate7),new Plate<>(myPlate8));

        assertEquals(myPlate2, pileOfPlates.getNthValue(1));
        assertEquals(myPlate3, pileOfPlates.getNthValue(2));
        assertEquals(myPlate8, pileOfPlates.getNthValue(3));
        assertEquals(myPlate7, pileOfPlates.getNthValue(4));
        assertEquals(myPlate5, pileOfPlates.getNthValue(5));
        assertEquals(myPlate6, pileOfPlates.getNthValue(6));
        assertEquals(myPlate4, pileOfPlates.getNthValue(7));
        assertEquals(myPlate1, pileOfPlates.getNthValue(8));

    }
}