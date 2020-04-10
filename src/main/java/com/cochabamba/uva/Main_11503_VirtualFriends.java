import java.util.*;


//http://minasamsolution.blogspot.com/2013/08/uva-11503-virtual-friends.html
//https://github.com/emcas88/UVa/blob/master/UVa%2011503%20-%20Virtual%20Friends.java
//http://davidudelson.com/blog/2015/07/25/uva-11503-virtual-friends/
//https://uva.onlinejudge.org/board/viewtopic.php?t=42382

public class Main_11503_VirtualFriends {
//        static int[] parent;
//        static int[] size;
//
//        public static int findSet(int i) {
//            if (parent[i] == i)
//                return i;
//            return findSet(parent[i]);
//        }
//
//        public static boolean isSameSet(int i, int j) {
//            return findSet(i) == findSet(j);
//        }
//
//        public static void union(int i, int j) {
//            if(!isSameSet(i, j)){
//                size[findSet(j)] += size[findSet(i)];
//                parent[findSet(i)] = findSet(j);
//            }
//        }
//
//        public static void main(String[] args) {
//            Scanner in = new Scanner(System.in);
//            int t = Integer.parseInt(in.nextLine());
//            parent = new int[100000];
//            size = new int[100000];
//            for (int i = 0; i < t; i++) {
//                int n = Integer.parseInt(in.nextLine());
//                for (int j = 0; j <= n; j++) {
//                    parent[j] = j;
//                    size[j] = 1;
//                }
//                int cur = 0;
//                Hashtable<String, Integer> table = new Hashtable<String, Integer>();
//                for (int j = 0; j < n; j++) {
//                    String[] s = in.nextLine().split(" ");
//                    String a = s[0];
//                    String b = s[1];
//                    int x = 0, y = 0;
//                    if (table.containsKey(a))
//                        x = table.get(a);
//                    else {
//                        x = cur;
//                        table.put(a, cur);
//                        cur++;
//                    }
//                    if (table.containsKey(b))
//                        y = table.get(b);
//                    else {
//                        y = cur;
//                        table.put(b, cur);
//                        cur++;
//                    }
//                    union(x, y);
//                    System.out.println(size[findSet(x)]);
//                }
//            }
//        }

    public static class UnionFind {
        private int[] parents;
        private Map<String, Integer> elements;
        private int setsNumber;
        private Map<String, Integer> componentsSize;

        public UnionFind(int size) {
            this.parents = new int[size];
            for(int i = 0; i< parents.length; i++)   {
                parents[i] = i;
            }
            this.elements = new HashMap<>();
            this.setsNumber = 0;
            this.componentsSize = new HashMap<>();
        }

        public int find(int i, int parent)   {
            if(i==parent)
                return i;
            else
                return find(parent, parents[parent]);
        }
        public int find(String element)   {
            return find(elements.get(element), parents[elements.get(element)]);
        }

        public void union(String x, String y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if(xRoot!=yRoot) {
                parents[yRoot] = parents[xRoot];
                setsNumber--;
                int newComponentsSize = componentsSize.get(x)+componentsSize.get(y);
                componentsSize.put(x, newComponentsSize);
                componentsSize.put(y, newComponentsSize);
            }
        }

        public void add(String element) {
            if(!elements.containsKey(element)) {
                elements.put(element, elements.size());
                componentsSize.put(element, 1);
                setsNumber++;
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int k=0;k<n;k++)    {
            int f = scanner.nextInt();
            UnionFind unionFind = new UnionFind(100000);
            String x, y;
            for(int i=0;i<f;i++)    {
                x = scanner.next();
                y = scanner.next();
                unionFind.add(x);
                unionFind.add(y);
                unionFind.union(x,y);
                System.out.println(unionFind.componentsSize.get(x));
            }
        }
    }
}