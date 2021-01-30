package com.interview.juliusbaer.string.accumulator.service;

import com.interview.juliusbaer.string.accumulator.service.service.AccumulatorService;

public class Main {

    public static void main(String[] args) {
        System.out.println(AccumulatorService.add("1\n2,3"));
        System.out.println(AccumulatorService.add("//;\n1;2"));
        System.out.println(AccumulatorService.add("//*|%\n1*2%3"));
    }
}
