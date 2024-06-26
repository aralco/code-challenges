package com.cochabamba.geeksforgeeks;

/**
 * @author ariel.alcocer
 */
public class DijkstrasAlgorithm {
    public static void main(String[] args) {
        dijskstra(new int[][] {
                //0  1  2  3  4  5  6  7  8
                { 0, 4, 0, 0, 0, 0, 0, 8, 0},  //0
                { 4, 0, 8, 0, 0, 0, 0, 11, 0}, //1
                { 0, 8, 0, 7, 0, 4, 0, 0, 2},  //2
                { 0, 0, 7, 0, 9, 14, 0, 0, 0}, //3
                { 0, 0, 0, 9, 0, 10, 0, 0, 0}, //4
                { 0, 0, 4, 14, 10, 0, 2, 0, 0},//5
                { 0, 0, 0, 0, 0, 2, 0, 1, 6},  //6
                { 8, 11, 0, 0, 0, 0, 1, 0, 7}, //7
                { 0, 0, 2, 0, 0, 0, 6, 7, 0}   //8
        }, 0, 8);
    }

    public static void dijskstra(int[][] graph, int origin, int destination) {


    }
}
