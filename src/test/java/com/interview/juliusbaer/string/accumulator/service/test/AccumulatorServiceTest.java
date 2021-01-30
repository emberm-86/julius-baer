package com.interview.juliusbaer.string.accumulator.service.test;

import com.interview.juliusbaer.string.accumulator.service.service.AccumulatorService;
import org.junit.Assert;
import org.junit.Test;

public class AccumulatorServiceTest {

    @Test
    public void testDefaultDelimiter() {
        Assert.assertEquals(6, AccumulatorService.add("1\n2,3"));
    }

    @Test
    public void testSemiColon() {
        Assert.assertEquals(3, AccumulatorService.add("//;\n1;2"));
    }

    @Test
    public void testMultiDelimiter() {
        Assert.assertEquals(6, AccumulatorService.add("//*|%\n1*2%3"));
    }

    @Test(expected = RuntimeException.class)
    public void testMultiNegativeInput() {
        Assert.assertEquals(6, AccumulatorService.add("//*|%\n1*2%-3"));
    }

    @Test
    public void testLargerThan1000() {
        Assert.assertEquals(6, AccumulatorService.add("//*|%\n1*2%3%1001"));
    }
}
