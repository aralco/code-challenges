import java.util.Scanner;

public class Main_11172_RelationalOperator {

    //11172 - Relational Operator
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t, a, b;
        t = in.nextInt();
        for(int i=0;i<t;i++) {
            a = in.nextInt();
            b = in.nextInt();
            if(a>b)
                System.out.println(">");
            else    {
                if(a==b)
                    System.out.println("=");
                else
                    System.out.println("<");
            }
        }
    }
}
