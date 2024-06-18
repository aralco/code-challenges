package com.cochabamba.others;

public class Quiz4 {
    public static void main(String[] args) throws IllegalStateException {
        int day = 2;
        String dayType;
        switch (day) {
            case 1, 2, 3, 4, 5 -> dayType = "Weekday";
            case 6, 7 -> dayType = "Weekend";
            default -> throw new IllegalStateException("Invalid day: " + day);
        }
        System.out.println(dayType);
    }
}
