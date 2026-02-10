package org.example;


import org.junit.Test;

import static org.example.Main.*;
import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test
    public void shouldReturnH() {
        //hello -> h
        var result = calculate("hello");
        assertEquals("h",result);
    }
    @Test
    public void shouldReturnB() {
        var result = calculate("aabccd");
        assertEquals("b",result);
    }
    @Test
    public void shouldReturnC() {
        var result = calculate("welcome to java world");
        assertEquals("c",result);
    }
}