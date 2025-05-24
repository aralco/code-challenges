import java.util.Arrays;

import static java.util.Arrays.sort;

//input:  [4,3,1,6,4,3,6,4]
//output: [4,4,4,3,3,6,6,1]
public class SortArrayByFrequency {
    public static void main(String[] args) {
        int[] input = new int[]{4, 3, 1, 6, 4, 3, 6, 4};
        int[] output = new int[input.length];
        int[] sortedInput = sortArray(input);
        System.out.println(Arrays.toString(sortedInput));
        int[] frequencies = new int[sortedInput.length+1];
        for(int i = 0; i < sortedInput.length; i++) {
            frequencies[sortedInput[i]] = frequencies[sortedInput[i]]+1;
        }
        System.out.println(Arrays.toString(frequencies));

        int j=0;
        for(int i=frequencies.length-1;i>0;i--) {
            if(frequencies[i] > 0) {
                for(int k=0;k<frequencies[i];k++) {
                    output[j] = i;
                    j++;
                }
            }
        }
        System.out.println(Arrays.toString(output));
    }

    public static int[] sortArray(int[] input) {
        sort(input);
        return input;
    }
}


