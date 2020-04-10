package com.cochabamba.others;

/**
 * @author ariel.alcocer
 */

public class ComponentInput {
    static class TextInput{
        private String value="";

        public void add(char c) {
            this.value = this.value + c;
        }

        public String getValue()    {
            return this.value;
        }
    }
    static class NumberInput extends TextInput {
        @Override
        public void add(char c) {
            if(Character.isLetter(c))    {
                System.out.println("Only numbers are allowed");
            } else {
                super.add(c);
                System.out.println(super.getValue());
            }
        }
    }

    public static void main(String args[])  {
        TextInput input = new NumberInput();
        input.add('2');
        input.add('5');
        input.add('b');
    }
}
