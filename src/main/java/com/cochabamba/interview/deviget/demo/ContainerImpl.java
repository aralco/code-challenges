package com.cochabamba.interview.deviget.demo;

import java.util.*;

/**
 * A container of integers that should support
 * elements addition, removal, and search of the median element
 */
public class ContainerImpl implements Container {

    private List<Integer> list;
    public ContainerImpl() {
        list = new ArrayList<>();
    }

    @Override
    public void add(int value) {
        list.add(value);
        Collections.sort(list);
    }

    @Override
    public boolean delete(int value) {
        return list.remove(Integer.valueOf(value));
    }

    @Override
    public int getMedian() {
        if(list.isEmpty())    {
            throw new RuntimeException("Container is empty");
        }
        if(list.size()%2 == 0)    {
            return list.get(list.size()/2-1);
        }
        return list.get(list.size()/2);
    }
}

