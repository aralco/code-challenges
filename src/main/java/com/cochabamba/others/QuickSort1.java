package com.cochabamba.others;

import java.util.Arrays;

/**
 * Created by aralco on 9/20/15.
 */
public class QuickSort1 {

    public static int partition(int array[], int start, int end)   {
        int pivot = array[end];
        int partitionIndex=start;
        for(int i=start;i<end;i++)   {
            if(array[i]<=pivot) {
                int temp = array[i];
                array[i] = array[partitionIndex];
                array[partitionIndex] = temp;
                partitionIndex++;
            }
        }
        int temp = array[end];
        array[end] = array[partitionIndex];
        array[partitionIndex] = temp;
        return partitionIndex;
    }

    public static void quickSort(int array[], int start, int end)  {
        if(start<end)   {
            int partitionIndex = partition(array, start, end);
            quickSort(array, start, partitionIndex-1);
            quickSort(array, partitionIndex+1,end);
        }
//        System.out.println(Arrays.toString(array));
    }

    public static void quickSort2(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        // pick the pivot
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort2(arr, low, j);

        if (high > i)
            quickSort2(arr, i, high);
    }

    public static void main(String[] args) {
        int [] array = {3, 4, 1, 8, 5};
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

        int [] array2 = {3, 4, 1, 8, 5};
        System.out.println(Arrays.toString(array2));
//        quickSort2(array2, 0, array2.length - 1);
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2));

    }

}
