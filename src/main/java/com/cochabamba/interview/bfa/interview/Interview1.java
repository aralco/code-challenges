package com.cochabamba.interview.bfa.interview;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class Interview1 {

//    ( ( ) ) -> true
//    ( ( ) ) ) -> false
//    ( ) ) ) ( -> false
//    ( ) ( ) ( ) -> true
//    ( ( ) ) )( ( ) ) -> false
//    ) ( -> false
//    ( ( ) ->false

    public static boolean isEven(String s)	{
        boolean result= true;
        LinkedList<Character> stack = new LinkedList<>();
        for(int i=0;i<s.length();i++)	{
            if(s.charAt(i)=='(')	{
                stack.push(s.charAt(i));
            } else if(s.charAt(i)==')')	{
                if(stack.isEmpty()){
                    result = false;
                    break;
                }
                stack.pop();
            }
        }
        if(result && !stack.isEmpty())
            result = false;
        return result;
    }

    @Test
    public void test()  {
        Assert.assertTrue(isEven("(())"));
        Assert.assertFalse(isEven("(()))"));
        Assert.assertFalse(isEven("()))("));
        Assert.assertTrue(isEven("()()()"));
        Assert.assertFalse(isEven("(()))(())"));
        Assert.assertFalse(isEven(")("));
        Assert.assertFalse(isEven("(()"));
    }

}

