package com.coforge.day5;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {

    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();

        set.add(10);      // Autoboxing
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);
        set.add(20);

        System.out.println(set);

        set.remove(20);

        System.out.println(set);

        for (Integer i : set) {
            System.out.println(i);
        }

        Iterator<Integer> it = set.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}