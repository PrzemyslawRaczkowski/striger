package com.raczkowski.apps.model;

import java.time.LocalDate;
import java.util.Comparator;

public class LocalDateComparator implements Comparator<LocalDate> {
    @Override
    public int compare(LocalDate localDate1, LocalDate localDate2) {
        int difference = localDate1.compareTo(localDate2);
        int value;
        if (difference > 0) {
            value=-1;
        } else if (difference == 0) {
            int differenceOfMonth = localDate1.getMonth().compareTo(localDate2.getMonth());
            if (differenceOfMonth > 0) {
                value=-1;
            } else if (differenceOfMonth == 0) {
                int differenceOfDay = localDate1.getDayOfWeek().compareTo(localDate2.getDayOfWeek());
                value= Integer.compare(0, differenceOfDay);
            } else {
                value=1;
            }
        } else {
            value=1;
        }
        return value;
    }
}
