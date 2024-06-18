package com.cochabamba.others;

/**
 * @author ariel.alcocer
 */
public class CodeSignalTest {
    int addTwoDigits(int n) {
        int sum=0;
        int pivot=n;
        while(pivot>=10) {
            sum = sum + (pivot%10);
            pivot=pivot/10;
        }
        return sum+pivot;
    }

}
