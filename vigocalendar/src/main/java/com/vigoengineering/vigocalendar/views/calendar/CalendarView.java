package com.vigoengineering.vigocalendar.views.calendar;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vigoengineering.vigocalendar.models.CalendarEntry;
import com.vigoengineering.vigocalendar.services.CalendarEntryFilter;
import com.vigoengineering.vigocalendar.services.CalendarEntryService;
import com.vigoengineering.vigocalendar.views.MainView;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;

@PageTitle("Calendar")
@Route(value = "calendar", layout = MainView.class)
public class CalendarView extends VerticalLayout {
    DatePicker cal;
    Grid<CalendarEntry> event_grid;
    HorizontalLayout topMenu;
    TextField newEntryTitleTextField;
    TextArea newEntryDescriptionTextArea;
    DataProvider entryDataProvider;
    @Autowired
    private final CalendarEntryService entryService;

    public CalendarView(CalendarEntryService entryService) {
        //Set properties
        this.entryService = entryService;
        setMargin(true);
        setAlignItems(Alignment.START);
        //Create content
        add(createCalendarTopMenu(),createEventsGridElement());
    }

    private HorizontalLayout createCalendarTopMenu(){
        topMenu = new HorizontalLayout();
        topMenu.setMaxWidth("340px");
        topMenu.add(createCalendarElement(),createCalendarEntryButton());
        return topMenu;
    }

    private Button createCalendarEntryButton() {
        Button addCalendarEntryBtn = new Button("Add Entry");
        addCalendarEntryBtn.addClickListener(e->{
            Dialog addEventDialog = new Dialog();
            addEventDialog.add(createCalendarEntryDialogContent());
            addEventDialog.add(createCalendarEntryDialogActions(addEventDialog));
            addEventDialog.open();
        });

        return addCalendarEntryBtn;
    }

    private HorizontalLayout createCalendarEntryDialogActions(Dialog dialog){
        HorizontalLayout layout = new HorizontalLayout();

        //Button to close the dialog
        Button closeButton = new Button("Close");
        closeButton.addClickListener(e->{
            dialog.close();
        });

        //Add entry button
        Button addEntryButton = new Button("Add Entry");
        addEntryButton.addClickListener(e-> {
                try {
                    String newEntryTitle = newEntryTitleTextField.getValue();
                    String newEntryDescription = newEntryDescriptionTextArea.getValue();

                    System.out.printf("Entry Title %s\n", newEntryTitle);
                    System.out.printf("Entry Description: %s\n", newEntryDescription);

                    CalendarEntry newEntry = new CalendarEntry();
                    newEntry.setTitle(newEntryTitle);
                    newEntry.setDescription(newEntryDescription);
                    entryService.addNewEvent(newEntry);
                    entryDataProvider.refreshAll();
                    dialog.close();
                }catch(Exception exception){
                    System.out.println("+++++++++ERROR FOUND+++++++");
                    System.out.println("CalendarView.java line 75");
                    System.out.println(exception.getStackTrace());
                }
        });

        layout.add(closeButton,addEntryButton);

        return layout;
    }


    private VerticalLayout createCalendarEntryDialogContent(){
        VerticalLayout layout = new VerticalLayout();

        //Title TextField
        newEntryTitleTextField = new TextField();
        newEntryTitleTextField.setPlaceholder("Entry Title");

        //Description TextField
        newEntryDescriptionTextArea = new TextArea();
        newEntryDescriptionTextArea.setPlaceholder("Entry Description");

        layout.add(newEntryTitleTextField);
        layout.add(newEntryDescriptionTextArea);

        return layout;
    }

    private Grid<CalendarEntry> createEventsGridElement(){
        event_grid = new Grid<>(CalendarEntry.class, false);
        event_grid.addColumn(CalendarEntry::getId).setHeader("Event ID");
        event_grid.addColumn(CalendarEntry::getTitle).setHeader("Event Title");
        event_grid.addColumn(CalendarEntry::getDescription).setHeader("Event Description");
        Query<CalendarEntry, CalendarEntryFilter> calendarDateFilter = new Query<>();
        LocalDate calDate = cal.getValue();
        calendarDateFilter.getFilter().get().setEventDate(calDate);
        entryDataProvider = DataProvider.fromFilteringCallbacks(entryService::findBy,entryService::countBy).withConfigurableFilter();

        event_grid.setItems(entryDataProvider);
        event_grid.addCellFocusListener(entry->{
            System.out.println(entry.getItem().get().getTitle());
        });
        event_grid.setWidth("70%");
//        List<CalendarEntry> calendarEntries = entryService.getAllEvents();
//        event_grid.setItems(calendarEntries);
        return event_grid;
    }

    private DatePicker createCalendarElement(){
        cal = new DatePicker();
        cal.setWidth("600px");
        cal.setHeight("300px");
        return cal;
    }
}
