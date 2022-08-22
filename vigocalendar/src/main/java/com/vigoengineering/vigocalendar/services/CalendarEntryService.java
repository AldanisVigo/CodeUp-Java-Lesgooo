package com.vigoengineering.vigocalendar.services;

import com.vigoengineering.vigocalendar.models.CalendarEntry;
import com.vigoengineering.vigocalendar.repositories.CalendarEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarEntryService {
    @Autowired
    private CalendarEntryRepository repo;

    public void addNewEvent(CalendarEntry evt){
        repo.save(evt);
    }

    public List<CalendarEntry> getAllEvents(){
        return (List<CalendarEntry>) repo.findAll(); //Cast to ArrayList<CalendarEvent>
    }
}
