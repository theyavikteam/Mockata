package com.theyaviktea.mockatadroid;

import com.theyavikteam.mockatacore.annotations.MockConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class WithListObject {
    private List<Integer> integers;

    private List<String> strings;

    private List<Integer> numbers;

    private Map<String, Integer> map;

    private Date date;

    private String[] array;

    private Double count;

    @MockConstructor
    public WithListObject(List<Integer> integers, List<String> strings, List<Integer> numbers, Map<String, Integer> map, Date date, String[] array, Double count) {
        this.integers = integers;
        this.strings = strings;
        this.numbers = numbers;
        this.map = map;
        this.date = date;
        this.array = array;
        this.count = count;
    }


    public List<Integer> getIntegers() {
        return integers;
    }

    public void setIntegers(List<Integer> integers) {
        this.integers = integers;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "WithList{" +
                "integers=" + integers +
                ", strings=" + strings +
                ", count=" + count + ',' +
                "numbers=" + numbers +
                '}';
    }
}

