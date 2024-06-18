package com.cochabamba.interview.deviget.official.parser;
//package com.codesignal.parser;

//import com.codesignal.expressions.Const;
//import com.codesignal.expressions.Expression;
//import com.codesignal.expressions.Variable;
//import com.codesignal.expressions.binary.AdditionOperationExpression;
//import com.codesignal.expressions.binary.DivisionOperationExpression;
//import com.codesignal.expressions.binary.MultiplicationOperationExpression;
//import com.codesignal.expressions.binary.SubtractionOperationExpression;
//import com.codesignal.expressions.unary.AbsoluteValueExpression;
//import com.codesignal.expressions.unary.NegateValueExpression;
import com.cochabamba.interview.deviget.official.expressions.Const;
import com.cochabamba.interview.deviget.official.expressions.Expression;
import com.cochabamba.interview.deviget.official.expressions.Variable;
import com.cochabamba.interview.deviget.official.expressions.binary.AdditionOperationExpression;
import com.cochabamba.interview.deviget.official.expressions.binary.DivisionOperationExpression;
import com.cochabamba.interview.deviget.official.expressions.binary.MultiplicationOperationExpression;
import com.cochabamba.interview.deviget.official.expressions.binary.SubtractionOperationExpression;
import com.cochabamba.interview.deviget.official.expressions.unary.AbsoluteValueExpression;
import com.cochabamba.interview.deviget.official.expressions.unary.NegateValueExpression;


public interface Parser {

    /**
     * This method parses string representation of the arithmetic expression to java object representation.
     * <p>
     * For example, variables and constants can be represented with the corresponding classes {@link Variable} and
     * {@link Const};
     * <p>
     * Binary operations like "1 + 2", "121 / 11" can be represented with classes {@link
     * AdditionOperationExpression},{@link SubtractionOperationExpression}, {@link MultiplicationOperationExpression}
     * and {@link DivisionOperationExpression}
     * <p>
     * For unary operations like absolute value {@code abs(-5)} or negation {@code -(19))} the following classes can be
     * used: {@link AbsoluteValueExpression},  {@link NegateValueExpression}
     * <p>
     * Expressions can easily nest each other, so even complex expressions like "(((abs(x) + 2) * y) * 21 / 7 + 2) /
     * (-7)" can be parsed.
     *
     * @param expression - the expression to parse.
     * @return java object representing the arithmetic expression
     */
    Expression parse(String expression);
}
