package com.cochabamba.interview.amazon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ariel.alcocer
 */
public class AmazonChallengeTraining04112020_01 {

    public static void main(String[] args) {
        AmazonChallengeTraining04112020_01 training04112020_01 = new AmazonChallengeTraining04112020_01();
        System.out.println("Final Output");
        System.out.println(training04112020_01.cellCompete(new int[]{1, 0, 0, 0, 0, 1, 0, 0}, 1));
        System.out.println("Final Output");
        System.out.println(training04112020_01.cellCompete(new int[]{1, 1, 1, 0, 1, 1, 1, 1}, 2));
    }

    public List<Integer> cellCompete(int[] states, int days) {
        int[] tmpState = new int[states.length];
        for(int d=0;d<days;d++) {
            for(int i=0;i<states.length;i++)    {
                if(i==0)    {
                    tmpState[i] = (0==states[i+1])?0:1;
                }
                else if(i==states.length-1)   {
                    tmpState[i] = (states[i-1]==0)?0:1;
                }
                else {
                    tmpState[i] = (states[i-1]==states[i+1])?0:1;
                }

            }
            states = Arrays.copyOf(tmpState, tmpState.length);
            Arrays.fill(tmpState,0);
        }
        return Arrays.stream(states)
                .boxed()
                .collect(Collectors.toList());

    }
}
