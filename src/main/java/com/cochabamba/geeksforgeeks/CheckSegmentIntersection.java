package com.cochabamba.geeksforgeeks;

import java.util.Scanner;

public class CheckSegmentIntersection {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for(int t=1;t<=testCases;t++)  {
            Point p1 = new Point(scanner.nextInt(), scanner.nextInt());
            Point p2 = new Point(scanner.nextInt(), scanner.nextInt());
            Point p3 = new Point(scanner.nextInt(), scanner.nextInt());
            Point p4 = new Point(scanner.nextInt(), scanner.nextInt());
            System.out.println(segmentsIntersect(p1, p2,  p3, p4)?1:0);
        }

        Point p1 = new Point(1, 1);
        Point p2 = new Point(10, 1);
        Point p3 = new Point(1, 2);
        Point p4 = new Point(10, 2);
        System.out.println(segmentsIntersect(p1, p2, p3, p4));

        p1 = new Point(10, 0);
        p2 = new Point(0, 10);
        p3 = new Point(0, 0);
        p4 = new Point(10, 10);
        System.out.println(segmentsIntersect(p1, p2, p3, p4));

        p1 = new Point(-5, -5);
        p2 = new Point(0, 0);
        p3 = new Point(1, 1);
        p4 = new Point(10, 10);
        System.out.println(segmentsIntersect(p1, p2, p3, p4));
    }

    static boolean segmentsIntersect(Point p1, Point p2, Point p3, Point p4)  {
        boolean segmentsIntersect = false;
        int direction1 = direction(p3, p4, p1);
        int direction2 = direction(p3, p4, p2);
        int direction3 = direction(p1, p2, p3);
        int direction4 = direction(p1, p2, p4);

        if((direction1>0 && direction2<0 || direction1<0 && direction2>0)&&
            (direction3>0 && direction4<0 || direction3<0 && direction4>0)){
            segmentsIntersect = true;
        }
        else if(direction1==0 && onSegment(p3, p4, p1))  {
            segmentsIntersect = true;
        }
        else if(direction2==0 && onSegment(p3, p4, p2))  {
            segmentsIntersect = true;
        }
        else if(direction3==0 && onSegment(p1, p2, p3))  {
            segmentsIntersect = true;
        }
        else if(direction4==0 && onSegment(p1, p2, p4))  {
            segmentsIntersect = true;
        }
        return segmentsIntersect;
    }

    static int direction(Point pi, Point pj, Point pk)  {
        return crossProduct(pk.diff(pi), pj.diff(pi));
    }

    static int crossProduct(Point p1, Point p2) {
        return p1.x*p2.y - p2.x*p1.y;
    }

    static boolean onSegment(Point pi, Point pj, Point pk)  {
        boolean onSegment = false;
        if((pk.x>=Math.min(pi.x, pj.x) && pk.x<=Math.max(pi.x, pj.x)) &&
                (pk.y>=Math.min(pi.y, pj.y) && pk.y<=Math.max(pi.y, pj.y)))  {
            onSegment = true;
        }
        return onSegment;
    }

    static class Point  {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point diff(Point p)  {
            return new Point(p.x-this.x, p.y-this.y);
        }

    }
}
