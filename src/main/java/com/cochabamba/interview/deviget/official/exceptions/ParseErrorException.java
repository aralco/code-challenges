package com.cochabamba.interview.deviget.official.exceptions;
//package com.codesignal.exceptions;

//import com.codesignal.parser.Parser;
import com.cochabamba.interview.deviget.official.parser.Parser;

/**
 * This expression must be used whenever the expression provided to the {@link Parser#parse(java.lang.String)} method is
 * not a well formed arithmetic expression.
 */
public class ParseErrorException extends RuntimeException {

    public ParseErrorException() {
        super();
    }

    public ParseErrorException(String message) {
        super(message);
    }
}