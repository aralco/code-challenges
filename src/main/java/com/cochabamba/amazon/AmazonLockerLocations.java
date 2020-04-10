package com.cochabamba.amazon;

import java.util.*;

/**
 * @author aralco
 */
public class AmazonLockerLocations {

    public static void main(String[] args)  {
        int[] x = {1};
        int[] y = {1};
        System.out.println(Arrays.deepToString(getLockerDistanceGrid(3, 5, x, y)));
    }
    static int[][] getLockerDistanceGrid(int cityLength, int cityWidth, int[] lockerXCoordinates, int[] lockerYCoordinates) {
        Set<String> set = new HashSet<>();
        String name1 = "Ariel";
        String name2 = "pp";
        String[] names = {name1,name2};
        Collections.addAll(set, names);

        //rate courses
        List<String> myFriends = new ArrayList<>();//getDirectFriendsForUser(user);
        List<String> myCourses = new ArrayList<>();//getAttendedCoursesForUser(user);
        Map<String, Integer> ranking = new HashMap<>();
        for(String friend : myFriends)  {
//            for(String friendCourse: getAttendedCoursesForUser(friend)) {
            for(String friendCourse: myFriends) {
                if(ranking.containsKey(friendCourse))   {
                    ranking.replace(friendCourse, ranking.get(friendCourse).intValue()+1);
                } else  {
                    ranking.put(friendCourse, 1);
                }
            }
        }
        //remove my courses
        for(String course: myCourses)   {
            if(ranking.containsKey(course)) {
                ranking.remove(course);
            }
        }

        List<String> results = new ArrayList<>();
        //order results


        System.out.println(set.toString());
        int[][] grid = new int[cityLength][cityWidth];
        for(int i=0;i<lockerXCoordinates.length;i++)   {
         for(int j=0;j<lockerYCoordinates.length;j++)  {
             grid[i][j]=0;
         }
        }
        return grid;
    }

//    public List<String> getRankedCourses(String user) {
//
//    }
}
