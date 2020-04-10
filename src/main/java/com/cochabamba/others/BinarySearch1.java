package com.cochabamba.others;

import java.util.Arrays;

/**
 * @author aralco
 */
public class BinarySearch1 {

    public static int binarySearch(int[] array, int target, int begin, int end) {
        int half = (begin+end)/2;
        if(target==array[half])
            return half;
        else if(target>array[half])
            return binarySearch(array, target, half+1, end);
        else
            return binarySearch(array, target, begin, half-1);
    }
    public static void main(String[] args)  {
        int[] array = {1, 3, 7, 12, 18, 21, 29, 30};
        System.out.println(Arrays.toString(array));
        System.out.println("Target 18 is at position:"+binarySearch(array, 18, 0, array.length));
        System.out.println("Target 12 is at position:"+binarySearch(array, 12, 0, array.length));
        System.out.println("Target 30 is at position:"+binarySearch(array, 30, 0, array.length));
        System.out.println("Target 1 is at position:"+binarySearch(array, 1, 0, array.length));
        System.out.println("Target 21 is at position:"+binarySearch(array, 21, 0, array.length));
    }
}
