package com.cochabamba.interview.amazon;

import java.util.Arrays;

/**
 * @author ariel.alcocer
 */
public class AmazonChallengeTraining04112020_03 {

    public static void main(String[] args) {
        int[][] lockerMap2 = getLockerDistanceGrid(5, 7, new int[]{2, 4}, new int[]{3, 7});
        for(int i=0;i<lockerMap2.length;i++) {
            System.out.println(Arrays.toString(lockerMap2[i]));
        }
    }

    static  int[][] getLockerDistanceGrid(int cityLength, int cityWidth, int[] lockerXCoordinates, int[] lockerYCoordinates) {
        int[][] lockerMap = new int[cityWidth][cityLength];
        for (int i=0;i<lockerXCoordinates.length;i++)   {
            System.out.println(i);
            System.out.println("X:"+(lockerXCoordinates[i]-1));
            System.out.println("Y:"+(lockerYCoordinates[i]-1));
            lockerMap[lockerYCoordinates[i]-1][lockerXCoordinates[i]-1] = -1;
        }
        return lockerMap;
    }

}
