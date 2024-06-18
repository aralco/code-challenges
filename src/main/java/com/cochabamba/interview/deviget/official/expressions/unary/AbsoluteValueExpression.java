package com.cochabamba.interview.deviget.official.expressions.unary;
//package com.codesignal.expressions.unary;

//import com.codesignal.expressions.Expression;
import com.cochabamba.interview.deviget.official.expressions.Expression;

import java.util.Map;
public class AbsoluteValueExpression extends UnaryExpression {
    public AbsoluteValueExpression(Expression operand) {
        super(operand);
    }

    @Override
    public int evaluate(Map<Character, Integer> arguments) {
        // Write your code here
        return Math.abs(operand.evaluate(arguments));
    }
}
