package com.vigoengineering.vigocalendar.repositories;
import com.vigoengineering.vigocalendar.models.CalendarEntry;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarEntryRepository extends PagingAndSortingRepository<CalendarEntry, Long>, JpaSpecificationExecutor<CalendarEntry> {
    @Override
    List<CalendarEntry> findAll();

//    Long countByCompleted(Boolean status);
}
