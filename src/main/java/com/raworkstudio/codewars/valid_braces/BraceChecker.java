package com.raworkstudio.codewars.valid_braces;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BraceChecker {

    private Pattern pattern = Pattern.compile("(\\((.*?)\\))(\\{(.*?)\\})(\\[(.*?)\\])");

    public BraceChecker() {}


    public boolean isValid(String input) {

        if ((input.length() % 2 != 0)) {
            return false;
        }

        Matcher matcher = pattern.matcher(input);

        System.out.println("Input is: " + input + " matches: " + matcher.matches());

        if (matcher.matches()) {
            System.out.println("group 1" + matcher.group(1));
            System.out.println("group 1" + matcher.group(2));
            System.out.println("group 1" + matcher.group(3));
        }
        return matcher.matches();
    }

}