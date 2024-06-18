package com.cochabamba.interview.bairesdev;

// Write a function that returns true if the brackets in a given string are balanced.
// The function must handle parenthesis (), square brackets [], and curly braces {}.

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MyCode {
    public static void main (String[] args) {
        System.out.println("(a[0]+b[2c[6]]) {24 + 53}  passed:" + parensMatch("(a[0]+b[2c[6]]) {24 + 53}"));
        System.out.println("f(e(d))                    passed:" + parensMatch("f(e(d))"));
        System.out.println("[()]{}([])                 passed:" + parensMatch("[()]{}([])"));
        System.out.println("((b)                       passed:" + !parensMatch("((b)"));
        System.out.println("(c]                        passed:" + !parensMatch("(c]"));
        System.out.println("{(a[])                     passed:" + !parensMatch("{(a[])"));
        System.out.println("([)]                       passed:" + !parensMatch("([)]"));
        System.out.println(")(                         passed:" + !parensMatch(")("));
        System.out.println(" (empty)                   passed:" + parensMatch(""));

        System.out.println("(]]{]{}                   passed:" + !parensMatch("(]]{]{}"));
        System.out.println("}[])]                   passed:" + !parensMatch("}[])]"));
    }

    //best Solution
    public static boolean parensMatch(String sentence){
        boolean result = true;
        char[] sentences = sentence.toCharArray();
        LinkedList<String > list = new LinkedList<>();
        for(char s :sentences)  {
            if(s=='(' || s=='[' || s=='{'){
                list.push(String.valueOf(s));
            } else if(s==')' || s==']' || s=='}'){
                if(list.isEmpty() || !isBalanced(list.pop(), String.valueOf(s))) {
                    result = false;
                    break;
                }
            }
        }
        if(result && !list.isEmpty())
            result = false;
        return result;
    }

    public static boolean isBalanced(String open, String close) {
        boolean result = false;
        switch (open)  {
            case "(":
                result = close.equals(")");
                break;
            case "[":
                result = close.equals("]");
                break;
            case "{":
                result = close.equals("}");
                break;
        }
        return result;
    }

    //better solution
    public static boolean parensMatch1(String sentence){
        boolean result = true;
        char[] sentences = sentence.toCharArray();
        LinkedList<String > list = new LinkedList<>();
        for(char s :sentences)  {
            if(s=='(')  {
                list.add(String.valueOf(s));
            }else if(s=='['){
                list.add(String.valueOf(s));
            }else if(s=='{'){
                list.add(String.valueOf(s));
            } else if(s==')'){
                if(!list.isEmpty())
                    result = list.removeLast().equals("(");
            }else if(s==']'){
                if(!list.isEmpty())
                    result = list.removeLast().equals("[");
            }else if(s=='}'){
                if(!list.isEmpty())
                    result = list.removeLast().equals("{");
            }
        }
        if(!list.isEmpty())
            result = false;
        return result;
    }

    //dummy partial solution
    public static boolean parensMatch0(String sentence){
        boolean result;
        char[] sentences = sentence.toCharArray();
        Map<String, Integer> freq = new HashMap<>();
        freq.put("hpO",0);
        freq.put("hpC",0);
        freq.put("sbO",0);
        freq.put("sbC",0);
        freq.put("cbO",0);
        freq.put("cbC",0);
        for(int i=0;i<sentences.length;i++)  {
            if(sentences[i]=='(')  {
                freq.put("hpO",freq.get("hpO")+1);
            } else if(sentences[i]==')'){
                freq.put("hpC",freq.get("hpC")+1);
            }else if(sentences[i]=='['){
                freq.put("sbO",freq.get("sbO")+1);
            }else if(sentences[i]==']'){
                freq.put("sbC",freq.get("sbC")+1);
            }else if(sentences[i]=='{'){
                freq.put("cbO",freq.get("cbO")+1);
            }else if(sentences[i]=='}'){
                freq.put("cbC",freq.get("cbC")+1);
            }
        }
        result = freq.get("hpO").equals(freq.get("hpC"));
        result = result && freq.get("sbO").equals(freq.get("sbC"));
        result = result && freq.get("cbO").equals(freq.get("cbC"));
        return result;
    }

    @Test
    public void test()  {
        Assert.assertTrue(parensMatch("(())"));
        Assert.assertFalse(parensMatch("(()))"));
        Assert.assertFalse(parensMatch("()))("));
        Assert.assertTrue(parensMatch("()()()"));
        Assert.assertFalse(parensMatch("(()))(())"));
        Assert.assertFalse(parensMatch(")("));
        Assert.assertFalse(parensMatch("(()"));
    }

}