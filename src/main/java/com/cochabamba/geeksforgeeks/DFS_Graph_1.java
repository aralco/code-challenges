package com.cochabamba.geeksforgeeks;

import java.util.*;

//https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
//https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
public class DFS_Graph_1 {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for(int t=1;t<=testCases;t++)    {
            int vertex = scanner.nextInt();
            int edges = scanner.nextInt();
            ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
            for (int i=0;i<vertex;i++)  {
                arrayLists.add(i, new ArrayList<>());
            }

            for(int e=1;e<=edges;e++)    {
                int origin = scanner.nextInt();
                int destination = scanner.nextInt();
                arrayLists.get(origin).add(destination);
                arrayLists.get(destination).add(origin);
             }
            boolean[] visited = new boolean[vertex];
            Arrays.fill(visited,false);
            Traversal.dfs(0, arrayLists, visited);
        }
    }
}

class Traversal {
    /*
    *ArrayList<ArrayList<Integer>> list: which represents graph
    * src: represents source vertex
    *vis[]: boolean array
    */

    static void dfsIterative(int src, ArrayList<ArrayList<Integer>> list, boolean vis[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        while (!stack.empty())  {
            int vertex = stack.pop();
            if(!vis[vertex]) {
                System.out.print(vertex+" ");
                vis[vertex] = true;
            }
            ArrayList<Integer> neighbors = list.get(vertex);
            for(int i=0;i<neighbors.size();i++) {
                if(!vis[neighbors.get(i)])    {
                    stack.push(neighbors.get(i));
                }
            }
        }
    }
/*
1
5 4
0 1 0 2 0 3 2 4
0 1 2 4 3
*/
    /*
    *ArrayList<ArrayList<Integer>> list: which represents graph
    * src: represents source vertex
    *vis[]: boolean array
    */
    static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[]) {
        System.out.print(src+" ");
        vis[src] = true;
        ArrayList<Integer> neighbors = list.get(src);
        for(int i=0;i<neighbors.size();i++) {
            if(!vis[neighbors.get(i)])    {
                dfs(neighbors.get(i), list, vis);
            }
        }
    }
/*
1
5 4
0 1 0 2 0 3 2 4
0 3 2 4 1
*/


}
/*
Given N nodes and E edges of a graph. The task is to do depth first traversal of the graph.

Note: Use recursive approach.

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow. Each test case consists of two lines. Description of testcases is as follows: The First line of each test case contains two integers 'N' and 'E'  which denotes the no of vertices and no of edges respectively. The Second line of each test case contains 'E'  space separated pairs u and v denoting that there is a edge from u to v .

Output:
For each testcase, print the nodes while doing DFS starting from node 0.

Your task:
The task is to complete the function dfs() which should do the depth first traversal of given graph and prints the node in DFS order.

Constraints:
1 <= T <= 100
1 <= N , E <= 200

Example:
Input:
2
5 4
0 1 0 2 0 3 2 4
4 3
0 1 1 2 0 3

Output:
0 1 2 4 3
0 1 2 3

Explanation:
Testcase 1:
0 is connected to 1 , 2 , 3
1 is connected to 0
2 is connected to 0 and 4
3 is connected to 0
4 is connected to 2
so starting from 0 , dfs will be 0 1 2 4 3.

Test Cases where fails Iterative but recursive passes:
Input:
19 8
7 5 8 11 18 14 3 17 9 3 18 16 18 7 7 0

Its Correct output is:
0 7 5 18 14 16

And Your Code's output is:
0 7 18 16 14 5
*/