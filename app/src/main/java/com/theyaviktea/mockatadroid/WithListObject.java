package com.theyaviktea.mockatadroid;

import java.util.List;

public class WithListObject {
    private List<Integer> integers;

    private List<String> strings;

    private Double count;

    public WithListObject(List<Integer> integers, List<String> strings, Double count) {
        this.integers = integers;
        this.strings = strings;
        this.count = count;
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

    @Override
    public String toString() {
        return "WithList{" +
                "integers=" + integers +
                ", strings=" + strings +
                ", count=" + count +
                '}';
    }
}

