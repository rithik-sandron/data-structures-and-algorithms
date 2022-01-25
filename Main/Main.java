package Main;

import DataStructures.Array;
import DataStructures.Heap;
import DataStructures.Queue;
import DataStructures.Structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Heap<Integer> h = new Heap<>();
        h.add(10);
        h.add(4);
        h.add(35);
        h.add(13);
        h.toImmutableStructure();
        h.add(30);
        System.out.println(h.toString());

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
