package com.cochabamba.geeksforgeeks;

public class PatternSearchingRabinKarp {

    public static void main(String[] args) {
//        String text = "THIS IS A TEST TEXT";
//        String pattern = "TEST";
        String text = "AABAACAADAABAABA";
        String pattern = "AABA";
//        String text = "AAAAAAAAAAAAAAAAAB";
//        String pattern = "AAAAB";
//        String text = "abracabrabra";
//        String pattern = "abra";

        rabinKarp(text, pattern);
    }

    static void rabinKarp(String text, String pattern) {
        //d = |Σ|
        int d = 256;
        //a prime number
        int q = 13;
        rabinKarp(text, pattern, d, q);

    }

    static void rabinKarp(String text, String pattern, int d, int q) {
        int n = text.length();
        int m = pattern.length();
        int h = (int)Math.pow(d, m-1) % q;
        int p =0;
        int t = 0;
        for(int i=0;i<m;i++)    {//pre-processing O(m)
            p = (d*p + pattern.charAt(i))%q;
            t = (d*t + text.charAt(i))%q;
        }
        for(int s=0;s<=n-m;s++) {//matching O(n-m)*O(m)=O(nm)
            if(p==t)    {
                int j;
                for(j=0;j<m;j++)   {
                    if(pattern.charAt(j) != text.charAt(s+j))
                        break;
                }
                if(j==m)
                    System.out.println("Pattern occurs with shift: "+s);
            }
            if(s<n-m)
                t = (d*(t-text.charAt(s)*h) + text.charAt(s+m)) % q;
            if(t<0)
                t = t+q;
        }

    }
}

