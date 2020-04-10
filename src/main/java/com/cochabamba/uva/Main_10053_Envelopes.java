import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_10053_Envelopes {
    public static void main(String args[])  {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            //M
            int m = scanner.nextInt();
            //N
            int n = scanner.nextInt();

            if(m==0 || n==0)
                break;
            int [] cards = new int[m];
            int li;
            int wi;
            for(int i=0;i<m;i++)    {
                li = scanner.nextInt();
                wi = scanner.nextInt();
                cards[i] = li*wi;
            }
            int [][] envelopes = new int[n][2];
            int l;
            int w;
            int c;

            for(int j=0;j<n;j++)    {
                l = scanner.nextInt();
                w = scanner.nextInt();
                c = scanner.nextInt();
                envelopes[j][0] = l*w;
                envelopes[j][1] = c;
            }

            int [] minEnvelopeCostIndexes = new int[m];
            for(int i=0;i<cards.length;i++) {
                minEnvelopeCostIndexes[i] = -1;
                int minEnvelopeCostIndex = 0;
                for(int j=0;j<envelopes.length;j++) {
                    if(cards[i]<=envelopes[j][0])   {
                        minEnvelopeCostIndex = envelopes[j][1]<=envelopes[minEnvelopeCostIndex][1]?j:minEnvelopeCostIndex;
                        minEnvelopeCostIndexes[i] = minEnvelopeCostIndex;
                    }
                }
            }
            System.out.println("Case ");
            for (int index:minEnvelopeCostIndexes) {
                if(index==-1)
                    System.out.println("cannot buy");
                else
                    System.out.println(index+1);
            }
            System.out.println(Arrays.toString(minEnvelopeCostIndexes));
        }
        System.out.println("END");
    }
}
