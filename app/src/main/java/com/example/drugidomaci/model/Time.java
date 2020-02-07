package com.example.drugidomaci.model;

public enum Time {
    milisecond,
    second,
    minute,
    hour,
    day,
    week,
    month,
    year,
    decade;
    public double value(){
        switch (this){
            case day:return 1;
            case milisecond: return 86400000;
            case second: return 86400;
            case minute:return 1440;
            case hour:return 24;
            case week: return 0.14285714286;
            case month: return 0.032876712329;
            case year: return  0.0027397260274;
            case decade: return 0.00027397260274;
        }
        return 0;
    }
}
