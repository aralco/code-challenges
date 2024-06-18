package com.cochabamba.interview.deviget.official.expressions.unary;
//package com.codesignal.expressions.unary;

//import com.codesignal.expressions.Expression;
import com.cochabamba.interview.deviget.official.expressions.Expression;

public abstract class UnaryExpression implements Expression {

    protected Expression operand;

    public UnaryExpression(Expression operand) {
        this.operand = operand;
    }
}
