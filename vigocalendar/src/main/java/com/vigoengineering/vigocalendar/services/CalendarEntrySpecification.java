package com.vigoengineering.vigocalendar.services;

import com.vigoengineering.vigocalendar.models.CalendarEntry;
import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class CalendarEntrySpecification {

    public static Specification<CalendarEntry> onDate(LocalDate date) {
        return (root, query, cb) -> cb.equal(root.get("date"), date);
    }

    public static Specification<CalendarEntry> all() {
        return (root, query, cb) -> cb.isNotNull(root.get(""));
    }
}
