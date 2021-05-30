package com.interview.juliusbaer.string.accumulator.service.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AccumulatorService {

    private final static String DEFAULT_DELIMITER = "[,\\n]";

    public static int add(String numbers) {
        String[] parsedResultListStr = getParsedInputElements(numbers);

        List<Integer> parsedResultListInt = Arrays.stream(parsedResultListStr)
                .filter(AccumulatorService::isNumber)
                .map(Integer::parseInt).collect(Collectors.toList());

        if (parsedResultListInt.stream().anyMatch(x -> x < 0)) {
            throw new RuntimeException("negatives not allowed");
        }

        return parsedResultListInt.stream()
                .filter(x -> x < 1001).reduce(0, Integer::sum);
    }

    private static String[] getParsedInputElements(String numbers) {
        String delimiter = DEFAULT_DELIMITER;

        if (numbers.startsWith("//")) {
            int firstEnter = numbers.indexOf('\n');

            delimiter = (numbers.substring(2, firstEnter) + "|\\\\n")
                    .replaceAll("\\*", "\\\\*");

            numbers = numbers.substring(firstEnter + 1);
        }

        return numbers.split(delimiter);
    }

    private static boolean isNumber(String str) {
        if (str.charAt(0) == '-') {
            str = str.substring(1);
        }

        if (str.charAt(0) == '0' && str.length() > 1) {
            return false;
        }

        return str.chars().allMatch(Character::isDigit);
    }
}
