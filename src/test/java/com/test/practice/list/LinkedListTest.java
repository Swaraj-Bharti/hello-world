package com.test.practice.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void addNodeAtStart() {
        LinkedList<Integer> l = new LinkedList<>();
        l.addNodeAtStart(10);
        assertTrue(l.contains(10));
        System.out.println(l);
    }

    @Test
    void addMultipleNodesAtStart() {
        LinkedList<Integer> l = new LinkedList<>();
        l.addNodeAtStart(10);
        assertTrue(l.contains(10));
        assertEquals(10, l.getNthValue(1));
        System.out.println(l);
        l.addNodeAtStart(20);
        assertEquals(20, l.getNthValue(1));
        assertEquals(10, l.getNthValue(2));
        l.addNodeAtStart(30);
        assertEquals(30, l.getNthValue(1));
        assertEquals(20, l.getNthValue(2));
        assertEquals(10, l.getNthValue(3));
        System.out.println(l);
    }

    @Test
    void containsElements() {
        LinkedList<Integer> l = new LinkedList<>();
        assertFalse(l.contains(11));
        l.addNodeAtStart(10);
        assertTrue(l.contains(10));
        System.out.println(l);
        assertFalse(l.contains(11));
        l.addNodeAtStart(11);
        assertTrue(l.contains(11));
        System.out.println(l);
    }

    @Test
    void containsEmptyList() {
        LinkedList<Integer> l = new LinkedList<>();
        assertFalse(l.contains(10));
        assertFalse(l.contains(11));
        System.out.println(l);
    }

    @Test
    void getNthElement() {
        LinkedList<Integer> l = new LinkedList<>();
        assertNull(l.getNthValue(1));
        assertNull(l.getNthValue(-5));
        assertNull(l.getNthValue(10));
        System.out.println(l);
        l.addNodeAtStart(10);
        assertEquals(10, l.getNthValue(1));
        assertNull(l.getNthValue(2));
        l.addNodeAtStart(20);
        System.out.println(l);
        assertEquals(20, l.getNthValue(1));
        assertEquals(10, l.getNthValue(2));


    }

    @Test
    void getNthElementFromEnd() {
        LinkedList<Integer> l = new LinkedList<>();
        assertNull(l.getNthValueFromTheEnd(1));
        assertNull(l.getNthValueFromTheEnd(-5));
        assertNull(l.getNthValueFromTheEnd(10));
        System.out.println(l);
        l.addNodeAtStart(10);
        assertEquals(10, l.getNthValueFromTheEnd(1));
        assertNull(l.getNthValueFromTheEnd(2));
        System.out.println(l);
        l.addNodeAtStart(20);
        assertEquals(20, l.getNthValueFromTheEnd(2));
        assertEquals(10, l.getNthValueFromTheEnd(1));
        System.out.println(l);
        l.addNodeAtEnd(30);
        l.addNodeAtEnd(40);
        l.addNodeAsNthElement(5, 1);
        System.out.println(l);
        assertEquals(5, l.getNthValueFromTheEnd(5));
        assertEquals(20, l.getNthValueFromTheEnd(4));
        assertEquals(10, l.getNthValueFromTheEnd(3));
        assertEquals(30, l.getNthValueFromTheEnd(2));
        assertEquals(40, l.getNthValueFromTheEnd(1));
        assertNull(l.getNthValueFromTheEnd(10));


    }

    @Test
    void getNthElementFromEndTwoPointers() {
        LinkedList<Integer> l = new LinkedList<>();
        assertNull(l.getNthValueFromTheEndTwoPointers(1));
        assertNull(l.getNthValueFromTheEndTwoPointers(-5));
        assertNull(l.getNthValueFromTheEndTwoPointers(10));
        System.out.println(l);
        l.addNodeAtStart(10);
        assertEquals(10, l.getNthValueFromTheEndTwoPointers(1));
        assertNull(l.getNthValueFromTheEndTwoPointers(2));
        System.out.println(l);
        l.addNodeAtStart(20);
        assertEquals(20, l.getNthValueFromTheEndTwoPointers(2));
        assertEquals(10, l.getNthValueFromTheEndTwoPointers(1));
        System.out.println(l);
        l.addNodeAtEnd(30);
        l.addNodeAtEnd(40);
        l.addNodeAsNthElement(5, 1);
        System.out.println(l);
        assertEquals(5, l.getNthValueFromTheEndTwoPointers(5));
        assertEquals(20, l.getNthValueFromTheEndTwoPointers(4));
        assertEquals(10, l.getNthValueFromTheEndTwoPointers(3));
        assertEquals(30, l.getNthValueFromTheEndTwoPointers(2));
        assertEquals(40, l.getNthValueFromTheEndTwoPointers(1));
        assertNull(l.getNthValueFromTheEndTwoPointers(10));


    }

    @Test
    void addNodeAtEnd() {
        LinkedList<Integer> l = new LinkedList<>();
        l.addNodeAtEnd(10);
        assertTrue(l.contains(10));
        assertEquals(10, l.getNthValue(1));
        System.out.println(l);
        l.addNodeAtEnd(20);
        assertEquals(20, l.getNthValue(2));
        assertEquals(10, l.getNthValue(1));
        System.out.println(l);
        l.addNodeAtEnd(30);
        assertEquals(30, l.getNthValue(3));
        assertEquals(20, l.getNthValue(2));
        assertEquals(10, l.getNthValue(1));
        System.out.println(l);
    }

    @Test
    void addNodeAfter() {
        LinkedList<Integer> l = new LinkedList<>();
        // add to empty list
        assertFalse(l.addNodeAfter(40, 5));

        // some nodes
        l.addNodeAtEnd(10);
        l.addNodeAtEnd(20);
        l.addNodeAtEnd(30);
        System.out.println(l);

        // add a node in between
        assertTrue(l.addNodeAfter(25, 20));

        assertEquals(10, l.getNthValue(1));
        assertEquals(20, l.getNthValue(2));
        assertEquals(25, l.getNthValue(3));
        assertEquals(30, l.getNthValue(4));
        System.out.println(l);
        // add node at end
        assertTrue(l.addNodeAfter(40, 30));
        assertEquals(40, l.getNthValue(5));

        // try to add node after non existing element
        assertFalse(l.addNodeAfter(40, 5));


    }

    @Test
    void addNodeBefore() {

        LinkedList<Integer> l = new LinkedList<>();
        // add to empty list
        assertFalse(l.addNodeBefore(40, 5));

        // some nodes
        l.addNodeAtEnd(10);
        l.addNodeAtEnd(20);
        l.addNodeAtEnd(30);
        System.out.println(l);
        // add a node in between
        assertTrue(l.addNodeBefore(19, 20));

        assertEquals(10, l.getNthValue(1));
        assertEquals(19, l.getNthValue(2));
        assertEquals(20, l.getNthValue(3));
        assertEquals(30, l.getNthValue(4));
        System.out.println(l);
        // add node at end
        assertTrue(l.addNodeBefore(40, 10));

        assertEquals(40, l.getNthValue(1));
        assertEquals(10, l.getNthValue(2));
        assertEquals(19, l.getNthValue(3));
        assertEquals(20, l.getNthValue(4));
        assertEquals(30, l.getNthValue(5));
        System.out.println(l);
        // try to add node after non existing element
        assertFalse(l.addNodeBefore(40, 5));
        System.out.println(l);
    }

    @Test
    void addNodeAsNthElement() {
        LinkedList<Integer> l = new LinkedList<>();
        // add to empty list
        assertFalse(l.addNodeAsNthElement(90, -1));
        assertFalse(l.addNodeAsNthElement(500, 0));
        System.out.println(l);
        // add as first element
        assertTrue(l.addNodeAsNthElement(20, 1));
        assertEquals(20, l.getNthValue(1));
        System.out.println(l);
        // add as first element
        assertTrue(l.addNodeAsNthElement(10, 1));
        assertEquals(10, l.getNthValue(1));
        assertEquals(20, l.getNthValue(2));
        System.out.println(l);
        // add element at end
        assertTrue(l.addNodeAsNthElement(30, 3));
        assertEquals(10, l.getNthValue(1));
        assertEquals(20, l.getNthValue(2));
        assertEquals(30, l.getNthValue(3));
        System.out.println(l);
        // add in the middle
        assertTrue(l.addNodeAsNthElement(19, 2));
        assertEquals(10, l.getNthValue(1));
        assertEquals(19, l.getNthValue(2));
        assertEquals(20, l.getNthValue(3));
        assertEquals(30, l.getNthValue(4));
        System.out.println(l);
        // add node at end
        assertTrue(l.addNodeAsNthElement(25, 4));

        assertEquals(10, l.getNthValue(1));
        assertEquals(19, l.getNthValue(2));
        assertEquals(20, l.getNthValue(3));
        assertEquals(25, l.getNthValue(4));
        assertEquals(30, l.getNthValue(5));
        System.out.println(l);
        // try to add node after non existing element
        assertFalse(l.addNodeAsNthElement(40, 7));
        System.out.println(l);

    }

    @Test
    void findMiddle() {
        LinkedList<Integer> l = new LinkedList<>();
        assertNull(l.findMiddle());
        l.addNodeAtEnd(10);
        System.out.println(l);
        assertEquals(10, l.findMiddle());
        l.addNodeAtEnd(20);
        System.out.println(l);
        assertEquals(10, l.findMiddle());
        l.addNodeAtEnd(30);
        assertEquals(20, l.findMiddle());
        System.out.println(l);
        l.addNodeAtEnd(40);
        assertEquals(20, l.findMiddle());
        System.out.println(l);
        l.addNodeAtEnd(50);
        assertEquals(30, l.findMiddle());
        System.out.println(l);
        l.addNodeAtEnd(60);
        assertEquals(30, l.findMiddle());
        System.out.println(l);
    }

    @Test
    void isCircular() {
        LinkedList<Integer> l = new LinkedList<>();
        assertFalse(l.isCircular());
        l.addNodeAtEnd(10);
        l.addNodeAtEnd(20);
        l.addNodeAtEnd(30);
        l.addNodeAtEnd(40);
        l.addNodeAtEnd(50);
        l.addNodeAtEnd(60);
        assertFalse(l.isCircular());
        System.out.println(l);
        l.makeCircular();
        assertTrue(l.isCircular());
        System.out.println(l);
    }

    @Test
    void removeDuplicates() {
        LinkedList<Integer> l = new LinkedList<>();
        l.addNodeAtEnd(10);
        System.out.println(l);
        assertFalse(l.hasDuplicates());
        l.addNodeAtEnd(10);
        l.addNodeAtEnd(20);
        l.addNodeAtEnd(30);
        l.addNodeAtEnd(30);
        l.addNodeAtEnd(40);
        l.addNodeAtEnd(40);
        l.addNodeAtEnd(50);
        l.addNodeAtEnd(50);
        System.out.println(l);
        assertTrue(l.hasDuplicates());
        l.removeDuplicateFromSortedList();
        assertFalse(l.hasDuplicates());
        assertEquals(10, l.getNthValue(1));
        assertEquals(20, l.getNthValue(2));
        assertEquals(30, l.getNthValue(3));
        assertEquals(40, l.getNthValue(4));
        assertEquals(50, l.getNthValue(5));
        System.out.println(l);
    }

    @Test
    public void findIntersectionOfTwoSortedList() {
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.addNodeAtEnd(2);
        l1.addNodeAtEnd(4);
        l1.addNodeAtEnd(6);
        l1.addNodeAtEnd(8);
        l1.addNodeAtEnd(10);
        l1.addNodeAtEnd(12);
        l1.addNodeAtEnd(14);
        LinkedList<Integer> l2 = new LinkedList<>();
        l2.addNodeAtEnd(5);
        l2.addNodeAtEnd(6);
        l2.addNodeAtEnd(7);
        l2.addNodeAtEnd(8);
        l2.addNodeAtEnd(9);
        l2.addNodeAtEnd(10);
        l2.addNodeAtEnd(11);
        System.out.println(l1);
        System.out.println(l2);
        LinkedList<Integer> intersection = LinkedList.findIntersection(l1, l2);
        assertEquals(6, intersection.getNthValue(1));
        assertEquals(8, intersection.getNthValue(2));
        assertEquals(10, intersection.getNthValue(3));
        System.out.println(intersection);
    }

    @Test
    public void reverse() {
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.addNodeAtEnd(2);
        l1.addNodeAtEnd(4);
        l1.addNodeAtEnd(6);
        l1.addNodeAtEnd(8);
        l1.addNodeAtEnd(10);
        l1.addNodeAtEnd(12);
        l1.addNodeAtEnd(14);
        System.out.println("l1 = " + l1);
        l1.reverse();
        System.out.println("l1 = " + l1);
        assertEquals(14, l1.getNthValue(1));
        assertEquals(12, l1.getNthValue(2));
        assertEquals(10, l1.getNthValue(3));
        assertEquals(8, l1.getNthValue(4));
        assertEquals(6, l1.getNthValue(5));
        assertEquals(4, l1.getNthValue(6));
        assertEquals(2, l1.getNthValue(7));
    }

}