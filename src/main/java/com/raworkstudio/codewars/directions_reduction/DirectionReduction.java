package com.raworkstudio.codewars.directions_reduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Ivan Alburquerque on 4/18/2017.
 */
public class DirectionReduction {

    private static Pattern pattern = Pattern.compile("NS|SN|WE|EW");


    public static String[] dirReduc(String[] arr) {

        List<String> array = new ArrayList<>();

        Matcher matcher =
                pattern.matcher(Stream.of(arr).map(it -> String.valueOf(it.charAt(0))).collect(Collectors.joining()));

        if (matcher.find()) {
            while (matcher.find()) {
                String tmp = matcher.replaceAll("");

                if(tmp.length() != 0) {
                    array = Arrays.stream(tmp.split(""))
                            .map(it -> it.equals("N") ? "NORTH" : it.equals("S") ? "SOUTH" : it.equals("E") ? "EAST" : it.equals("W") ? "WEST": "")
                            .collect(Collectors.toList());
                }
                else {
                    array = new ArrayList<>();
                }

                matcher = pattern.matcher(tmp);
            }

            return array.toArray(new String[array.size()]);
        }
        else {
            return arr;
        }
    }

}
