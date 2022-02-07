package com.huwei.dailytest.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListTest {
    public static void main(String[] args) {
        List l = new ArrayList() {
            {
                add("a");
                add("b");
            }
        };

        Iterator iterator = l.iterator();
        ListIterator listIterator = l.listIterator();
    }

}
