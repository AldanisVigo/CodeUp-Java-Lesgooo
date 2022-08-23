package com.vigoengineering.vigocalendar.services;

import java.time.LocalDate;
import java.util.Date;

public class CalendarEntryFilter {
    private LocalDate eventDate;

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate date) {
        this.eventDate = date;
    }
}
