package com.cochabamba.interview.deviget.official.expressions;
//package com.codesignal.expressions;

import java.util.Map;

public class Const implements Expression {
    private int value;

    public Const(int value) {
        this.value = value;
    }

    public Const() {
    }

    @Override
    public int evaluate(Map<Character, Integer> arguments) {
        // Write your code here
        return value;
    }

}

