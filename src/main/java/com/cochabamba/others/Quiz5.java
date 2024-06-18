package com.cochabamba.others;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class Quiz5 {
    public static void main(String[] args) throws IllegalStateException {
        LocalDateTime consolidationWindowStart = LocalDateTime.now().with(TemporalAdjusters.firstDayOfNextMonth())
                .with(LocalTime.MIN);
        LocalDateTime consolidationWindowEnd = LocalDateTime.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth())
                .with(LocalTime.MAX);
        System.out.println("consolidationWindowStart:"+consolidationWindowStart);
        System.out.println("consolidationWindowEnd:"+consolidationWindowEnd);
        String time1 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss"));
        System.out.println("Time:"+time1);
        String time2 = LocalDateTime.now().minusDays(30).format(DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss"));
        System.out.println("Time:"+time2);
        System.out.println("FROM:"+LocalDateTime.now().minusDays(30).atOffset(ZoneOffset.UTC));
        System.out.println("TO:"+LocalDateTime.now().atOffset(ZoneOffset.UTC));
    }
}
