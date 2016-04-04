package com.theyaviktea.mockatadroid;

import com.theyavikteam.mockatacore.annotations.MockConstructor;

import java.util.List;

public class WithListObject {
    private List<Integer> integers;

    private List<String> strings;

    private List<Integer> numbers;

    private Double count;

    @MockConstructor
    public WithListObject(List<Integer> integers, List<String> strings,List<Integer> numbers, Double count) {
        this.integers = integers;
        this.strings = strings;
        this.count = count;
        this.numbers = numbers;
    }

    public List<Integer> getIntegers() {
        return integers;
    }

    public void setIntegers(List<Integer> integers) {
        this.integers = integers;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
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

