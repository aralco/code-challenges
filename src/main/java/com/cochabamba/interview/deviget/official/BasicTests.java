package com.cochabamba.interview.deviget.official;
//package com.codesignal;
//
//import com.codesignal.exceptions.ParseErrorException;
//import com.codesignal.parser.Parser;
//import com.codesignal.parser.impl.ParserImpl;
import com.cochabamba.interview.deviget.official.exceptions.ParseErrorException;
import com.cochabamba.interview.deviget.official.expressions.Expression;
import com.cochabamba.interview.deviget.official.parser.Parser;
import com.cochabamba.interview.deviget.official.parser.impl.ParserImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class BasicTests {

    private Parser parser = new ParserImpl();

    @Test
    public void shouldEvaluateAbsoluteExpression() {
        Expression result = new ParserImpl().parse("abs(-7)");
        int res = result.evaluate(new HashMap<Character, Integer>());
        Assertions.assertEquals(7, res);
    }

    @Test
    public void shouldEvaluateNegateExpression() {
        Expression result = new ParserImpl().parse("-(7)");
        int res = result.evaluate(new HashMap<Character, Integer>());
        Assertions.assertEquals(-7, res);
    }

    @Test
    public void shouldEvaluateMultiplicationExpression() {
        Expression result = new ParserImpl().parse("3*4");
        int res = result.evaluate(new HashMap<Character, Integer>());
        Assertions.assertEquals(12, res);
    }

    private static Stream<Arguments> generateExpressionsWithoutArguments() {
        return Stream.of(
                Arguments.of("239", 239),
                Arguments.of("-23", -23),
                Arguments.of("12 + 43", 55),
                Arguments.of("99 - 32", 67),
                Arguments.of("12 * 3", 36),
                Arguments.of("27 / 9", 3),
                Arguments.of("abs(-7)", 7),
                Arguments.of("abs(239)", 239),
                Arguments.of("81 / 3 / 9", 3),
                Arguments.of("16 - 2 - 18", -4),
                Arguments.of("2 + 32 + 89", 123),
                Arguments.of("2 * 3 * 7", 42),
                Arguments.of("(7 + 9) * (12 - 32)", -320),
                Arguments.of("((3 * 2 - 4) - 1) * 3 - 17", -14),
                Arguments.of("abs(-2) * 13 - 20 + (-5 - 7)", -6),
                Arguments.of("((((-1) + 2) * 11) * 21 / 7 + 2) / 7", 5),
                Arguments.of("-(-(-(-12))) * (-1) * (-1)", 12)
        );
    }

    @ParameterizedTest
    @MethodSource("generateExpressionsWithoutArguments")
    public void shouldEvaluateExpressionWithoutArguments(String expression, int expectedResult) {
        Assertions.assertEquals(expectedResult, parser.parse(expression).evaluate(Collections.emptyMap()));
    }

    private static Stream<Arguments> generateExpressionsWithArguments() {
        return Stream.of(
                Arguments.of(
                        "17 + x",
                        new HashMap<Character, Integer>() {{
                            put('x', 11);
                        }},
                        28
                ),
                Arguments.of("-(23 - x)",
                        new HashMap<Character, Integer>() {{
                            put('x', 23);
                        }},
                        0
                ),
                Arguments.of(
                        "x * (x + y * z) - z",
                        new HashMap<Character, Integer>() {{
                            put('x', 1);
                            put('y', 2);
                            put('z', 3);
                        }},
                        4
                ),
                Arguments.of(
                        "-x * (x / 2 / 3)",
                        new HashMap<Character, Integer>() {{
                            put('x', -12);
                        }},
                        -24
                ),
                Arguments.of(
                        "(a - b) * (a + b)",
                        new HashMap<Character, Integer>() {{
                            put('a', 15);
                            put('b', 13);
                        }},
                        56
                ),
                Arguments.of(
                        "-(-2 * abs(x) * abs(y) + y * y + x * x)",
                        new HashMap<Character, Integer>() {{
                            put('x', -17);
                            put('y', 4);
                        }},
                        -169
                ),
                Arguments.of(
                        "a * a * a - 3 * a * a * b + 3 * a * b * b - b * b * b",
                        new HashMap<Character, Integer>() {{
                            put('a', 11);
                            put('b', 3);
                        }},
                        512
                ),
                Arguments.of(
                        "m * c * c",
                        new HashMap<Character, Integer>() {{
                            put('m', 4);
                            put('c', -3);
                        }},
                        36
                ),
                Arguments.of(
                        "(-b + abs(d)) / (2 * a)",
                        new HashMap<Character, Integer>() {{
                            put('a', -1);
                            put('b', 17);
                            put('d', -31);
                        }},
                        -7
                ),
                Arguments.of(
                        "(((abs(x) + 2) * y) * 21 / 7 + 2) / (-7)",
                        new HashMap<Character, Integer>() {{
                            put('x', -555);
                            put('y', 1);
                        }},
                        -239
                ),
                Arguments.of(
                        "-(-(-(-x))) * (-y) * (-abs(-321))",
                        new HashMap<Character, Integer>() {{
                            put('x', 12);
                            put('y', -3);
                        }},
                        -11556
                )
        );
    }

    @ParameterizedTest
    @MethodSource("generateExpressionsWithArguments")
    public void shouldEvaluateExpressionWithArguments(String expression, Map<Character, Integer> arguments,
                                                      int expectedResult) {
        Assertions.assertEquals(expectedResult, parser.parse(expression).evaluate(arguments));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "(239",
            "-23)",
            "12%2",
            "99^2",
            "--12 * 3",
            "27 // 9",
            "ab(-7)",
            "32.2 - 3",
            "a * a - 2 * ab + b * b",
            "16 - 2 - 18 -",
            "()",
            "abs(-7",
            "X + Y",
    })
    public void shouldThrowParseErrorExceptionWhenExpressionIsInvalid(String expression) {
        Assertions.assertThrows(ParseErrorException.class, () -> parser.parse(expression));
    }

    private static Stream<Arguments> generateNotBalancedExpressions() {
        return Stream.of(
                Arguments.of("(239"),
                Arguments.of("-23)"),
                Arguments.of("abs(-7"));
    }

    @ParameterizedTest
    @MethodSource("generateNotBalancedExpressions")
    public void shouldEvaluateIsBalanced(String expression)   {
        ParserImpl parser1 = new ParserImpl();
        Assertions.assertEquals(false, parser1.isBalanced(expression));
    }

}

