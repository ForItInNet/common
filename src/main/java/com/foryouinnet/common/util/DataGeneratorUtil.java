package com.foryouinnet.common.util;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class DataGeneratorUtil {

    final static String INVALID_RANDOM_NUMBER_SIZE_MESSAGE = "Size of random number cannot be null or less/equals zero";

    public static String generateRandomNumber(int size) throws IllegalArgumentException {

        if(size <= 0) {
            throw new IllegalArgumentException(INVALID_RANDOM_NUMBER_SIZE_MESSAGE);
        }

        Random random = new Random();
        return Stream.generate(() -> String.valueOf(random.nextInt(10)))
                .limit(size)
                .collect(Collectors.joining());
    }
}
