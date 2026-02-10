package org.example;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StreamIteratorTest {

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        assertEquals(0, MaxSubarraySum.findMaxSubarraySumStreamIterator(arr));
    }

    @Test
    public void testSingleElementArray() {
        int[] arr = { -2 };
        assertEquals(-2, MaxSubarraySum.findMaxSubarraySumStreamIterator(arr));
    }

    @Test
    public void testAllPositiveNumbers() {
        int[] arr = { 1, 2, 3, 4, 5 };
        assertEquals(15, MaxSubarraySum.findMaxSubarraySumStreamIterator(arr));
    }

    @Test
    public void testAllNegativeNumbers() {
        int[] arr = { -1, -2, -3, -4, -5 };
        assertEquals(-1, MaxSubarraySum.findMaxSubarraySumStreamIterator(arr));
    }

    @Test
    public void testMixedNumbers() {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        assertEquals(6, MaxSubarraySum.findMaxSubarraySumStreamIterator(arr));
    }
}