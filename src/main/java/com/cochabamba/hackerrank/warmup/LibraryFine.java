package com.cochabamba.hackerrank.warmup;

import java.util.Scanner;

public class LibraryFine {

    static void libraryFine(String input1, String input2)  {
        int libraryFine = 0;
        if(!input1.equals(input2))   {

            String[] actualDates= input1.split(" ");
            //D M Y
            int aDay = Integer.parseInt(actualDates[0]);
            int aMonth = Integer.parseInt(actualDates[1]);
            int aYear = Integer.parseInt(actualDates[2]);

            String[] expectedDates= input2.split(" ");
            //D M Y
            int eDay = Integer.parseInt(expectedDates[0]);
            int eMonth = Integer.parseInt(expectedDates[1]);
            int eYear = Integer.parseInt(expectedDates[2]);

            int DAILY_FINE=15;
            int MONTHLY_FINE=500;
            int YEARLY_FINE=10000;

            if(aYear==eYear && aMonth==eMonth && aDay>eDay) {
                libraryFine = DAILY_FINE*(aDay-eDay);
            } else if(aYear==eYear && aMonth>eMonth)    {
                libraryFine = MONTHLY_FINE*(aMonth-eMonth);
            } else if(aYear>eYear)  {
                libraryFine = YEARLY_FINE;
            }

        }
        System.out.println(libraryFine);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.nextLine();
        String input2= in.nextLine();
        libraryFine(input1, input2);
    }
}