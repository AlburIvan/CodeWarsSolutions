package com.raworkstudio.codewars.valid_braces;


public class BraceChecker {


    public BraceChecker() {}


    public boolean isValid(String braces) {

        String temp = "";

        while(temp.length() != braces.length()) {

            temp = braces;

            braces = braces
                    .replace("()","")
                    .replace("{}","")
                    .replace("[]","");
        }

        return (temp.length() == 0);
    }
}