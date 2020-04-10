package com.cochabamba.interview;

//class X {
//    static void staticMethod()	{
//        System.out.println("Class X");
//    }
//}
//
//class Y extends X{
//    static void staticMethod()	{
//        System.out.println("Class Y");
//    }
//}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterviewTest {
    public static void main(String[] args)  {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        customSort(list);
    }

    public static void customSort(List<Integer> arr) {
        // Write your code here
        int[] frequencyArray = new int[arr.size()+1];
        Arrays.fill(frequencyArray,0);
        for(int n:arr)  {
            frequencyArray[n]=frequencyArray[n]+1;
        }
        for(int j=1;j<=frequencyArray.length;j++)   {
            for(int i=0;i<frequencyArray.length;i++)    {
                if(frequencyArray[i]==j)    {
                    for(int k=0;k<j;k++)
                        System.out.println(i);
                }
            }
        }
    }
}
