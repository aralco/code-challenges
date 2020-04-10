package com.cochabamba.hackerrank.warmup;

import java.util.Scanner;

public class TimeConversion {

    static void timeConversion(String input)  {
        String newFomattedDate = null;
        String[] inputs = input.split(":");
        String hh = inputs[0];
        if(input.contains("AM"))    {
            if(hh.equals("12")) {
                hh="00";
            }

        } else if (input.contains("PM"))    {
            switch (hh) {
                case "01" : hh="13";
                    break;
                case "02" : hh="14";
                    break;
                case "03" : hh="15";
                    break;
                case "04" : hh="16";
                    break;
                case "05" : hh="17";
                    break;
                case "06" : hh="18";
                    break;
                case "07" : hh="19";
                    break;
                case "08" : hh="20";
                    break;
                case "09" : hh="21";
                    break;
                case "10" : hh="22";
                    break;
                case "11" : hh="23";
                    break;
            }

        }
        newFomattedDate=hh+":"+inputs[1]+":"+inputs[2].substring(0,2);
        System.out.println(newFomattedDate);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        timeConversion(input);
    }
}
