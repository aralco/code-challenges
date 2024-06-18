package com.cochabamba.interview.deviget.ring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClockToDegreeConverter {

    //input 8:22 hours:8, minutes:22
    //1 hour: 360 degrees
    //1 minute: 6 degrees
    public double getAngle(int hours, int minutes)  {
        int minutesDegree = 6*minutes;
        int tmp = minutesDegree/2;
        int hoursDegree = 30*hours+tmp;
        return hoursDegree - minutesDegree;
    }

    @Test
    public void test()  {
        double angle = getAngle(3,0);
        assertEquals(90.0, angle);
        double angle2 = getAngle(12,15);
        assertEquals(90.0, angle2);
    }
}
