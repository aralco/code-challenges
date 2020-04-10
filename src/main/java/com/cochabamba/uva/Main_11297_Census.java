import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://f0rth3r3c0rd.wordpress.com/2012/04/19/uva-11297-census/
//https://www.cnblogs.com/20143605--pcx/p/5789612.html
public class Main_11297_Census {
    public static int indexOf(int i, int l, int u, int tind) {
        if (l == u)
            return tind;
        int mid = (l + u) >> 1;
        if (i <= mid)
            return indexOf(i, l, mid, (tind << 1) + 1);
        else
            return indexOf(i, mid + 1, u, (tind << 1) + 2);
    }

    public static void update(int i, int val, int[] tree, int len, int q) {
        int tar = indexOf(i, 0, len - 1, 0);
        tree[tar] = val;
        do {
            tar = (tar - 1) >> 1;
            if (q == 0)
                tree[tar] = Math
                        .max(tree[(tar << 1) + 1], tree[(tar << 1) + 2]);
            else
                tree[tar] = Math
                        .min(tree[(tar << 1) + 1], tree[(tar << 1) + 2]);
        } while (tar > 0);
    }

    public static int query(int i, int j, int len, int[] tree, int q) {
        return query(i, j, 0, 0, len - 1, tree, q);
    }

    public static int query(int i, int j, int tind, int ti, int tj, int[] tree,
                            int q) {
        if (i == ti && j == tj)
            return tree[tind];
        int mid = (ti + tj) >> 1;
        if (j <= mid)
            return query(i, j, (tind << 1) + 1, ti, mid, tree, q);
        if (i > mid)
            return query(i, j, (tind << 1) + 2, mid + 1, tj, tree, q);
        else {
            if (q == 0)
                return Math
                        .max(query(i, mid, (tind << 1) + 1, ti, mid, tree, q),
                                query(mid + 1, j, (tind << 1) + 2, mid + 1, tj,
                                        tree, q));
            else
                return Math
                        .min(query(i, mid, (tind << 1) + 1, ti, mid, tree, q),
                                query(mid + 1, j, (tind << 1) + 2, mid + 1, tj,
                                        tree, q));
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer strtok = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(strtok.nextToken());
        int m = Integer.parseInt(strtok.nextToken());
        int[][] min = new int[n][4 * m];
        int[][] max = new int[n][4 * m];
        for (int[] a : min)
            Arrays.fill(a, Integer.MAX_VALUE);
        for (int[] a : max)
            Arrays.fill(a, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            strtok = new StringTokenizer(in.readLine());
            for (int j = 0; j < m; j++) {
                int k = Integer.parseInt(strtok.nextToken());
                update(j, k, max[i], m, 0);
                update(j, k, min[i], m, 1);
            }
        }
        int q = Integer.parseInt(in.readLine());
        while (q-- > 0) {
            String[] arr = in.readLine().split(" ");
            if (arr[0].equals("q")) {
                int a = Integer.parseInt(arr[1]) - 1;
                int b = Integer.parseInt(arr[2]) - 1;
                int c = Integer.parseInt(arr[3]) - 1;
                int d = Integer.parseInt(arr[4]) - 1;
                int r1 = Integer.MIN_VALUE;
                int r2 = Integer.MAX_VALUE;
                for (int i = a; i <= c; i++) {
                    r1 = Math.max(r1, query(b, d, m, max[i], 0));
                    r2 = Math.min(r2, query(b, d, m, min[i], 1));
                }
                System.out.println(r1 + " " + r2);
            } else {
                int a = Integer.parseInt(arr[1]) - 1;
                int b = Integer.parseInt(arr[2]) - 1;
                int c = Integer.parseInt(arr[3]);
                update(b, c, max[a], m, 0);
                update(b, c, min[a], m, 1);
            }
        }
    }
}