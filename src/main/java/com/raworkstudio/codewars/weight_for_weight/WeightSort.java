package com.raworkstudio.codewars.weight_for_weight;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Ivan Alburquerque on 4/19/2017.
 */
public class WeightSort {

    public static String orderWeight(String weights) {
        List<String> list = Arrays.asList(weights.split(" "));

        list.sort((o1, o2) -> {

            int aWeight = Stream.of(o1.split("")).mapToInt(Integer::new).sum();
            int bWeight = Stream.of(o2.split("")).mapToInt(Integer::new).sum();

            return (aWeight - bWeight != 0) ? aWeight - bWeight : o1.compareTo(o2);
        });

        return String.join(" ", list);
    }
}