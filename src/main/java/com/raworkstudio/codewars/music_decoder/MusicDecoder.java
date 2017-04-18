package com.raworkstudio.codewars.music_decoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Ivan Alburquerque on 4/17/2017.
 */
public class MusicDecoder {

    private Pattern pattern = Pattern.compile("(\\d+)([$-/:-?{-~!\"^_`\\[\\]])(.*)");

    public int[] uncompress(String encoded) {

        String decoded = Stream.of(encoded.split(","))
                .map((String value) -> {

                    if (value.length() == 1)
                        return value;

                    Matcher matcher = pattern.matcher(value);

                    if (matcher.find()) {

                        String decodeSymbol = matcher.group(2);

                        int firstValue = Integer.valueOf(matcher.group(1));
                        int secondValue = Integer.valueOf(matcher.group(1));


                        String thirdSymbol =  matcher.group(3); // 6/2 // pattern.matcher(matcher.group(3))
                        System.out.println("input: " + thirdSymbol);

                        switch (decodeSymbol) {

                            case "-": {
                                return inRange(firstValue, secondValue);
                            }

                            case "*": {
                                return String.join(", ", Collections.nCopies(secondValue, String.valueOf(firstValue)));
                            }

                            case "/": {
                                return IntStream
                                        .rangeClosed(secondValue, firstValue)
                                        .map(i -> (firstValue - i + secondValue) / 2)
                                        .mapToObj(Integer::toString)
                                        .collect(Collectors.joining(", "));
                            }
                        }

                    }

                    return value;
                })
                .collect(Collectors.joining(", "));

        return Arrays.stream(decoded.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt).toArray();
    }


    private String inRange(int from, int to) {
        if(from < to)
        {
            return IntStream
                    .rangeClosed(from, to)
                    .mapToObj(Integer::toString)
                    .collect(Collectors.joining(", "));
        }
        else {
            return IntStream
                    .rangeClosed(to, from)
                    .map(i -> from - i + to)
                    .mapToObj(Integer::toString)
                    .collect(Collectors.joining(", "));
        }
    }
}
