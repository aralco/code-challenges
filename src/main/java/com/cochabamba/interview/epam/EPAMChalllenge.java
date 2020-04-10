package com.cochabamba.interview.epam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ariel.alcocer
 */
//l1(1,2,3) l2(1,2,3) => true
//l1(1,2,3) l2(1,2) => false
//l1(1,2,2,3) l2(2,1,2,3) => true
//l1(1,2,3,4) l2(1,2,3,3) => false

public class EPAMChalllenge {

    public static boolean isSameList(List l1, List l2)  {
        if(l1.size()>l2.size() || l2.size()>l1.size())
            return false;

        Map<Object, Integer> elements = new HashMap<>();
        for(int i=0;i<l1.size();i++)   {
            Object iElement = l1.get(i);
            if(elements.get(iElement)==null) {
                elements.put(iElement, 1);
            } else {
                elements.put(iElement, elements.get(iElement)+1);
            }
        }
        for(int j=0;j<l2.size();j++)   {
            Object iElement = l2.get(j);
            if(elements.get(iElement)==null) {
                return false;
            } else {
                elements.put(iElement, elements.get(iElement)-1);
            }
        }
        boolean theyAreTheSame = true;
        for(Integer frequency : elements.values())   {
            if(frequency!=0) {
                theyAreTheSame = false;
                break;
            }
        }
        return theyAreTheSame;
    }

    public static void main(String[] args)  {
        //l1(1,2,3) l2(1,2,3) => true
        List l1 = Arrays.asList(1, 2, 3);
        List l2 = Arrays.asList(1, 2, 3);
        System.out.println(isSameList(l1, l2));
        //l1(1,2,3) l2(1,2) => false
        List ll1 = Arrays.asList(1, 2, 3);
        List ll2 = Arrays.asList(1, 2);
        System.out.println(isSameList(ll1, ll2));

        //l1(1,2,2,3) l2(2,1,2,3) => true
        List l11 = Arrays.asList(1, 2, 2, 3);
        List l22 = Arrays.asList(2, 1, 2, 3);
        System.out.println(isSameList(l11, l22));

        //l1(1,2,3,4) l2(1,2,3,3) => false
        List ll11 = Arrays.asList(1, 2, 3, 4);
        List ll22 = Arrays.asList(1, 2, 3, 3);
        System.out.println(isSameList(ll11, ll22));

    }

}
