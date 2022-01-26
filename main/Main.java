package main;

import ds.common.Array;
import ds.common.Heap;
import ds.disjointSet.Cost;
import ds.disjointSet.DisjointSet;

public class Main {
    public static void main(String[] args) {
        // example for dis joint
        Cost cost1 = new Cost(2, 5, 6);
        Cost cost2 = new Cost(3, 5, 6);
        Cost cost3 = new Cost(1, 3, 6);
        Cost cost4 = new Cost(4, 6, 5);
        Cost cost5 = new Cost(2, 3, 5);
        Cost cost6 = new Cost(0, 1, 5);
        Cost cost7 = new Cost(5, 6, 4);
        Cost cost8 = new Cost(1, 2, 4);
        Cost cost9 = new Cost(4, 5, 3);
        Cost cost10 = new Cost(0, 2, 3);
        Cost cost11 = new Cost(1, 4, 2);
        Cost[] costArray = {cost1, cost2, cost3, cost4, cost5, cost6, cost7, cost8, cost9, cost10, cost11};
        DisjointSet ds = new DisjointSet(7, costArray);
        ds.perform();
        System.out.println(ds.toString());

        // example for min heap
        Heap<Integer> h = new Heap<>();
        h.add(10);
        h.add(4);
        h.add(35);
        h.add(13);
        h.toImmutableStructure();
        System.out.println(h.toString());

        // example for dynamic array
        Array<Integer> a = new Array<>();
        a.push(10);
        a.push(40);
        a.push(30);
        a.push(50);
        System.out.println(a.toString());
        a.reverse();
        a.toImmutableStructure();
        System.out.println(a.toString());
    }
}
