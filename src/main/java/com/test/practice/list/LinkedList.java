package com.test.practice.list;

import lombok.Getter;

import java.util.Objects;

@Getter
public class LinkedList<T> {
    private Node<T> head = null;

    boolean contains(T data) {
        boolean exists = false;
        Node<T> n = head;
        while (n != null) {
            exists = Objects.equals(n.data, data);
            if (exists) break;
            n = n.next;
        }
        return exists;
    }

    T getNthValue(int n) {
        if (n > 0) {
            Node<T> node = head;
            int count = 0;
            while (node != null) {
                if (n == ++count) break;
                node = node.next;
            }
            return n == count ? node.data : null;
        }

        return null;
    }

    T getNthValueFromTheEnd(int n) {
        T data = null;
        if (n > 0 && head != null) {
            Node<T> node = head;
            int nodeCount = 0;
            while (node != null) {
                ++nodeCount;
                node = node.next;
            }
            int count = nodeCount + 1 - n;
            if (count > 0) {
                Node<T> tnode = head;
                while (--count > 0) {
                    tnode = tnode.next;
                }
                return tnode.data;
            }
        }

        return data;
    }

    T getNthValueFromTheEndTwoPointers(int n) {
        T data = null;
        if (n > 0 && head != null) {
            Node<T> node = head;
            Node<T> lateNode = head;
            int nodeCount = 0;
            while ( ++nodeCount <n && node.next!=null) {
                node = node.next;
            }
            while (node.next != null) {
                node = node.next;
                lateNode = lateNode.next;
            }
            return nodeCount==n ? lateNode.data : data;
        }
        return data;
    }

    void addNodeAtStart(T data) {
        if (head == null) {
            head = new Node<>(data, null);
        } else {
            // insert at head
            head = new Node<>(data, head);
        }

    }

    void addNodeAtEnd(T data) {
        if (head == null) {
            head = new Node<>(data, null);
        } else {
            // traverse to end node
            Node<T> end = head;
            while (end.next != null) {
                end = end.next;
            }
            // insert at end
            end.next = new Node<>(data, null);
        }

    }

    boolean addNodeAfter(T data, T targetNodeData) {
        boolean matched = false;
        if (head != null) {
            // traverse to node node
            Node<T> node = head;
            while (node != null) {
                matched = Objects.equals(node.data, targetNodeData);
                if (matched) {
                    break;
                }
                node = node.next;
            }
            // insert after node
            if (matched) {
                node.next = new Node<>(data, node.next);
            }
        }
        return matched;
    }

    boolean addNodeBefore(T data, T targetNodeData) {
        boolean matched = false;
        if (head != null) {
            // traverse to node node
            Node<T> node = head;
            Node<T> prev = null;
            while (node != null) {
                if (matched = Objects.equals(node.data, targetNodeData)) {
                    break;
                }
                prev = node;
                node = node.next;
            }
            // insert before node
            if (matched) {
                Node<T> tNode = new Node<>(data, node);
                if (prev == null) {
                    head = tNode;
                } else {
                    prev.next = tNode;
                }
            }
        }
        return matched;
    }

    boolean addNodeAsNthElement(T data, int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            head = new Node<>(data, head);
            return true;
        } else if (head != null) {

            // traverse to n-1 th node node
            int nodeCount = 1;
            Node<T> node = head;
            while (node != null) {
                if (n == ++nodeCount) break;
                node = node.next;
            }
            // insert after n-1 node
            if (node != null) {
                node.next = new Node<>(data, node.next);
                return true;
            }
        }
        return false;
    }

    public T findMiddle(){
        if(head == null){
            return null;
        } else {
            Node<T> oneStep=head;
            Node<T> twoStep=head;
            while (twoStep!=null){
                twoStep = twoStep.next;
                if(twoStep!=null && twoStep.next!=null){
                    twoStep = twoStep.next;
                    oneStep = oneStep.next;
                }
            }
            return (oneStep!=null) ? oneStep.data : null;
        }

    }

    public boolean isCircular(){
        if(head== null ){
            return false;
        }else{
            Node<T> node = head;
            Node<T> fastNode = head;
            while(fastNode !=null && fastNode.next!=null){
                fastNode  = fastNode.next.next;
                node = node.next;
                if(node == fastNode){
                    return true;
                }
            }
          return false;
        }
    }

    public void makeCircular(){
        if(head!=null){
            Node<T> node = head;
            while (node.next != null){
                node=node.next;
            }
            node.next =head;
        }
    }

    public void removeDuplicateFromSortedList(){
        if(head!=null){
            Node<T> n  = head;
            while(n !=null ){
                while(n.next !=null && n.data == n.next.data){
                    //remove duplicate
                    Node<T> tNode = n.next;
                    n.next = n.next.next;
                    //reset the remove node
                    tNode.next=null;
                    tNode=null;
                }
                n=n.next;
            }
        }
    }

    public boolean hasDuplicates(){
        if(head!=null){
            Node<T> n  = head;
            while(n !=null ){
                if(n.next !=null && n.data == n.next.data){
                   return true;
                }
                n=n.next;
            }
        }
        return false;
    }

    public static LinkedList<Integer> findIntersection(LinkedList<Integer> l1, LinkedList<Integer> l2) {

        Node<Integer> n1 = l1.getHead();
        Node<Integer> n2 = l2.getHead();
        LinkedList<Integer> l3 = new LinkedList<>();
        while(n1 != null && n2 != null ){
            while(n1 !=null && n1.data < n2.data ){
                n1 = n1.next;
            }
            while(n2 !=null && n1 !=null && n1.data > n2.data ){
                n2 = n2.next;
            }
            while(n1 !=null && n2 !=null && n1.data.equals(n2.data)){
                l3.addNodeAtEnd(n1.data);
                n1 =n1.next;
                n2= n2.next;

            }


        }
        return l3;
    }

    public void reverse(){
        if(head != null){
            Node<T> prev = null , curr=head , next = curr.next; ;
            while(curr.next != null ){
                curr.next = prev;
                prev=curr;
                curr = next;
                next = next.next;
            }
            head = curr;
            curr.next=prev;
        }
    }

    public String printList(){
        StringBuilder stringBuilder = new StringBuilder();
        if(head == null ){
            return "Empty List";
        }else{
            Node<T> curr = head ;
            while( curr !=null ){
                stringBuilder.append(curr).append(" -> ");
                curr = curr.next;
            }
            stringBuilder.append("null");
            return stringBuilder.toString();
        }
    }

    @Override
    public String toString() {
        return "List: " + printList();
    }
}


