package com.theyaviktea.mockatadroid;


import com.theyavikteam.mockatacore.annotations.MockConstructor;
import com.theyavikteam.mockatacore.annotations.MockDouble;
import com.theyavikteam.mockatacore.annotations.MockField;

public class CompleteObject {

    private Integer year;

    private Long million;

    private Float calc;

    @MockDouble(name = "math", nullable = 10)
    private Double math;

    private Double math2;

    private Boolean truth;

    private Short mini;

    private String name;

    public Character start;

    public Byte logic;


    public CompleteObject(Integer year, Long million, Float calc, @MockField(name = "math") Double math, Boolean truth, Short mini, String name, Character start, Byte logic) {
        this.year = year;
        this.million = million;
        this.calc = calc;
        this.math = math;
        this.truth = truth;
        this.mini = mini;
        this.name = name;
        this.start = start;
        this.logic = logic;
    }

    @MockConstructor
    public CompleteObject(Double math2,Double math) {
        this.math2 = math2;
        this.math = math;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getMillion() {
        return million;
    }

    public void setMillion(Long million) {
        this.million = million;
    }

    public Float getCalc() {
        return calc;
    }

    public void setCalc(Float calc) {
        this.calc = calc;
    }

    public Double getMath() {
        return math;
    }

    public void setMath(Double math) {
        this.math = math;
    }

    public Boolean getTruth() {
        return truth;
    }

    public void setTruth(Boolean truth) {
        this.truth = truth;
    }

    public Short getMini() {
        return mini;
    }

    public void setMini(Short mini) {
        this.mini = mini;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getStart() {
        return start;
    }

    public void setStart(Character start) {
        this.start = start;
    }

    public Byte getLogic() {
        return logic;
    }

    public void setLogic(Byte logic) {
        this.logic = logic;
    }

    public Double getMath2() {
        return math2;
    }

    public void setMath2(Double math2) {
        this.math2 = math2;
    }

    @Override
    public String toString() {
        return "Complete{" +
                "math=" + math + " -> type: " +  math.getClass().toString()+
                "math2, =" + math2 +  " -> type: " +  math2.getClass().toString()+'}'+"\n\n";
    }
}
