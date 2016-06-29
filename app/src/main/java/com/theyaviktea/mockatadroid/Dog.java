package com.theyaviktea.mockatadroid;

import com.theyavikteam.mockatacore.annotations.MockConstructor;

public class Dog {

    private Integer years;

    private Double month;

    private Boolean today;

    @MockConstructor
    public Dog(Integer years, Double month, Boolean today) {
        this.years = years;
        this.month = month;
        this.today = today;
    }

    public Dog() {
    }



    public Dog(Double month) {
        this.month = month;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Double getMonth() {
        return month;
    }

    public void setMonth(Double month) {
        this.month = month;
    }

    public Boolean getToday() {
        return today;
    }

    public void setToday(Boolean today) {
        this.today = today;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "years=" + years +
                ", month=" + month +
                ", today=" + today +
                '}';
    }
}
