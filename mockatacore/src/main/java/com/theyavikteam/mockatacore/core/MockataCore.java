package com.theyavikteam.mockatacore.core;

import com.theyavikteam.mockatacore.annotations.MockConstructor;
import com.theyavikteam.mockatacore.exceptions.MockConstructorException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MockataCore {

    /**
     * Create a List of MockData items from an Object.
     *
     * @param clazz      Class of the Object
     * @param mockNumber Number of MockData items;
     **/
    public static <T>List<T> createMockata(Class<T> clazz, int mockNumber){
        List<T> mockatas = new ArrayList<>();
        Constructor<T> mockConstructor = null;
        try {
            mockConstructor = (Constructor<T>) getMockConstructor(clazz);
        }catch (MockConstructorException e){
            e.printStackTrace();
        }
        if (mockConstructor != null){
            for (int i = 0; i < mockNumber; i++){
                T mockItem = null;
                try {
                    mockItem = (T)createMockItem(clazz, mockConstructor);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
                mockatas.add(mockItem);
            }
        }
        return mockatas;
    }

    /**
     * Search a Constructor with @MockConstructor annotation to create Mockata items.
     *
     * @param clazz      Class of the Object
     **/
    private static <T> Constructor getMockConstructor(Class<T> clazz) throws MockConstructorException{
        Constructor<T> mockConstructor = null;
        for (int i = 0; i < clazz.getConstructors().length; i++) {
            if (clazz.getConstructors()[i].isAnnotationPresent(MockConstructor.class)) {
                mockConstructor = (Constructor<T>) clazz.getConstructors()[i];
                break;
            }
        }
        if (mockConstructor == null){
            throw new MockConstructorException();
        }else {
            return mockConstructor;
        }
    }


    private static <T>Object createMockItem(Class<T> clazz, Constructor<T> mockConstructor) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Object mockItem = null;
        //Check Constructor params
        Type[] parameterTypes = mockConstructor.getGenericParameterTypes();
        //if constructor have params
        if (parameterTypes.length > 0){
            Class[] fieldsClasses = new Class[parameterTypes.length];
            Object[] fieldsValues = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i ++){

            }
        }else {
            //if empty constructor;
            mockItem = mockConstructor.newInstance();
        }
        return mockItem;
    }
}
