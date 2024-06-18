package com.cochabamba.interview.deviget.official.expressions.binary;
//package com.codesignal.expressions.binary;

//import com.codesignal.expressions.Expression;
import com.cochabamba.interview.deviget.official.expressions.Expression;

public abstract class BinaryOperation implements Expression {

    protected Expression leftOperand;
    protected Expression rightOperand;

    public BinaryOperation(Expression leftOperand, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

}

