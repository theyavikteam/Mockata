package com.theyavikteam.mockatacore.core.types.wrapper;

import java.util.Random;

public class MockataWrapperTypes {

    private static Random random = new Random();
    //TODO Byte, Charactar, Short, Integer, Long, Float, Double
    public static Boolean mockBoolean(){
        return random.nextBoolean();
    }

    public static Byte mockByte(){
        return new Byte("127");
    }



}
