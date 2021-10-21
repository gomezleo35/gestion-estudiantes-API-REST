package com.consultasestudiantes.utils;

import java.util.List;

public class ObtainAverage {

    public static Double obtainAverage(List<Double> grades){

        Double acm = 0.0;
        for (Double g : grades){
            acm += g;
        }

        return acm / grades.size();
    }
}
