package com.cochabamba.interview.beamtrail;

import java.util.Arrays;
import java.util.Random;

public class TrickyAlgorithm {
    public static void main(String[] args) {
//        Integer[] array = new Integer[5];
        Integer[] array = {45, 1, 15, 10, 58};
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            //array[i] = new Random().nextInt(100);
            sum +=array[i];
        }
        System.out.println("Array:"+ Arrays.toString(array));
        int averageInt = sum / array.length;
        double averageDouble = sum / array.length;
        double averageDoubleFixed = (double) sum / array.length;
        System.out.println(averageInt+","+averageDouble+","+averageDoubleFixed);
    }
}
