package com.raczkowski.apps.model;

import java.time.LocalDate;
import java.util.Comparator;

public class LocalDateComparator implements Comparator<LocalDate> {
    @Override
    public int compare(LocalDate localDate1, LocalDate localDate2) {
        if (localDate1.getYear() > localDate2.getYear()) {
            return 1;
        } else if (localDate1.getYear() < localDate2.getYear()) {
            return -1;
        } else {
            if (localDate1.getMonthValue() > localDate2.getMonthValue()) {
                return 1;
            } else if (localDate1.getMonthValue() < localDate2.getMonthValue()) {
                return -1;
            } else {
                if (localDate1.getDayOfMonth() > localDate2.getDayOfMonth()) {
                    return 1;
                } else if (localDate1.getDayOfMonth() < localDate2.getDayOfMonth()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
