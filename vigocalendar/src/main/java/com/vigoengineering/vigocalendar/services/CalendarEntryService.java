package com.vigoengineering.vigocalendar.services;

import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.provider.SortDirection;
import com.vigoengineering.vigocalendar.models.CalendarEntry;
import com.vigoengineering.vigocalendar.repositories.CalendarEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CalendarEntryService {
    @Autowired
    private CalendarEntryRepository repo;

    public void addNewEvent(CalendarEntry evt) {
        repo.save(evt);
    }

    public List<CalendarEntry> getAllEvents() {
        return (List<CalendarEntry>) repo.findAll(); //Cast to ArrayList<CalendarEvent>
    }

    private Specification<CalendarEntry> getSpecificationFromFilter(CalendarEntryFilter filter) {
//        if(filter.getEventDate().equals(TodoStatus.COMPLETED)){
//            return TodoSpecification.isComplete();
//        }else if (filter.getStatus().equals(TodoStatus.ONGOING)){
//            return TodoSpecification.isOnGoing();
//        }else {
//            return TodoSpecification.all();
//        }
        if(filter.getEventDate() != null){
            return CalendarEntrySpecification.onDate(filter.getEventDate());
        }else {
            return CalendarEntrySpecification.all();
        }
    }

    public Stream<CalendarEntry> findBy(Query<CalendarEntry, CalendarEntryFilter> query) {
        List<Sort.Order> sortOrders = query.getSortOrders().stream()
                .map(sortQuery -> sortQuery.getDirection().equals(SortDirection.ASCENDING) ? Sort.Order.asc(sortQuery.getSorted()) : Sort.Order.desc(sortQuery.getSorted()) )
                .collect(Collectors.toList());

//        LOGGER.info("----------- Find todos with page {}, size {}, sort {} and optional filter {}", query.getOffset(), query.getLimit(), sortOrders, query.getFilter());

        Pageable page = PageRequest.of(query.getOffset(), query.getLimit(), Sort.by(sortOrders));

        if(query.getFilter().isPresent()){
            Specification<CalendarEntry> specificationFromFilter = getSpecificationFromFilter(query.getFilter().get());

            return repo.findAll(specificationFromFilter, page).stream();
        }else {

            return repo.findAll(page).stream();
        }
    }

    public int countBy(Query<CalendarEntry, CalendarEntryFilter> query) {
        if(query.getFilter().isPresent()){
            Specification<CalendarEntry> specificationFromFilter = getSpecificationFromFilter(query.getFilter().get());
            return (int) repo.count(specificationFromFilter);
        }else {

            return (int)repo.count();
        }
    }
}



