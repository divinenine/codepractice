package com.headfirst.designpatterns.chapter7;

import java.util.*;

public class EnumIterTest {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add("test1");
        set.add("test2");
        set.add("test3");
        set.add("test4");

        Enumeration<String> enumerator = new Vector<>(set).elements();
        Iterator<String> aIterator = set.iterator();

        EnumerationIterator enumerationIterator = new EnumerationIterator(enumerator);
        takeArrayList(aIterator);

        takeArrayList(enumerationIterator);

    }

    public static void takeArrayList (Iterator<String> list) {

        int i = 0;
        while (list.hasNext()) {
            System.out.println(i);
            i++;
            list.next();
        }



    }
}
