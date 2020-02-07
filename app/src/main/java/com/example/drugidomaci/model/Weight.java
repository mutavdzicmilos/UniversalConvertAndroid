package com.example.drugidomaci.model;

public enum Weight {
    kilogram,
    miligram,
    ounces,
    pounds,
    tons,
    micrograms,
    gram,
    ;
    public double value(){
        switch (this){
            case kilogram:return 0.001;
            case gram: return 1;
            case miligram: return 1000;
            case ounces:return 0.03527396195;
            case pounds:return 0.0022046226218;
            case tons: return 0.000001;
            case micrograms: return 1000000;

        }
        return 0;
    }

}
