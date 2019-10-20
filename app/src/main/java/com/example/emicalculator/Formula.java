package com.example.emicalculator;

public class Formula {
    private Double emiCal;

    Formula(Double amt, Double rate, Double time){
        emiCal = (amt * rate * Math.pow(1+rate, time))/ (Math.pow(1+rate, time) - 1);
    }
    Double getEmiCal(){
        return emiCal;
    }
}
