package com.cochabamba.interview.intertec;

import java.util.HashSet;
import java.util.Set;

/*
Write a program that parses a sentence and replaces each word with the following:
1) The first letter of the word
2) The number of distinct characters between first and last character
3) The last letter of the word.
For example, Smooth would become S3h.
Words are separated by spaces or non-alphabetic characters and these separators should be maintained in their original form and location in the answer.
A few of the things we will be looking at is accuracy, efficiency, solution completeness.
*/
class MyCode {
    public static String wordParser(String input) {
        if(input!=null && input.length()>2)    {
            String[] inputs = input.split("[ _\\-.,:;?!]+");
            String[] separators = input.split("[a-zA-Z]+");
            StringBuilder builder = new StringBuilder();
            int i=1;
            for (String s:inputs) {
                builder.append(transform(s));
                if(i<separators.length) {
                    builder.append(separators[i]);
                    i++;
                }
            }
            return builder.toString();
        }
        return input;
    }
    private static String transform(String input)  {
        if(input.length()>2)    {
            char[] words = input.toCharArray();
            Set<Character> diffSet = new HashSet<>();
            for (int i=1;i<words.length-1;i++) {
                diffSet.add(words[i]);
            }
            return ""+words[0]+diffSet.size()+words[words.length-1];
        }
        return input;
    }

    public static void main (String[] args) {
        String output = wordParser("Creativity is thinking-up new things. Innovation is doing new things!");
        System.out.println(output);
        // expected: C6y is t4g-up n1w t4s. I6n is d3g n1w t4s!
    }
}
