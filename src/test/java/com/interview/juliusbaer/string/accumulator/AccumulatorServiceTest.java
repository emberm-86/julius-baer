package com.interview.juliusbaer.string.accumulator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccumulatorServiceTest {

    @Test
    public void testDefaultDelimiter() {
        Assertions.assertEquals(6, AccumulatorService.add("1\n2,3"));
    }

    @Test
    public void testSemiColon() {
        Assertions.assertEquals(3, AccumulatorService.add("//;\n1;2"));
    }

    @Test
    public void testMultiDelimiter() {
        Assertions.assertEquals(6, AccumulatorService.add("//*|%\n1*2%3"));
    }

    @Test
    public void testNegativeInput() {
        Assertions.assertThrows(RuntimeException.class,
                () -> AccumulatorService.add("//*|%\n1*2%-3"));
    }

    @Test
    public void testLargerThan1000() {
        Assertions.assertEquals(6, AccumulatorService.add("//*|%\n1*2%3%1001"));
    }
}
