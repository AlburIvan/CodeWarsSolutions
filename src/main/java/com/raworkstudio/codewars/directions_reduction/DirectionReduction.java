package com.raworkstudio.codewars.directions_reduction;

import javax.management.InstanceNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Ivan Alburquerque on 4/18/2017.
 */
public class DirectionReduction {

    enum Direction {

        NORTH("NORTH"),
        SOUTH("SOUTH"),
        EAST("EAST"),
        WEST("WEST");

        private final String direction;

        Direction(String value) {
            this.direction = value;
        }


        public boolean isAdjacent(String previous) {
            return ((valueOf(direction).ordinal() + 1) ==  valueOf(previous).ordinal());
        }
    }


    public String[] dirReduc(String[] arr) {


        BoundedQueue<String> streamHistory = new BoundedQueue<>();




        ListIterator<String> it = Arrays.asList(arr).listIterator();

        while (it.hasNext()) {
            String t = it.next();
            it.next();
            String prev = it.previous();

            System.out.println("current: " + t + " previous: " + prev);
//            it.next();
        }

      /*  Stream.of(arr)
                .map(streamHistory::save)
                .map(it -> {

//                    if (it.getPrevious() != null) {
                   // System.out.println("Current element is : " + it.getCurrent() + " previous element is: " + it.getPrevious() + " Adjacent? " + Direction.valueOf(it.getCurrent()).isAdjacent(it.getPrevious()));
//                    }

//                    if (it.getPrevious() != null) {
//
//                        System.out.println("Current element is : " + it.getCurrent() + " previous element is: " + it.getPrevious() + " Adjacent? " + Direction.valueOf(it.getCurrent()).isAdjacent(it.getPrevious()));
//
//                        if (Direction.valueOf(it.getCurrent()).isAdjacent(it.getPrevious())) {
//                            System.out.println("is adjacent");
//                        }
//                    }

                    return it;
                })
                .collect(Collectors.toList());*/


        // Your code here.
        return new String[] {};
    }

    class BoundedQueue<T> extends LinkedList<T> {
        public BoundedQueue<T> save(T curElem) {
//            if (size() == 2) { // we need to know only two subsequent elements
//                pollLast(); // remove last to keep only requested number of elements
//            }

            offerFirst(curElem);
            return this;
        }

        public T getPrevious() {
            return (size() < 2) ? null : getLast();
        }

        public T getCurrent() {
            return (size() == 0) ? null : getFirst();
        }

//        public T getNexts() {
//            return (size() == 0) ? null : get();
//        }
    }



}
