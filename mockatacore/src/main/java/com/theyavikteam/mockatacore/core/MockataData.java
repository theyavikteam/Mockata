package com.theyavikteam.mockatacore.core;


import com.theyavikteam.mockatacore.annotations.MockConstructor;
import com.theyavikteam.mockatacore.annotations.MockDouble;
import com.theyavikteam.mockatacore.annotations.MockParam;
import com.theyavikteam.mockatacore.types.RandomString;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MockataData {

    public static <T> List<T> createMockData(Class<T> clazz, int mockNumber) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<T> res = new ArrayList();
        for (int i = 0; i < mockNumber; i++) {
//            T mockObject = (T) mockData(clazz, clazz.getConstructors()[0].getGenericParameterTypes());
//            T mockObject = (T) mockData(clazz, readAnnotation(clazz));
            T mockObject = (T) mockData(clazz, getMockConstructor(clazz));
            res.add(mockObject);
        }
        return res;
    }

    public static <T> Object mockData(Class<T> clazz, Type[] types) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object mockData = null;
        Class[] fieldClasses = new Class[types.length];
        Object[] fieldsValues = new Object[types.length];
        for (int i = 0; i < types.length; i++) {
            if (types[i] instanceof Class) {
                Class fieldClass = (Class) types[i];
                fieldClasses[i] = fieldClass;
                fieldsValues[i] = getMockValue(fieldClass.getSimpleName(), null, null);
            } else if (types[i] instanceof ParameterizedType) {
                ParameterizedType parType = ((ParameterizedType) types[i]);
                if (((Class) parType.getRawType()).getSimpleName().equals("List")) {
                    List<Object> lst = new ArrayList<>();
                    for (int j = 0; j < 3; j++) {
                        lst.add(getMockValue(((Class) ((ParameterizedType) types[i]).getActualTypeArguments()[0]).getSimpleName(), null, null));
                    }
                    fieldsValues[i] = lst;
                }
                fieldClasses[i] = List.class;
                ((ParameterizedType) types[i]).getRawType();
            }
        }
        mockData = clazz.getConstructor(fieldClasses).newInstance(fieldsValues);
//        mockData = clazz.getConstructor(Integer.class, Double.class,  Boolean.class).newInstance(mockInteger(), mockDouble(), mockBoolean());

        return mockData;
    }

    public static <T> Object mockData(Class<T> clazz, Constructor<T> constructor) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object mockData = null;
        Type[] types = constructor.getGenericParameterTypes();
        Class[] fieldClasses = new Class[types.length];
        Object[] fieldsValues = new Object[types.length];
        for (int i = 0; i < types.length; i++) {
            if (types[i] instanceof Class) {
                Class fieldClass = (Class) types[i];
                fieldClasses[i] = fieldClass;
//                Annotation mockAnnotation = getAnnotationFromParameter(clazz, constructor.getParameterAnnotations()[i]);
                if (constructor.getParameterAnnotations()[i].length > 0) {
                    fieldsValues[i] = getMockValue(fieldClass.getSimpleName(), clazz, (MockParam) constructor.getParameterAnnotations()[i][0]);
                }else {
                    fieldsValues[i] = getMockValue(fieldClass.getSimpleName(), null, null);
                }
            } else if (types[i] instanceof ParameterizedType) {
                ParameterizedType parType = ((ParameterizedType) types[i]);
                if (((Class) parType.getRawType()).getSimpleName().equals("List")) {
                    List<Object> lst = new ArrayList<>();
                    for (int j = 0; j < 3; j++) {
                        lst.add(getMockValue(((Class) ((ParameterizedType) types[i]).getActualTypeArguments()[0]).getSimpleName(), null, null));
                    }
                    fieldsValues[i] = lst;
                }
                fieldClasses[i] = List.class;
                ((ParameterizedType) types[i]).getRawType();
            }
        }
        mockData = clazz.getConstructor(fieldClasses).newInstance(fieldsValues);
//        mockData = clazz.getConstructor(Integer.class, Double.class,  Boolean.class).newInstance(mockInteger(), mockDouble(), mockBoolean());

        return mockData;
    }

    private static <T> Annotation getAnnotationFromParameter(Class<T> clazz, Annotation[] annotationsParameters) {
        Annotation mockAnnotation = null;
        if (annotationsParameters.length > 0 && annotationsParameters[0] != null && annotationsParameters[0] instanceof MockParam) {
            MockParam mockField = (MockParam) annotationsParameters[0];
            for (int i = 0; i < clazz.getDeclaredFields().length; i++) {
                mockField.fieldName().equals(clazz.getDeclaredFields()[i].getAnnotations()[0]);
            }
            mockField.fieldName().equals("");
        }
        return mockAnnotation;
    }

    public static <T> Object getMockValue(String valueType, Class<T> clazz, MockParam mockParam) {
        Object obj = null;
        switch (valueType) {
            case "Integer":
                obj = mockInteger();
                break;
            case "Long":
                obj = mockLong();
                break;
            case "Float":
                obj = mockFloat();
                break;
            case "Double":
                obj = mockDouble(getMockDouble(clazz, mockParam));
                break;
            case "Boolean":
                obj = mockBoolean();
                break;
            case "Short":
                obj = mockShort();
                break;
            case "String":
                obj = mockString();
                break;
            case "Character":
                obj = mockCharacter();
                break;
            case "Byte":
                obj = mockByte();
                break;
        }
        return obj;
    }

//    public static <T> List<T> createMockData(Class<T> clazz, int mockNumber) throws NoSuchMethodException, NoSuchFieldException {
//        List<T> res = new ArrayList();
//        for (int i = 0; i < mockNumber; i++){
//            try {
//                T mockObject = clazz.getConstructor(Integer.class).newInstance(mockInteger());
//                for (int j = 0; j < mockObject.getClass().getDeclaredFields().length; j++){
//                    Class classField  = mockObject.getClass().getDeclaredFields()[j].getClass();
//                    mockObject.getClass().
//                }
//                res.add(mockObject);
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//
//        }
//        return res;
//    }

    public static <T> Type[] readAnnotation(Class<T> clazz) {
        Type[] types = {};
        for (int c = 0; c < clazz.getConstructors().length; c++) {
            if (clazz.getConstructors()[c].isAnnotationPresent(MockConstructor.class)) {
                types = clazz.getConstructors()[c].getGenericParameterTypes();
                break;
            }
        }
        return types;
    }

    public static <T> Constructor getMockConstructor(Class<T> clazz) {
        Constructor<T> constructor = null;
        for (int c = 0; c < clazz.getConstructors().length; c++) {
            if (clazz.getConstructors()[c].isAnnotationPresent(MockConstructor.class)) {
                constructor = (Constructor<T>) clazz.getConstructors()[c];
                break;
            }
        }
        return constructor;
    }

    public static Integer mockInteger() {
        //TODO Annotation min, max, null value
        return new Random().nextInt(100);
    }

    public static Long mockLong() {
        //TODO Annotation min, max, null value
        Long min = 0L; //assign lower range value
        Long max = 1000000L; //assign upper range value
        return min + (new Random().nextLong() * (max - min));
//        return Long.valueOf(mockInteger().toString());
//        return new Random().nextLong();
    }

    public static Float mockFloat() {
        //TODO Annotation min, max, null value
        Float min = 0.0f;
        Float max = 500.f;
        return new Random().nextFloat() * (max - min) + min;
//        return new Float(mockInteger().toString());
//        return new Random().nextFloat();
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

    public static Double mockDouble(MockDouble mockDouble) {
        Double mockValue = null;
        //TODO Annotation min, max, null value, precision?
        Double min = 0.0;
        Double max = 1000.0;
        if (mockDouble != null) {
            if (new Random().nextInt(100) <= 100 - mockDouble.nullable()) {
                mockValue = mockDouble.min() + (mockDouble.max() - mockDouble.min()) * new Random().nextDouble();
            }
        } else {
            mockValue = min + (max - min) * new Random().nextDouble();
        }
        return mockValue;
//        return new Random().nextDouble();
    }

    public static Short mockShort() {
        //TODO Annotation min, max, null value, precision?
        Integer result = new Random().nextInt(Short.MAX_VALUE + 1);
        return new Short(result.toString());
//        return new Random().nextDouble();
    }

    public static String mockString() {
        return new RandomString(30).nextString();
    }

    public static Character mockCharacter() {
        return new RandomString(5).nextCharacter();
    }

    public static Byte mockByte() {
        return new Byte(((Integer) new Random().nextInt(127)).toString());

    }

    public static Boolean mockBoolean() {
        //TODO Annotation null value?
        return new Random().nextBoolean();
    }


}