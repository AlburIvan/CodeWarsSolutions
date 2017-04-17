package com.raworkstudio.codewars.music_decoder;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Ivan on 4/8/2017.
 */
public class MusicDecoderTests {


    private MusicDecoder decoder = new MusicDecoder();



    @Test
    public void test_2_identical_numbers() {
        test("2 identical numbers",new int[] {1,2,2,3},"1,2*2,3");
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
            System.out.println(i);
        }

        assertArrayEquals(description, raw, decoder.uncompress(encoded));
    }

}
