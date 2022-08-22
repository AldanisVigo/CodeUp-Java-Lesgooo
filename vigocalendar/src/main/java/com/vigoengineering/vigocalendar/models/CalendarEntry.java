package com.vigoengineering.vigocalendar.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class CalendarEntry {
    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    private String eventTitle;

    private String eventDescription;

    public CalendarEntry() {
    }

    public CalendarEntry(String eventTitle, String eventDescription) {
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return eventTitle;
    }

    public void setTitle(String title) {
        this.eventTitle = title;
    }

    public String getDescription() {
        return eventDescription;
    }

    public void setDescription(String description) {
        this.eventDescription = description;
    }

    @Override
    public String toString() {
        return String.format("CalendarEvent[id=%d, eventTitle='%s', eventDescription='%s']", id, eventTitle, eventDescription);
    }

}

