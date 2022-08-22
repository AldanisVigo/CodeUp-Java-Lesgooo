package com.vigoengineering.vigocalendar.controllers;

import com.vigoengineering.vigocalendar.models.CalendarEntry;
import com.vigoengineering.vigocalendar.services.CalendarEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping(path="/calendar")
public class CalendarEntryController {
    @Autowired
    private CalendarEntryService calendarEntryService;

    @PostMapping(path="/add_calendar_event")
    public @ResponseBody String addNewEvent (@RequestParam String title, @RequestParam String description) {
        CalendarEntry newEvent = new CalendarEntry();
        newEvent.setTitle(title);
        newEvent.setDescription(description);
        calendarEntryService.addNewEvent(newEvent);
        return "Saved";
    }

    @PostMapping(path="/all")
    public @ResponseBody List<CalendarEntry> getAllEvents() {
        return calendarEntryService.getAllEvents();
    }
}