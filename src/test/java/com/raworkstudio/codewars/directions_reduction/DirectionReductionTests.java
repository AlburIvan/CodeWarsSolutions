package com.raworkstudio.codewars.directions_reduction;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Ivan on 4/8/2017.
 */
@SuppressWarnings("ALL")
public class DirectionReductionTests {


    private DirectionReduction directionReduction = new DirectionReduction();


    @Test
    public void test_simple_reduction() {
        assertEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
                new String[]{"WEST"},
                directionReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
    }

    @Test
    public void test_not_reducible_reduction() throws Exception {

        assertEquals("\"NORTH\", \"WEST\", \"SOUTH\", \"EAST\"",
                new String[]{"NORTH", "WEST", "SOUTH", "EAST"},
                directionReduction.dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"}));
    }


    @Test
    public void test_reduction_zero() throws Exception {

        assertEquals("\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"",
                new String[]{},
                    directionReduction.dirReduc(new String[]{ "NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}));
    }




}
