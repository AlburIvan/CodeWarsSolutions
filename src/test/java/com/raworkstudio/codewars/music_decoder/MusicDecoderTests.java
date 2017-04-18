package com.raworkstudio.codewars.music_decoder;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Ivan on 4/8/2017.
 */
public class MusicDecoderTests {


    private MusicDecoder decoder = new MusicDecoder();



    @Test
    public void test_negative_identical_numbers() {
        test("2 identical numbers",new int[] {-2,-2},"-2*2");
    }


    @Test
    public void test_complex_numbers() {
        test("2 identical numbers",
                new int[] { 102,102,102,102,102,171,170,188,142,68,100,101,102,103,104,158,161,164,167,37,57,57,57,103,168,26},
                "102*5,171,170,188,142,68,100-104,158-167/3,37,57*3,103,168,26");
    }


    @Test
    public void test_2_identical_numbers() {
        test("2 identical numbers",new int[] {1,2,2,2,3},"1,2*3,3");
    }

    @Test
    public void test_3_consecutive_ascending_numbers() {
        test("3 consecutive numbers, ascending",new int[] {1,3,4,5,7},"1,3-5,7");
    }

    @Test
    public void test_3_consecutive_descending_numbers() {
        test("3 consecutive numbers, descending",new int[] {1,5,4,3,7},"1,5-3,7");
    }

    @Test
    public void basicTests() {
        test("3 numbers with same interval, descending",new int[] {1,10,8,6,7},"1,10-6/2,7");
    }




    private void test(String description,int[] raw,String encoded) {
        System.out.println(encoded);

        for (int i : decoder.uncompress(encoded)) {
            System.out.print(i + ",");
        }

//        System.out.println(decoder.uncompress(encoded).length);

        assertArrayEquals(description, raw, decoder.uncompress(encoded));
    }

}
