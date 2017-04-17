package com.raworkstudio.codewars.music_decoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Ivan Alburquerque on 4/17/2017.
 */
public class MusicDecoder {

    Pattern pattern = Pattern.compile("(\\d+)([$-/:-?{-~!\"^_`\\[\\]])(\\d+)");

    /*
    number*count is expanded as number repeated count times
first-last is expanded as a sequence of consecutive numbers starting with first and ending with last. This is true for both ascending and descending order
first-last/interval is similarly expandad, as sequence starting with first, ending with last, where the numbers are separated by interval. Note that interval does NOT have a sign
     */
    public int[] uncompress(String encoded) {

        String decoded = Stream.of(encoded.split(","))
                .map((String value) -> {

                    if (value.length() == 1)
                        return value;

                    Matcher matcher = pattern.matcher(value);

                    if (matcher.find()) {

                        String decodeSymbol = matcher.group(2);

                        int firstValue = Integer.valueOf(matcher.group(1));
                        int secondValue = Integer.valueOf(matcher.group(3));

                        switch (decodeSymbol) {

                            case "-": {
//

                                if(firstValue > secondValue)
                                {
                                    return IntStream
                                            .rangeClosed(firstValue, secondValue)
                                            .mapToObj(Integer::toString)
                                            .collect(Collectors.joining(", "));

                                }
                                else {
                                    return IntStream
                                            .range(secondValue, firstValue).map(i -> firstValue - i + secondValue - 1)
                                            .mapToObj(Integer::toString)
                                            .collect(Collectors.joining(", "));

                                    //http://stackoverflow.com/questions/24010109/java-8-stream-reverse-order
                                }


                            }

                            case "*": {
                                return String.join(", ", Collections.nCopies(secondValue, String.valueOf(firstValue)));
                            }

                            case "/": {
                                return value;
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
}
