package com.theyavikteam.mockatacore.core;

import com.theyavikteam.mockatacore.annotations.MockConstructor;
import com.theyavikteam.mockatacore.annotations.MockParam;
import com.theyavikteam.mockatacore.types.MockataTypes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Mockata {

    public static <T> List<T> createMockata(Class<T> clazz, int mockNumber) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<T> mockatas = new ArrayList<>();
        for (int i = 0; i < mockNumber; i++) {
            T mockItem = (T) createMockItem(clazz, getMockConstructor(clazz));
            mockatas.add(mockItem);

        }
        return mockatas;
    }

    private static <T> Object createMockItem(Class<T> clazz, Constructor<T> mockConstructor) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object mockItem = null;
        //TODO not parameters at constructor case
        Type[] parameterTypes = mockConstructor.getGenericParameterTypes();
        Class[] fieldsClasses = new Class[parameterTypes.length];
        Object[] fieldsValues = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i] instanceof Class) {
                Class paramClass = (Class) parameterTypes[i];
                fieldsClasses[i] = paramClass;
                if (mockConstructor.getParameterAnnotations()[i].length > 0) {
                    fieldsValues[i] = getMockValue(paramClass.getSimpleName(), clazz, (MockParam) mockConstructor.getParameterAnnotations()[i][0]);
                } else {
                    fieldsValues[i] = getMockValue(paramClass.getSimpleName(), null, null);

                }
            } else if (parameterTypes[i] instanceof ParameterizedType) {

            }
        }

        mockItem = clazz.getConstructor(fieldsClasses).newInstance(fieldsValues);
        return mockItem;
    }

    private static <T> Constructor getMockConstructor(Class<T> clazz) {
        //TODO Mock Constructor not found
        Constructor<T> mockConstructor = null;
        for (int i = 0; i < clazz.getConstructors().length; i++) {
            if (clazz.getConstructors()[i].isAnnotationPresent(MockConstructor.class)) {
                mockConstructor = (Constructor<T>) clazz.getConstructors()[i];
                break;
            }
        }
        return mockConstructor;
    }

    private static <T> Object getMockValue(String valueType, Class<T> clazz, MockParam mockParam) {
        Object mockValue = null;
        switch (valueType) {
            case "Boolean":
                mockValue = MockataTypes.mockBoolean(MockataTypes.getMockBoolean(clazz, mockParam));
                break;
            case "Byte":
                mockValue = MockataTypes.mockByte(MockataTypes.getMockByte(clazz, mockParam));
                break;
            case "Character":
                mockValue = MockataTypes.mockCharacter(MockataTypes.getMockCharacter(clazz, mockParam));
                break;
            case "Double":
                mockValue = MockataTypes.mockDouble(MockataTypes.getMockDouble(clazz, mockParam));
                break;
            case "Float":
                mockValue = MockataTypes.mockFloat(MockataTypes.getMockFloat(clazz, mockParam));
                break;
            case "Integer":
                mockValue = MockataTypes.mockInteger(MockataTypes.getMockInteger(clazz, mockParam));
                break;
            case "Long":
                mockValue = MockataTypes.mockLong(MockataTypes.getMockLong(clazz, mockParam));
                break;
            case "Short":
                mockValue = MockataTypes.mockShort(MockataTypes.getMockShort(clazz, mockParam));
                break;
            case "String":
                mockValue = MockataTypes.mockString(MockataTypes.getMockString(clazz, mockParam));
                break;
        }
        return mockValue;
    }

}
