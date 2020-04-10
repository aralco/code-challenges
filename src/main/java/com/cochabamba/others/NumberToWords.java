package com.cochabamba.others;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ariel
 */
public class NumberToWords {

    public static Map<Integer,String> getMapBase()    {
        Map<Integer,String> map = new HashMap();
        map.put(0,"zero");
        map.put(1,"one");
        map.put(2,"two");
        map.put(3,"three");
        map.put(4,"four");
        map.put(5,"five");
        map.put(6,"six");
        map.put(7,"seven");
        map.put(8,"eight");
        map.put(9,"nine");
        map.put(10,"ten");
        map.put(11,"eleven");
        map.put(12,"twelve");
        map.put(13,"thirteen");
        map.put(14,"fourteen");
        map.put(15,"fifteen");
        map.put(16,"sixteen");
        map.put(17,"seventeen");
        map.put(18,"eighteen");
        map.put(19,"nineteen");
        return map;
    }

    public static Map<Integer,String> getMapBaseOverDigits()    {
        Map<Integer,String> map = new HashMap();
        map.put(0,"zero");
        map.put(1,"thousand");
        map.put(2,"million");
        map.put(3,"billion");
        map.put(4,"trillion");
        return map;
    }

    public static Map<Integer,String> getMapBaseTwoDigits()    {
        Map<Integer,String> map = new HashMap();
        map.put(0,"zero");
        map.put(1,"ten");
        map.put(2,"twenty");
        map.put(3,"thirty");
        map.put(4,"fourty");
        map.put(5,"fifty");
        map.put(6,"sixty");
        map.put(7,"seventy");
        map.put(8,"eighty");
        map.put(9,"ninety");
        return map;
    }
    public static String convertNumberToString(int number)    {
        String word="";
        Map<Integer,String> mapBase =getMapBase();
        Map<Integer,String> mapBase2Dig =getMapBaseTwoDigits();
        Map<Integer,String> mapBaseOverDig =getMapBaseOverDigits();
        if(number==0)   {
            word = mapBase.get(number);
        }
        return word;
    }

    public static void main(String arg[])   {
        System.out.println(convertNumberToString(1));
    }

}
