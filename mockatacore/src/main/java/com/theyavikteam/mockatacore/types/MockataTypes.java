package com.theyavikteam.mockatacore.types;

import com.theyavikteam.mockatacore.annotations.MockBoolean;
import com.theyavikteam.mockatacore.annotations.MockByte;
import com.theyavikteam.mockatacore.annotations.MockCharacter;
import com.theyavikteam.mockatacore.annotations.MockDouble;
import com.theyavikteam.mockatacore.annotations.MockFloat;
import com.theyavikteam.mockatacore.annotations.MockInteger;
import com.theyavikteam.mockatacore.annotations.MockList;
import com.theyavikteam.mockatacore.annotations.MockLong;
import com.theyavikteam.mockatacore.annotations.MockParam;
import com.theyavikteam.mockatacore.annotations.MockShort;
import com.theyavikteam.mockatacore.annotations.MockString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MockataTypes {

    public static final int PERCENTAGE = 100;
    public static Random random = new Random();

    //TODO RANGE VALUES

    public static Boolean mockBoolean(MockBoolean mockBoolean) {
        Boolean mockValue = null;
        if (mockBoolean != null){
            if (random.nextInt(PERCENTAGE) <= PERCENTAGE - mockBoolean.nullable()){
                mockValue = random.nextBoolean();
            }
        }else {
            mockValue = random.nextBoolean();
        }
        return mockValue;
    }

    public static <T>MockBoolean getMockBoolean(Class<T> clazz, MockParam mockParam){
        MockBoolean mockBoolean = null;
        if (mockParam != null){
            for (int i = 0; i < clazz.getDeclaredFields().length; i++){
                if(clazz.getDeclaredFields()[i].getDeclaredAnnotations().length > 0 && mockParam.fieldName().equals(((MockBoolean)clazz.getDeclaredFields()[i].getDeclaredAnnotations()[0]).name())){
                    mockBoolean = (MockBoolean)clazz.getDeclaredFields()[i].getDeclaredAnnotations()[0];
                    break;
                }
            }
        }
        return mockBoolean;
    }

    public static Byte mockByte(MockByte mockByte) {
        Byte mockValue = null;
        byte min = -128;
        byte max = 127;
        Integer aux = null;
        if (mockByte != null){
            if(random.nextInt(PERCENTAGE) <= PERCENTAGE - mockByte.nullable()){
                aux = mockByte.min() + (mockByte.max() - mockByte.min()) * random.nextInt();
                mockValue = new Byte(aux.toString());
            }
        }else{
            aux = min + (max - min) * random.nextInt();
            mockValue = new Byte(aux.toString());
        }
        return mockValue;
    }

    public static <T>MockByte getMockByte(Class<T> clazz, MockParam mockParam){
        MockByte mockByte = null;
        if (mockParam != null){
            for (int i = 0; i < clazz.getDeclaredFields().length; i++){
                if(clazz.getDeclaredFields()[i].getDeclaredAnnotations().length > 0 && mockParam.fieldName().equals(((MockByte)clazz.getDeclaredFields()[i].getDeclaredAnnotations()[0]).name())){
                    mockByte = (MockByte)clazz.getDeclaredFields()[i].getDeclaredAnnotations()[0];
                    break;
                }
            }
        }
        return mockByte;
    }

    public static Character mockCharacter(MockCharacter mockCharacter) {
        Character mockValue = null;
        if (mockCharacter != null){
            if(random.nextInt(PERCENTAGE) <= PERCENTAGE - mockCharacter.nullable()){
                mockValue = new RandomString(1).nextCharacter();
            }
        }else{
            mockValue = new RandomString(1).nextCharacter();
        }
        return mockValue;
    }

    public static <T> MockCharacter getMockCharacter(Class<T> clazz, MockParam mockParam){
        MockCharacter mockCharacter = null;
        if (mockParam != null){
            for (int i = 0; i < clazz.getDeclaredFields().length; i++){
                if(clazz.getDeclaredFields()[i].getDeclaredAnnotations().length > 0 && mockParam.fieldName().equals(((MockCharacter)clazz.getDeclaredFields()[i].getDeclaredAnnotations()[0]).name())){
                    mockCharacter = (MockCharacter)clazz.getDeclaredFields()[i].getDeclaredAnnotations()[0];
                    break;
                }
            }
        }
        return mockCharacter;
    }

    public static Double mockDouble(MockDouble mockDouble) {
        //TODO precision ?¿
        Double mockValue = null;
        Double min = 0.0;
        Double max = 1000.0;
        if (mockDouble != null) {
            if (random.nextInt(PERCENTAGE) <= PERCENTAGE - mockDouble.nullable()) {
                mockValue = mockDouble.min() + (mockDouble.max() - mockDouble.min()) * random.nextDouble();
            }
        } else {
            mockValue = min + (max - min) * random.nextDouble();
        }
        return mockValue;
    }

    public static <T> MockDouble getMockDouble(Class<T> clazz, MockParam mockParam){
        MockDouble mockDouble = null;
        if (mockParam != null){
            for (int i = 0; i < clazz.getDeclaredFields().length; i++){
                if(clazz.getDeclaredFields()[i].getDeclaredAnnotations().length > 0 && mockParam.fieldName().equals(((MockDouble)clazz.getDeclaredFields()[i].getDeclaredAnnotations()[0]).name())){
                    mockDouble = (MockDouble)clazz.getDeclaredFields()[i].getDeclaredAnnotations()[0];
                    break;
                }
            }
        }
        return mockDouble;
    }

    public static Float mockFloat(MockFloat mockFloat) {
        //TODO precision ?¿
        Float mockValue = null;
        Float min = 0.0f;
        Float max = 500.0f;
        if (mockFloat != null) {
            if (random.nextInt(PERCENTAGE) <= PERCENTAGE - mockFloat.nullable()) {
                mockValue = mockFloat.min() + (mockFloat.max() - mockFloat.min()) * random.nextFloat();
            }
        } else {
            mockValue = min + (max - min) * random.nextFloat();
        }
        return mockValue;
    }

    public static <T> MockFloat getMockFloat(Class<T> clazz, MockParam mockParam){
        MockFloat mockFloat = null;
        if (mockParam != null){
            for (int i = 0; i < clazz.getDeclaredFields().length; i++){
                if(clazz.getDeclaredFields()[i].getDeclaredAnnotations().length > 0 && mockParam.fieldName().equals(((MockFloat)clazz.getDeclaredFields()[i].getDeclaredAnnotations()[0]).name())){
                    mockFloat = (MockFloat)clazz.getDeclaredFields()[i].getDeclaredAnnotations()[0];
                    break;
                }
            }
        }
        return mockFloat;
    }

    public static Integer mockInteger(MockInteger mockInteger) {
        Integer mockValue = null;
        Integer min = 0;
        Integer max = 100;
        if (mockInteger != null){
            if (random.nextInt(PERCENTAGE) <= PERCENTAGE - mockInteger.nullable()){
                mockValue = mockInteger.min() + (mockInteger.max() - mockInteger.min()) * random.nextInt();
            }
        }else {
            mockValue =  min + (max - min) * random.nextInt();
        }
        return mockValue;
    }


    public static <T> MockInteger getMockInteger(Class<T> clazz, MockParam mockParam){
        MockInteger mockInteger = null;
        if (mockParam != null){
            for (int i = 0; i < clazz.getDeclaredFields().length; i++){
                if(clazz.getDeclaredFields()[i].getDeclaredAnnotations().length > 0 && mockParam.fieldName().equals(((MockInteger)clazz.getDeclaredFields()[i].getDeclaredAnnotations()[0]).name())){
                    mockInteger = (MockInteger)clazz.getDeclaredFields()[i].getDeclaredAnnotations()[0];
                    break;
                }
            }
        }
        return mockInteger;
    }

    public static Long mockLong(MockLong mockLong) {
        Long mockValue = null;
        Long min = 0L;
        Long max = 1000000L;
        if (mockLong != null){
            if (random.nextInt(PERCENTAGE) <= PERCENTAGE - mockLong.nullable()) {
                mockValue = mockLong.min() + (mockLong.max() - mockLong.min()) * random.nextLong();
            }
        }else {
            mockValue = min + (random.nextLong() * (max - min));
        }
        return mockValue;
    }

    public static <T> MockLong getMockLong(Class<T> clazz, MockParam mockParam){
        MockLong mockLong = null;
        if (mockParam != null){
            for (int i = 0; i < clazz.getDeclaredFields().length; i++){
                if(clazz.getDeclaredFields()[i].getDeclaredAnnotations().length > 0 && mockParam.fieldName().equals(((MockLong)clazz.getDeclaredFields()[i].getDeclaredAnnotations()[0]).name())){
                    mockLong = (MockLong)clazz.getDeclaredFields()[i].getDeclaredAnnotations()[0];
                    break;
                }
            }
        }
        return mockLong;
    }

    public static Short mockShort(MockShort mockShort) {
        Short mockValue = null;
        Integer aux;
        Short min = 0;
        Short max = 100;
        if (mockShort != null){
            if (random.nextInt(PERCENTAGE) <= PERCENTAGE - mockShort.nullable()){
                aux = mockShort.min() + (mockShort.max() - mockShort.min()) * random.nextInt();
                mockValue = new Short(aux.toString());
            }
        }else {
            aux = min + (max - min) * random.nextInt();
            mockValue =  new Short(aux.toString());
        }
        return mockValue;
    }

    public static <T> MockShort getMockShort(Class<T> clazz, MockParam mockParam){
        MockShort mockShort = null;
        if (mockParam != null){
            for (int i = 0; i < clazz.getDeclaredFields().length; i++){
                if(clazz.getDeclaredFields()[i].getDeclaredAnnotations().length > 0 && mockParam.fieldName().equals(((MockShort)clazz.getDeclaredFields()[i].getDeclaredAnnotations()[0]).name())){
                    mockShort = (MockShort)clazz.getDeclaredFields()[i].getDeclaredAnnotations()[0];
                    break;
                }
            }
        }
        return mockShort;
    }

    public static String mockString(MockString mockString) {
        String mockValue = null;
        int defaultLength = 5;
        if (mockString != null){
            if(random.nextInt(PERCENTAGE) <= PERCENTAGE - mockString.nullable()){
                mockValue = new RandomString(mockString.length()).nextString();
            }
        }else{
            mockValue = new RandomString(defaultLength).nextString();
        }
        return mockValue;
    }

    public static <T> MockString getMockString(Class<T> clazz, MockParam mockParam){
        MockString mockString = null;
        if (mockParam != null){
            for (int i = 0; i < clazz.getDeclaredFields().length; i++){
                if(clazz.getDeclaredFields()[i].getDeclaredAnnotations().length > 0 && mockParam.fieldName().equals(((MockString)clazz.getDeclaredFields()[i].getDeclaredAnnotations()[0]).name())){
                    mockString = (MockString)clazz.getDeclaredFields()[i].getDeclaredAnnotations()[0];
                    break;
                }
            }
        }
        return mockString;
    }

}
