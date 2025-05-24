package com.cochabamba.interview.bfa.interview;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(isEven("(())"));
        assertFalse(isEven("(()))"));
        assertFalse(isEven("()))("));
        assertTrue(isEven("()()()"));
        assertFalse(isEven("(()))(())"));
        assertFalse(isEven(")("));
        assertFalse(isEven("(()"));
    }

}

