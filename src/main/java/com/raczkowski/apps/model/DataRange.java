package com.raczkowski.apps.model;

import java.time.LocalDate;

public class DataRange {

    private LocalDate startRangeTime;
    private LocalDate endRangeTime;

    LocalDate getStartRangeTime() {
        return startRangeTime;
    }

    LocalDate getEndRangeTime() {
        return endRangeTime;
    }

    public void setStartRangeTime(LocalDate startRangeTime) {
        this.startRangeTime = startRangeTime;
    }

    public void setEndRangeTime(LocalDate endRangeTime) {
        this.endRangeTime = endRangeTime;
    }
}
