package com.raworkstudio.codewars.valid_braces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ivan on 4/8/2017.
 */
public class BraceCheckerTests {


    private BraceChecker checker = new BraceChecker();

    @Test
    public void test_valid_simple_parentheses() {
        assertEquals(true, checker.isValid("()"));
    }
    @Test
    public void test_valid_multiple_parentheses() {
        assertEquals(true, checker.isValid("()[]{}"));
    }

    @Test
    public void test_invalid_simple_parentheses() {
        assertEquals(false, checker.isValid("[(]"));
    }


    @Test
    public void test_valid_dual_brackets() {
        assertEquals(true, checker.isValid("[()]"));
    }

    @Test
    public void test_invalid_dual_brackets() {
        assertEquals(false, checker.isValid("[(])"));
    }


    @Test
    public void test_valid_complex_brackets() {
        assertEquals(true, checker.isValid("[({})]"));
    }

    @Test
    public void test_invalid_complex_brackets() {
        assertEquals(false, checker.isValid("([())]"));
    }



}
