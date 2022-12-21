package main;

import ds.common.Array;
import ds.common.Algorithms;
import ds.common.Heap;
import ds.common.Queue;
import ds.disjointSet.Cost;
import ds.disjointSet.DisjointSet;
import ds.nodeBased.LinkedList;

public class Main {
    public static void main(String[] args) {

        // example for dis joint
        Cost cost1 = new Cost(2, 5, 6);
        Cost cost2 = new Cost(3, 5, 6);
        Cost cost3 = new Cost(1, 3, -6);
        Cost[] costArray = {cost1, cost2, cost3};
        DisjointSet ds = new DisjointSet(7, costArray);
        ds.perform();
        System.out.println(ds);

        // example for min heap
        Heap<Integer> h = new Heap<>();
        h.add(10);
        h.add(4);
        h.add(35);
        h.add(13);
        h.add(63);
        h.add(43);
        h.add(-12);
        h.toImmutableStructure();
        System.out.println(h);

        // example for dynamic array
        Array<Integer> a = new Array<>();
        a.push(10);
        a.push(40);
        a.push(30);
        a.push(50);
        System.out.println(a);
        Algorithms al = new Algorithms();
        al.reverse(a);
        System.out.println(a);
        System.out.println(al.binarySearch(a, 30));
        a.toImmutableStructure();

        // example for linked list
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        System.out.println(ll.get(1));

        // example for queue
        Queue<Integer> q = new Queue<>();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.dequeue();
        q.toImmutableStructure();
        System.out.println(q);

    }
}
