import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

//https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1520
public class Main_10579_FibonacciNumbers {
    public static void main(String[] args)  {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int n;
        try {
            while((input=bufferedReader.readLine())!=null)    {
                n = Integer.valueOf(input);
                System.out.println(fibonacciNonRecursive(n));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static BigInteger fibonacciNonRecursive(int n)   {
        BigInteger fib0 = BigInteger.ZERO;
        BigInteger fib1 = BigInteger.ONE;
        BigInteger fibN = BigInteger.ZERO;
        if(n==0)
            fibN=fib0;
        if(n==1)
            fibN = fib1;
        for(int i=2;i<=n;i++)   {
            fibN = fib0.add(fib1);
            fib0 = fib1;
            fib1 = fibN;
        }
        return fibN;
    }
}
