/**
 * This kata can be found at:
 *
 *     https://www.codewars.com/kata/a-simple-music-decoder/train/java
 *
 *
 * Description:
 *
 *    You have been hired by a major MP3 player manufacturer to implement a
 *    new music compression standard.
 *
 *    In this kata you will implement the DECODER, and its companion kata deals with the ENCODER.
 *
 *    Specification
 *
 *    The input signal is represented as a comma-separated string of
 *    integers and tokens (sequence descriptors).
 *
 *    Tokens must be expanded as follows:
 *
 *    number*count is expanded as number repeated count times
 *    first-last is expanded as a sequence of consecutive numbers starting with first and ending with last. This is true for both ascending and descending order
 *    first-last/interval is similarly expandad, as sequence starting with first, ending with last, where the numbers are separated by interval. Note that interval does NOT have a sign
 *
 * {@author} Ivan Alburquerque
 */
package com.raworkstudio.codewars.music_decoder;