package com.raworkstudio.codewars.music_decoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MusicDecoder {

    private Pattern pattern = Pattern.compile("(^\\-?\\d+)([$-/:-?{-~!\"^_`\\[\\]])(.*)");

    public int[] uncompress(String encoded) {

        String decoded = Stream.of(encoded.split(","))
                .map((String value) -> {

                    if (value.length() == 1)
                        return value;

                    Matcher matcher = pattern.matcher(value);

                    if (matcher.find()) {

                        String decodeSymbol = matcher.group(2);

                        int firstValue = Integer.valueOf(matcher.group(1));
                        int secondValue = 0;
                        int step = 0;

                        String thirdSymbol = matcher.group(3);

                        if (thirdSymbol.contains("/")) {
                            secondValue = Integer.valueOf(thirdSymbol.substring(0, thirdSymbol.indexOf("/") ));
                            step = Integer.valueOf(thirdSymbol.substring(thirdSymbol.indexOf("/") + 1));
                        } else {
                            secondValue = Integer.valueOf(thirdSymbol);
                        }

                        switch (decodeSymbol)
                        {
                            case "-": {
                                return inRange(firstValue, secondValue, step);
                            }

                            case "*": {
                                return String.join(", ", Collections.nCopies(secondValue, String.valueOf(firstValue)));
                            }
                        }
                    }

                    return value;
                })
                .collect(Collectors.joining(", "));

        return Arrays.stream(decoded.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
    }


    private String inRange(int from, int to, int step) {
        if(from < to) {
            String temp ="";
            while(from <= to) {
                temp += from + ", ";
                from += (step == 0) ? 1 : step;
            }
            return temp.substring(0, temp.length() - 2);
        }
        else {
            String temp ="";
            while(from >= to) {
                temp += from + ", ";
                from -= (step == 0) ? 1 : step;
            }
            return temp.substring(0, temp.length() - 2);
        }
    }
}
