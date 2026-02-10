package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrepSecondAttemptTest {

    PrepSecondAttempt prepSecondAttempt = new PrepSecondAttempt();
    @Test
    public void shouldBeHappyNumber(){
        assertTrue(prepSecondAttempt.isNumberHappy(23));
    }
    @Test
    public void shouldBeUnhappyNumber(){
        assertFalse(prepSecondAttempt.isNumberHappy(4));
    }
}