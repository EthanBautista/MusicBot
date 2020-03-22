package com.jagrosh.jmusicbot;

import java.util.Random;

public class Utilities {

    public static double randomDouble(double min, double max){

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return min + (double) (Math.random() * (max - min));
    }

    public static int randomInt(int min, int max){

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return min + (int) (Math.random() * (max - min));
    }

}

