import java.util.ArrayList;
import java.util.Scanner;

//https://github.com/dalleng/Competitive-Programming/blob/master/Uva/10583%20-%20Ubiquitous%20Religions/Main.java
//http://diptocsedu.blogspot.com/2014/10/10583-ubiquitous-religions-solution.html
public class Main_10583_UbiquitousReligions {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int testCase = 0;

        while (!(m == 0 && n == 0)) {
            UnionFind uf = new UnionFind(n);

            for (int i = 0; i < m; i++) {
                int student1 = sc.nextInt();
                int student2 = sc.nextInt();
                uf.union(student1 - 1, student2 - 1);
            }

            System.out.printf("Case %d: %d\n", ++testCase, uf.getNumberOfSets());
            n = sc.nextInt();
            m = sc.nextInt();
        }
    }

    static class UnionFind {

        private int[] parents;
        private int[] sizes;
        private int count;

        public UnionFind(int n) {
            parents = new int[n];
            sizes = new int[n];
            count = n;

            for (int i = 0; i < n; i++) {
                parents[i] = i;
                sizes[i] = 1;
            }
        }

        public int getNumberOfSets() {
            return count;
        }

        public int find(int x) {
            ArrayList<Integer> nodes = new ArrayList<>();

            while (x != parents[x]) {
                nodes.add(x);
                x = parents[x];
            }

            for (Integer node : nodes) {
                parents[node] = x;
                sizes[x]--;
            }

            return x;
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py)
                return;

            count--;

            if (sizes[px] < sizes[py]) {
                parents[px] = py;
                sizes[py] += sizes[px];
            } else {
                parents[py] = px;
                sizes[px] += sizes[py];
            }

        }
    }
}
