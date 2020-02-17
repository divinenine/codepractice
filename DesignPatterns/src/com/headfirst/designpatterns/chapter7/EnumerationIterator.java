package com.headfirst.designpatterns.chapter7;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIterator implements Iterator<String> {

    Enumeration<?> enumeration;

    public EnumerationIterator(Enumeration<?> enumeration) {
        this.enumeration = enumeration;
    }


    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public String next() {
        return (String) enumeration.nextElement();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
