package com.vigoengineering.vigocalendar.repositories;
import com.vigoengineering.vigocalendar.models.CalendarEntry;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarEntryRepository extends CrudRepository<CalendarEntry, Long> {
}
