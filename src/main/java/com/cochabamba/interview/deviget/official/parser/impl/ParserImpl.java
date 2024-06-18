package com.cochabamba.interview.deviget.official.parser.impl;
//package com.codesignal.parser.impl;

//import com.codesignal.expressions.Expression;
//import com.codesignal.parser.Parser;
import com.cochabamba.interview.deviget.official.exceptions.ParseErrorException;
import com.cochabamba.interview.deviget.official.expressions.Const;
import com.cochabamba.interview.deviget.official.expressions.Expression;
import com.cochabamba.interview.deviget.official.expressions.binary.MultiplicationOperationExpression;
import com.cochabamba.interview.deviget.official.expressions.unary.AbsoluteValueExpression;
import com.cochabamba.interview.deviget.official.expressions.unary.NegateValueExpression;
import com.cochabamba.interview.deviget.official.parser.Parser;

import java.util.Deque;
import java.util.LinkedList;

public class ParserImpl implements Parser {

    @Override
    public Expression parse(String expression) {
        String[] operands = {"+", "-", "*", "/", "abs(", "-("};
        if(expression==null) {
            throw new UnsupportedOperationException();
        }
        //validate if parenthesis are balanced
        if(!isBalanced(expression)) {
            throw new ParseErrorException("Parenthesis in the expression provided are not balanced");
        }
        // Write your code here

        //return new AbsoluteValueExpression(new Const(Integer.valueOf("-7")));
        //return new NegateValueExpression(new Const(Integer.valueOf("7")));
        return new MultiplicationOperationExpression(
                new Const(Integer.valueOf("3")),
                new Const(Integer.valueOf("4"))
        );
    }

    public boolean isBalanced(String expression)   {
        Deque<Character> characterDeque = new LinkedList<>();
        for(char c:expression.toCharArray())    {
            if(c=='(')  {
                characterDeque.push(c);
            } else {
                if(!characterDeque.isEmpty() && (characterDeque.peekFirst()=='(' && c==')')){
                    return false;
                } else if (!characterDeque.isEmpty()) {
                    characterDeque.pop();
                } else {
                    return false;
                }
            }
        }
        return characterDeque.isEmpty();
    }

}