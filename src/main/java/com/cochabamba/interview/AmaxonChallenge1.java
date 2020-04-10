package com.cochabamba.interview;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ariel.alcocer
 */
public class AmaxonChallenge1 {
    public static List<Integer> cellCompete(int[] states, int days) {
        int[] previousStates = new int[10];
        for(int i=0;i<states.length;i++)
            previousStates[i+1]=states[i];
        int[] newStates = new int[10];
        for(int d=0;d<days;d++) {
            System.out.println("Begin: "+Arrays.toString(newStates));
            if(d>=1) {
                previousStates = newStates;
                newStates = new int[] {0,0,0,0,0,0,0,0,0,0};
            }
            for(int i=1;i<previousStates.length-1;i++)  {
                int left = i-1;
                int right = i+1;
                if(previousStates[left]==previousStates[right])
                    newStates[i]=0;
                else
                    newStates[i]=1;

            }
            System.out.println("After: "+Arrays.toString(newStates));
        }
        List<Integer> result = new ArrayList<>();
        for(int i=1;i<newStates.length-1;i++)    {
            result.add(i-1,newStates[i]);
        }
        return result;
    }

    public static void main(String[] args)  {
        int[] states = new int[] {1,0,0,0,0,1,0,0};
        int days = 1;
        System.out.println(cellCompete(states, days).toString());
        System.out.println("**************");
        int[] states2 = new int[] {1,1,1,0,1,1,1,1};
        int days2 = 2;
        System.out.println(cellCompete(states2, days2).toString());

    }


}
