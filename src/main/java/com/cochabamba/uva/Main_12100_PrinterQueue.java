import java.util.*;

public class Main_12100_PrinterQueue {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        int[] n = new int[numberOfCases];
        int[] m = new int[numberOfCases];
        List<Integer>[] jobs = new List[numberOfCases];
        Map<Integer,Integer>[] ranking = new Map[numberOfCases];
        for(int i=0;i<numberOfCases;i++)    {
            n[i] = scanner.nextInt();
            m[i] = scanner.nextInt();
            jobs[i] = new ArrayList<>(n[i]);
            ranking[i] = new HashMap<>(9);
            for(int z=0;z<n[i];z++)    {
                ranking[z].put(z+1,0);
            }

            for(int k=0;k<n[i];k++)    {
                int p = scanner.nextInt();
                jobs[i].add(p);
                switch (p)  {
                    case 1:
                        ranking[i].put(1,ranking[i].get(1)+1);
                        break;
                    case 2:
                        ranking[i].put(1,ranking[i].get(1)+1);
                        break;
                    case 3:
                        ranking[i].put(1,ranking[i].get(1)+1);
                        break;
                    case 4:
                        ranking[i].put(1,ranking[i].get(1)+1);
                        break;
                    case 5:
                        ranking[i].put(1,ranking[i].get(1)+1);
                        break;
                    case 6:
                        ranking[i].put(1,ranking[i].get(1)+1);
                        break;
                    case 7:
                        ranking[i].put(1,ranking[i].get(1)+1);
                        break;
                    case 8:
                        ranking[i].put(1,ranking[i].get(1)+1);
                        break;
                    case 9:
                        ranking[i].put(1,ranking[i].get(1)+1);
                        break;
                }

            }
        }
        for(int i=0;i<numberOfCases;i++)    {
            int myTurn = m[i];
            int myPriority = jobs[i].get(m[i]);
            Collections.sort(jobs[i]);
            int others = ranking[i].get(myPriority);
        }
    }
    //https://github.com/izharishaksa/UVa-Solution/blob/master/src/datastructures/builtin/Problem12100YES.java
    /*public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt(), pos = sc.nextInt();
            List<Integer> vi = new ArrayList<Integer>();
            for (int j = 0; j < m; j++) {
                vi.add(sc.nextInt());
            }
            int tot = 0;
            while (true) {
                boolean ada = false;
                for (int j = 1; j < vi.size(); j++) {
                    if (vi.get(j) > vi.get(0)) {
                        ada = true;
                        break;
                    }
                }
                if (!ada) {
                    tot++;
                    vi.remove(0);
                } else {
                    int x = vi.get(0);
                    vi.remove(0);
                    vi.add(x);
                }
                if (pos == 0 && !ada) {
                    break;
                }
                pos--;
                if (pos < 0) {
                    pos = vi.size() - 1;
                }
            }
            System.out.println(tot);
        }
    }*/
}
