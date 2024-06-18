package com.cochabamba.interview.deviget.official.expressions;
//package com.codesignal.expressions;

import java.util.Map;

public class Variable implements Expression {

    private Character var;

    public Variable(Character var) {
        this.var = var;
    }

    public Variable() {
    }

    @Override
    public int evaluate(Map<Character, Integer> arguments) {
        // Write your code here
        if(!arguments.isEmpty())    {
            return arguments.get(var);
        } else {
            throw new UnsupportedOperationException();
        }
    }
}

