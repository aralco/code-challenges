package com.cochabamba.others;

import java.util.Arrays;

public class MergeArrays {

    static int[] mergeArrays(int[] a, int[] b)  {
        int [] mergedArray = new int[a.length+b.length];
        for(int i=0;i<a.length;i++)   {
            mergedArray[i]=a[i];
        }
        int startPosition = a.length;
        for(int i=0;i<b.length;i++)   {
            mergedArray[startPosition+i]=b[i];
        }
        System.out.println(Arrays.toString(mergedArray));
        Arrays.sort(mergedArray);
        return mergedArray;
    }

    public static void main(String[] args) {
        int [] a = {1,5,7,7};
        int [] b = {0,1,2,3};
        int [] result = mergeArrays(a,b);
        System.out.println(Arrays.toString(result));
    }
}
