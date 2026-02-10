package org.example;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.*;

public class BracketsCheckerTest {

@Test
public void checkBrackets() {
    List<Pair< String, Boolean >> input = createInputList();
    for ( Pair< String, Boolean > pair : input ) {
        assertEquals(pair.getValue(), BracketsChecker.checkBracketsUsingList( pair.getKey() ) );
        assertEquals(pair.getValue(), BracketsChecker.checkBracketsUsingStack( pair.getKey() ) );
    }
}

private List< Pair< String, Boolean > > createInputList() {
    List< Pair< String, Boolean > > input = new ArrayList<>();
    input.add( new Pair<>( "()()", true ) );
    input.add( new Pair<>( "(())", true ) );
    input.add( new Pair<>( "({[]})", true ) );
    input.add( new Pair<>( "((())())", true ) );
    input.add( new Pair<>( "())()", false ) );
    input.add( new Pair<>( "(()", false ) );
    input.add( new Pair<>( "))((", false ) );
    input.add( new Pair<>( "([)]", false ) );
    input.add( new Pair<>( "", true ) );
    return input;
}
        @Test
        public void test01() {
            assertTrue(Main.validateBracketString("()()"));
        }

        @Test
        public void test02() {
           assertTrue(Main.validateBracketString("(())"));
        }

        @Test
        public void test03() {
           assertTrue(Main.validateBracketString("({[]})"));
        }

        @Test
        public void test04() {
           assertTrue(Main.validateBracketString("((())())"));
        }

        @Test
        public void test05() {
           assertFalse(Main.validateBracketString("())()"));
        }

        @Test
        public void test06() {
           assertFalse(Main.validateBracketString("(()"));
        }

        @Test
        public void test07() {
           assertFalse(Main.validateBracketString("))(("));
        }
    @ParameterizedTest
    @CsvSource({"(),true", "([), false"})
    void test(String input, boolean result){

    }
}