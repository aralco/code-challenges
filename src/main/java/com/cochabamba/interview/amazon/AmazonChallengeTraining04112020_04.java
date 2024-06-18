package com.cochabamba.interview.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ariel.alcocer
 */
public class AmazonChallengeTraining04112020_04 {

    public static void main(String[] args) {

    }

    public List<String> getDirectFriendsForUser(String user)    {
        List<String> directFriends = new ArrayList<>();
        switch (user)   {
            case "Joe":
                directFriends.addAll(Arrays.asList("Sue", "Amy"));
                break;
            case "Sue":
                directFriends.addAll(Arrays.asList("Joe", "Amy","Peter"));
                break;
            case "Amy":
                directFriends.addAll(Arrays.asList("Joe", "Sue","Chris", "Anne"));
                break;
            case "John":
                directFriends.addAll(Arrays.asList("Peter", "Anne"));
                break;
            case "Anne":
                directFriends.addAll(Arrays.asList("John", "Amy", "Peter"));
                break;
            case "Peter":
                directFriends.addAll(Arrays.asList("John", "Anne", "Sue"));
                break;
        }
        return directFriends;
    }

    public List<String> getAttendedCoursesForUser(String user)    {
        List<String> atendderCourses = new ArrayList<>();
        switch (user)   {
            case "Joe":
                atendderCourses.addAll(Arrays.asList("c1", "c2"));
                break;
            case "Sue":
                atendderCourses.addAll(Arrays.asList("c3", "c4","c5"));
                break;
            case "Amy":
                atendderCourses.addAll(Arrays.asList("c2", "c5","c6", "c8"));
                break;
            case "John":
                atendderCourses.addAll(Arrays.asList("c6", "c7"));
                break;
            case "Anne":
                atendderCourses.addAll(Arrays.asList("c1", "c2", "c3"));
                break;
            case "Peter":
                atendderCourses.addAll(Arrays.asList("c2", "c6", "c7"));
                break;
        }
        return atendderCourses;

    }

    public List<String> getRankedCourses(String user)    {
        List<String> rankedCourses = new ArrayList<>();
        return rankedCourses;
    }

}
