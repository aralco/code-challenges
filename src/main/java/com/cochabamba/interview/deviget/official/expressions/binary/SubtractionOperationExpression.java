package com.cochabamba.interview.deviget.official.expressions.binary;
//package com.codesignal.expressions.binary;

//import com.codesignal.expressions.Expression;
import com.cochabamba.interview.deviget.official.expressions.Expression;

import java.util.Map;

public class SubtractionOperationExpression extends BinaryOperation {

    public SubtractionOperationExpression(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public int evaluate(Map<Character, Integer> arguments) {
        return Math.subtractExact(leftOperand.evaluate(arguments), rightOperand.evaluate(arguments));
    }
}