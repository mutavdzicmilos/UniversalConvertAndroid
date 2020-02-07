package com.example.drugidomaci.model;

public enum Lenght {
     centimeter,
    feet,
    inch,
    kilometer,
    league,
    meter,
    microinch,
    mile,
    milimeter,
    yard;
    public double value(){
        switch (this){
            case centimeter:return 100;
            case feet: return 3.280839895;
            case inch: return 39.37007874;
            case kilometer:return 0.001;
            case league:return 0.00020712331461;
            case meter: return 1;
            case microinch: return 39370078.74;
            case mile: return  0.00062137119224;
            case milimeter: return 1000;
            case yard: return  1.0936132983;
        }
        return 0;
    }

}
